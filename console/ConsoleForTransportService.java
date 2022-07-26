package courseworke3.console;

import courseworke3.models.drivers.DriverQualificationEnum;
import courseworke3.models.transports.Bus;
import courseworke3.models.transports.Tram;
import courseworke3.models.transports.Transport;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleForTransportService extends ConsoleMain {

    public ConsoleForTransportService() {
        super();
    }

    protected void serviceForTransports() throws InterruptedException {
        System.out.println("============================================================================================" +
                "\nВведите номер желаемого действия: \n" +
                "\nДобавить транспорт введите - 1 " +
                "\nУдалить транспорт введите - 2" +
                "\nНайти транспорт по id введите - 3 " +
                "\nНайти все транспорты введите - 4 " +
                "\nНайти транспорт по марке введите - 5 " +
                "\nНайти все транспорты без водителей - 6 " +
                "\nДобавить транспорт на заданный маршрут - 7 " +
                "\nУдалить транспорт с заданного маршрута - 8 " +
                "\nВернуться в главное меню - 9 ");

        Scanner in1 = new Scanner(System.in);
        int switcher = in1.nextInt();

        switch (switcher) {
            case 1:
                addTransport();
                timerForTransports();
                break;
            case 2:
                Scanner in2 = new Scanner(System.in);
                System.out.println("Введите id транспорта который хотите удалить: ");
                int id = in2.nextInt();
                transportService.removeTransport(id);
                timerForTransports();
                break;
            case 3:
                Scanner in3 = new Scanner(System.in);
                System.out.println("Введите id транспорта который хотите найти : ");
                int id2 = in3.nextInt();
                System.out.println("Транспорт: " + transportService.findTransportById(id2));
                timerForTransports();
                break;
            case 4:
                System.out.println("Список транспортов: " + transportService.findAllTransports());
                timerForTransports();
                break;
            case 5:
                Scanner in4 = new Scanner(System.in);
                System.out.println("Введите марку транспортов которые хотите найти: ");
                String brand = in4.nextLine();
                System.out.println("Список транспортов: " + transportService.findTransportByBrand(brand));
                timerForTransports();
                break;
            case 6:
                System.out.println("Список транспортов: " + transportService.findTransportWithoutDriver());
                timerForTransports();
                break;
            case 7:
                Scanner in5 = new Scanner(System.in);
                System.out.println("Введите id транспорта который хотите добавить: ");
                int id5 = in5.nextInt();

                System.out.println("Введите маршрута куда хотите добавить транспорт:");
                int id6 = in5.nextInt();

                transportService.addTransportToRoute(id5, routeService.findRouteById(id6));
                timerForTransports();
                break;
            case 8:
                Scanner in6 = new Scanner(System.in);
                System.out.println("Введите id транспорта который хотите удалить: ");
                int idTr = in6.nextInt();

                System.out.println("Введите маршрута от куда хотите удалить транспорт:");
                int idR = in6.nextInt();

                transportService.removeTransportFromRoute(transportService.findTransportById(idTr), routeService.findRouteById(idR));
                timerForTransports();
                break;

            case 9:
                startPanel();
                break;

            default:
                System.out.println("Некоректный ввод ! Попробуйте снова");
                serviceForTransports();
        }
    }

    private void addTransport() {
        Scanner in = new Scanner(System.in);
        Transport bus;
        Transport tram = null;

        System.out.println("Какой транспорт вы хотите создать ?");
        System.out.println("Автобус - введите 1");
        System.out.println("Трамвай - введите 2");
        int switchTransports = in.nextInt();

        //создание автобуса
        try {
            switch (switchTransports) {
                case 1:
                    System.out.println("Введите id автобуса: \"id должно быть целым числом и не может быть меньше 0\" ");
                    int id = in.nextInt();
                    if (id % 2 != 1 && id % 2 != 0) {
                        System.err.println("Введенное число не являеться целым ! Возвращаю на начало создания транспорта");
                        addTransport();
                    } else if (id < 0) {
                        System.err.println("Введенное число меньше 0 ! Возвращаю на начало создания транспорта");
                        addTransport();
                    } else {
                        Scanner in1 = new Scanner(System.in);
                        System.out.println("Введите марку автобуса: ");
                        String brand = in1.nextLine();

                        System.out.println("Введите количество пассажиров в автобусе:");
                        int passangers = in1.nextInt();
                        if (passangers % 2 != 1 && passangers % 2 != 0) {
                            System.err.println("Введенное число не являеться целым ! Возвращаю на начало создания транспорта");
                            addTransport();
                        } else if (passangers < 0) {
                            System.err.println("Введенное число меньше 0 ! Возвращаю на начало создания транспорта");
                            addTransport();
                        } else {
                            Scanner in2 = new Scanner(System.in);
                            System.out.println("Введите тип транспорта:");
                            String type = in2.nextLine();

                            System.out.println("Введите количество дверей в автобусе");
                            int doors = in2.nextInt();
                            if (doors % 2 != 1 && doors % 2 != 0) {
                                System.err.println("Введенное число не являеться целым ! Возвращаю на начало создания транспорта");
                                addTransport();
                            } else if (doors < 0) {
                                System.err.println("Введенное число меньше 0 ! Возвращаю на начало создания транспорта");
                                addTransport();
                            } else {
                                bus = new Bus(id, brand, passangers, false,
                                        DriverQualificationEnum.BUS_DRIVER, type, doors);
                                transportService.addTransport(bus);
                                System.out.println("------------------------------------------------------------------------------------");
                                System.out.println("Вы успешно создали автобус: " + bus);
                                System.out.println("------------------------------------------------------------------------------------");
                            }
                        }
                    }
                    break;

                case 2:
                    in = new Scanner(System.in);
                    System.out.println("Введите id трамвая: \"id должно быть целым числом и не может быть меньше 0\" ");
                    id = in.nextInt();
                    if (id % 2 != 1 && id % 2 != 0) {
                        System.err.println("Введенное число не являеться целым ! Возвращаю на начало создания транспорта");
                        addTransport();
                    } else if (id < 0) {
                        System.err.println("Введенное число меньше 0 ! Возвращаю на начало создания транспорта");
                        addTransport();
                    } else {
                        System.out.println("Введите марку трамвая: ");
                        Scanner in1 = new Scanner(System.in);
                        String brand = in1.nextLine();
                        System.out.println("Введите количество пассажиров в трамвае:");
                        int passangers = in1.nextInt();
                        if (passangers % 2 != 1 && passangers % 2 != 0) {
                            System.err.println("Введенное число не являеться целым ! Возвращаю на начало создания транспорта");
                            addTransport();
                        } else if (passangers < 0) {
                            System.err.println("Введенное число меньше 0 ! Возвращаю на начало создания транспорта");
                            addTransport();
                        } else {
                            Scanner in2 = new Scanner(System.in);
                            System.out.println("Введите количество вагонов в трамвае:");
                            int railcar = in2.nextInt();
                            if (railcar % 2 != 1 && railcar % 2 != 0) {
                                System.err.println("Введенное число не являеться целым ! Возвращаю на начало создания транспорта");
                                addTransport();
                            } else if (railcar < 0) {
                                System.err.println("Введенное число меньше 0 ! Возвращаю на начало создания транспорта");
                                addTransport();
                            } else {
                                tram = new Tram(id, brand, passangers, false,
                                        DriverQualificationEnum.TRAM_DRIVER, railcar);
                            }
                        }
                    }
                    transportService.addTransport(tram);
                    System.out.println("------------------------------------------------------------------------------------");
                    System.out.println("Вы успешно создали трамвай: " + tram);
                    System.out.println("------------------------------------------------------------------------------------");
                    break;

                default: {
                    System.err.println("Введено некоректное значение ! Возвращаю на начало создание транспорта !");
                    addTransport();
                }
            }

        } catch (InputMismatchException e) {
            System.err.println("Введено некоректное значение ! Возвращаю на начало создание транспорта !");
            addTransport();
        }
    }

    private void timerForTransports() throws InterruptedException {
        System.out.println("Через 5 секунд возвращаю в меню сервиса транспорта !");
        Thread.sleep(5000);
        serviceForTransports();
    }
}
