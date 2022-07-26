package courseworke3.console;

import courseworke3.models.drivers.Driver;
import courseworke3.models.drivers.DriverQualificationEnum;

import java.util.Scanner;

public class ConsoleForDriverService extends ConsoleMain {

    public ConsoleForDriverService() {
        super();
    }

    protected void serviceForDrivers() throws InterruptedException {
        System.out.println("============================================================================================" +
                "\nВведите номер желаемого действия: \n" +
                "\nДобавить водителя введите - 1 " +
                "\nУдалить водителя введите - 2" +
                "\nДобавить водителя на транспорт - 3" +
                "\nНайти водителя по id введите - 4 " +
                "\nНайти всех водителей введите - 5 " +
                "\nНайти водителя(-ей) по фамилии введите - 6 " +
                "\nНайти водителя(-ей) на указанном маршруте - 7 " +
                "\nНайти все транспорты без водителей - 8 " +
                "\nВернуться в главное меню - 9 ");

        Scanner in1 = new Scanner(System.in);
        int switcher = in1.nextInt();
        switch (switcher) {
            case 1:
                addDriver();
                timerForDrivers();
                break;

            case 2:
                Scanner in2 = new Scanner(System.in);
                System.out.println("Введите id водителя которого хотите удалить: ");
                int id = in2.nextInt();
                driverService.removeDriver(id);
                timerForDrivers();
                break;

            case 3:
                Scanner in3 = new Scanner(System.in);
                System.out.println("Введите id водителя которого хотите добавить на транспорт: ");
                int idOfDriver = in3.nextInt();

                System.out.println("Введите id траснпорта на который хотите добавить водителя: ");
                int idOfTransport = in3.nextInt();

                driverService.addDriverOnTransport(driverService.findDriverById(idOfDriver), transportService.findTransportById(idOfTransport));
                timerForDrivers();
                break;

            case 4:
                Scanner in4 = new Scanner(System.in);
                System.out.println("Введите id водителя которого хотите найти: ");
                int idOfDriver2 = in4.nextInt();
                System.out.println("Водитель: " + driverService.findDriverById(idOfDriver2));
                timerForDrivers();
                break;

            case 5:
                System.out.println("Список водителей: " + driverService.findAllDrivers());
                timerForDrivers();
                break;

            case 6:
                Scanner in5 = new Scanner(System.in);
                System.out.println("Введите фамилию водителя(-ей) которого хотите найти: ");
                String surnameOfDriver = in5.nextLine();
                System.out.println("Водитель: " + driverService.findAllDriversBySurname(surnameOfDriver));
                timerForDrivers();
                break;
            case 7:
                Scanner in6 = new Scanner(System.in);
                System.out.println("Введите id маршрута: ");
                int idOfRoute = in6.nextInt();
                driverService.findAllDriversOnRoute(routeService.findRouteById(idOfRoute));
                timerForDrivers();
                break;

            case 8:
                System.out.println("Транспорты без водителей: \n" + routeService.findAllRoutesWithoutTransport());
                timerForDrivers();
                break;

            case 9:
                super.startPanel();
                break;

            default:
                System.out.println("Некоректный ввод ! Попробуйте снова");
                serviceForDrivers();
        }
    }

    private void addDriver() {
        System.out.println("Введите id водителя: ");
        Scanner in1 = new Scanner(System.in);
        int id = in1.nextInt();
        if (id < 0) {
            System.out.println("Введено некоректное значение ! Возвращаю в начало добавления водителя !");
            addDriver();
        } else {
            System.out.println("Введите имя водителя: ");
            Scanner in2 = new Scanner(System.in);
            String name = in2.nextLine();
            if (name == null) {
                System.out.println("Введено некоректное значение ! Возвращаю в начало добавления водителя !");
                addDriver();
            } else {
                System.out.println("Введите фамилию водителя: ");
                Scanner in3 = new Scanner(System.in);
                String surname = in3.nextLine();
                if (surname == null) {
                    System.out.println("Введено некоректное значение ! Возвращаю в начало добавления водителя !");
                    addDriver();
                } else {
                    System.out.println("Введите номер телефона водителя: ");
                    Scanner in4 = new Scanner(System.in);
                    String number = in4.nextLine();
                    if (number == null) {
                        System.out.println("Введено некоректное значение ! Возвращаю в начало добавления водителя !");
                        addDriver();
                    } else {
                        System.out.println("Введите квалификацию водителя: \n1 - водитель автобуса;" +
                                "\n2 - водитель трамвая");
                        Scanner in5 = new Scanner(System.in);
                        int quality = in5.nextInt();
                        DriverQualificationEnum driverQualificationEnum = null;

                        switch (quality) {
                            case 1:
                                driverQualificationEnum = DriverQualificationEnum.BUS_DRIVER;
                                break;
                            case 2:
                                driverQualificationEnum = DriverQualificationEnum.TRAM_DRIVER;
                                break;
                            default:
                                System.out.println("Введено некоректное значение ! Возвращаю в начало добавления водителя !");
                        }
                        Driver driver = new Driver(id, name, surname, number, driverQualificationEnum);
                        driverService.addDriver(driver);
                        System.out.println("------------------------------------------------------------------------------------");
                        System.out.println("Вы успешно добавили водителя: " + driver);
                        System.out.println("------------------------------------------------------------------------------------");
                    }
                }
            }
        }
    }

    private void timerForDrivers() throws InterruptedException {
        System.out.println("Через 5 секунд возвращаю в меню сервиса водителей !");
        Thread.sleep(5000);
        serviceForDrivers();
    }
}
