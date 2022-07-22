package courseworke3;

import courseworke3.models.Route;
import courseworke3.models.drivers.Driver;
import courseworke3.models.drivers.DriverQualificationEnum;
import courseworke3.models.transports.Bus;
import courseworke3.models.transports.Tram;
import courseworke3.models.transports.Transport;
import courseworke3.repositories.implementation.DriversRepoImpl;
import courseworke3.repositories.implementation.RouteRepoImpl;
import courseworke3.repositories.implementation.TransportRepoImpl;
import courseworke3.repositories.repointerfaces.DriversRepo;
import courseworke3.repositories.repointerfaces.RouteRepo;
import courseworke3.repositories.repointerfaces.TransportRepo;
import courseworke3.services.implementation.DriverServiceImpl;
import courseworke3.services.implementation.RouteServiceImpl;
import courseworke3.services.implementation.TransportServiceImpl;
import courseworke3.services.interfaces.DriverService;
import courseworke3.services.interfaces.RouteService;
import courseworke3.services.interfaces.TransportService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsolePanel {

    private final TransportService transportService;
    private final DriverService driverService;
    private final RouteService routeService;

    static {
        System.out.println("Добро пожаловать в программу управления автопарком !");
    }

    public ConsolePanel() throws InterruptedException {
        TransportRepo transportRepo = new TransportRepoImpl();
        this.transportService = new TransportServiceImpl(transportRepo);

        DriversRepo driversRepo = new DriversRepoImpl();
        this.driverService = new DriverServiceImpl(driversRepo, transportRepo);

        RouteRepo routeRepo = new RouteRepoImpl();
        this.routeService = new RouteServiceImpl(routeRepo);

        startPanel();
    }

    private void startPanel() throws InterruptedException {
        System.out.println("============================================================================================");
        System.out.println("Главное меню ! \nВведите действие которое хотите выполнить !");
        System.out.println("Добавить транспорт - введите \"1\" ");
        System.out.println("Добавить маршрут - введите \"2\" ");
        System.out.println("Добавить водителя - введите \"3\" ");
        System.out.println("Сервис работы с транспортом - введите \"4\" ");
        System.out.println("Сервис работы с маршрутами - введите \"5\" ");
        System.out.println("Сервис работы с водителями - введите \"6\" ");
        System.out.println("Выйти из программы - введите \"7\" ");

        try {
            Scanner in = new Scanner(System.in);
            int number = in.nextInt();

            switch (number) {
                case 1:
                    addTransport();
                    timerForStartPanel();
                    break;
                case 2:
                    addRoute();
                    timerForStartPanel();
                    break;
                case 3:
                    addDriver();
                    timerForStartPanel();
                    break;
                case 4:
                    serviceForTransports();
                    break;
                case 5:
                    serviceForRouts();
                    break;
                case 6:
                    serviceForDrivers();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Введено некоректное значение ! Возвращаю в главное меню !");
                    startPanel();
            }
        } catch (InputMismatchException e) {
            System.err.println("Введено недопустимое значение ! Возвращаю в начало !");
            startPanel();
        }
    }

    private void addTransport() {
        Scanner in = new Scanner(System.in);
        Transport bus = null;
        Transport tram = null;

        System.out.println("Какой транспорт вы хотите создать ?");
        System.out.println("Автобус - введите 1");
        System.out.println("Трамвай - введите 2");
        int switchTransports = in.nextInt();

        //создание автобуса
        try {
            if (switchTransports == 1) {
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
                        }
                    }
                }
                transportService.addTransport(bus);
                System.out.println("Вы успешно создали автобус: " + bus);
            }
            //создание трамвая
            if (switchTransports == 2) {
                System.out.println("Введите id трамвая: \"id должно быть целым числом и не может быть меньше 0\" ");
                int id = in.nextInt();
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
                System.out.println("Вы успешно создали трамвай: " + tram);
            }
        } catch (InputMismatchException e) {
            System.err.println("Введено некоректное значение ! Возвращаю на начало создание транспорта !");
            addTransport();
        }
    }

    private void addRoute() {
        System.out.println("Введите id маршрута");
        Scanner in = new Scanner(System.in);
        int id = in.nextInt();
        if (id < 0) {
            System.out.println("Введено некоректное значение ! Возвращаю на начало создание маршрута !");
            addRoute();
        } else {
            System.out.println("Введите начало маршрута");
            Scanner in1 = new Scanner(System.in);
            String start = in1.nextLine();
            if (start == null) {
                System.out.println("Введено некоректное значение ! Возвращаю на начало создание маршрута !");
                addRoute();
            } else {
                System.out.println("Введите конец маршрута");
                Scanner in2 = new Scanner(System.in);
                String end = in2.nextLine();
                if (end == null) {
                    System.out.println("Введено некоректное значение ! Возвращаю на начало создание маршрута !");
                    addRoute();
                } else {
                    Route route = new Route(id, start, end, false);
                    routeService.addRoute(route);
                    System.out.println("Вы успешно создали маршрут: " + route);
                }
            }
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
                        System.out.println("Вы успешно добавили водителя: " + driver);
                    }
                }
            }
        }
    }

    private void serviceForDrivers() throws InterruptedException {
        System.out.println("===========================================================================================");
        System.out.println("Введите номер желаемого действия: \n");
        System.out.println("Добавить водителя введите - 1 ");
        System.out.println("Удалить водителя введите - 2");
        System.out.println("Добавить водителя на транспорт - 3");
        System.out.println("Найти водителя по id введите - 4 ");
        System.out.println("Найти всех водителей введите - 5 ");
        System.out.println("Найти водителя(-ей) по фамилии введите - 6 ");
        System.out.println("Найти водителя(-ей) на указанном маршруте - 7 ");
        System.out.println("Найти все транспорты без водителей - 8 ");
        System.out.println("Вернуться в главное меню - 9 ");

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
                driverService.findDriverById(idOfDriver2);
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
                driverService.findAllDriversBySurname(surnameOfDriver);
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
                System.out.println("Транспорты без водителей: /n" + routeService.findAllRoutesWithoutTransport());
                timerForDrivers();
                break;

            case 9:
                startPanel();
                break;

            default:
                System.out.println("Некоректный ввод ! Попробуйте снова");
                serviceForDrivers();
        }
    }

    private void timerForDrivers() throws InterruptedException {
        System.out.println("Через 5 секунд возвращаю в меню сервиса водителей !");
        Thread.sleep(5000);
        serviceForDrivers();
    }

    private void serviceForTransports() throws InterruptedException {

        System.out.println("===========================================================================================");
        System.out.println("Введите номер желаемого действия: \n");
        System.out.println("Добавить транспорт введите - 1 ");
        System.out.println("Удалить транспорт введите - 2");
        System.out.println("Найти транспорт по id введите - 3 ");
        System.out.println("Найти все транспорты введите - 4 ");
        System.out.println("Найти транспорт по марке введите - 5 ");
        System.out.println("Найти все транспорты без водителей - 6 ");
        System.out.println("Добавить транспорт на заданный маршрут - 7 ");
        System.out.println("Удалить транспорт с заданного маршрута - 8 ");
        System.out.println("Вернуться в главное меню - 9 ");

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
                transportService.findTransportById(id2);
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
                transportService.findTransportByBrand(brand);
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

    private void timerForTransports() throws InterruptedException {
        System.out.println("Через 5 секунд возвращаю в меню сервиса транспорта !");
        Thread.sleep(5000);
        serviceForTransports();
    }

    private void serviceForRouts() throws InterruptedException {

        System.out.println("===========================================================================================");
        System.out.println("Введите номер желаемого действия: \n");
        System.out.println("Добавить маршрут введите - 1 ");
        System.out.println("Удалить маршрут введите - 2");
        System.out.println("Найти маршрут по id введите - 3 ");
        System.out.println("Найти все маршруты введите - 4 ");
        System.out.println("Найти маршруты без транспорта - 5 ");
        System.out.println("Вернуться в главное меню - 6 ");

        Scanner in1 = new Scanner(System.in);
        int switcher = in1.nextInt();

        switch (switcher) {
            case 1:
                addRoute();
                timerForRouts();
                break;
            case 2:
                Scanner in2 = new Scanner(System.in);
                System.out.println("Введите id маршрута который хотите удалить: ");
                int id2 = in2.nextInt();
                routeService.removeRoute(id2);
                timerForRouts();
                break;
            case 3:
                Scanner in3 = new Scanner(System.in);
                System.out.println("Введите id маршрута который хотите найти: ");
                int id3 = in3.nextInt();
                routeService.findRouteById(id3);
                timerForRouts();
                break;
            case 4:
                System.out.println("Список маршрутов: "+routeService.findAllRoutes());
                timerForRouts();
            case 5:
                System.out.println("Список маршрутов: "+routeService.findAllRoutesWithoutTransport());
                timerForRouts();
                break;
            case 6:
                startPanel();
                break;
            default:
                System.out.println("Некоректный ввод ! Попробуйте снова");
                serviceForRouts();
        }
    }

    private void timerForRouts() throws InterruptedException {
        System.out.println("Через 5 секунд возвращаю в меню сервиса маршрутов !");
        Thread.sleep(5000);
        serviceForTransports();
    }

    private void timerForStartPanel() throws InterruptedException {
        System.out.println("Через 5 секунд возвращаю в главное меню !");
        Thread.sleep(5000);
        startPanel();
    }

} //end of class





