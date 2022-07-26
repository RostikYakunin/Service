package courseworke3.console;

import courseworke3.repositories.repoimpl.DriversRepoImpl;
import courseworke3.repositories.repoimpl.RouteRepoImpl;
import courseworke3.repositories.repoimpl.TransportRepoImpl;
import courseworke3.repositories.repointerfaces.DriversRepo;
import courseworke3.repositories.repointerfaces.RouteRepo;
import courseworke3.repositories.repointerfaces.TransportRepo;
import courseworke3.services.serviceimpl.DriverServiceImpl;
import courseworke3.services.serviceimpl.RouteServiceImpl;
import courseworke3.services.serviceimpl.TransportServiceImpl;
import courseworke3.services.interfaces.DriverService;
import courseworke3.services.interfaces.RouteService;
import courseworke3.services.interfaces.TransportService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleMain {

    protected final TransportService transportService;
    protected final DriverService driverService;
    protected final RouteService routeService;

    static {
        System.out.println("Добро пожаловать в программу управления автопарком !");
    }

    public ConsoleMain() {
        TransportRepo transportRepo = new TransportRepoImpl();
        this.transportService = new TransportServiceImpl(transportRepo);

        DriversRepo driversRepo = new DriversRepoImpl();
        this.driverService = new DriverServiceImpl(driversRepo, transportRepo);

        RouteRepo routeRepo = new RouteRepoImpl();
        this.routeService = new RouteServiceImpl(routeRepo);
    }

    public void startPanel() throws InterruptedException {
        System.out.println(
                "=======================================================================================================" +
                "\nГлавное меню ! \nВведите действие которое хотите выполнить !" +
                "\n-----------------------------------------------------------------------------------------------------" +
                "\nСервис работы с транспортом - введите \"1\" " +
                "\nСервис работы с маршрутами - введите \"2\" " +
                "\nСервис работы с водителями - введите \"3\" " +
                "\nВыйти из программы - введите \"0\" " +
                "\n-----------------------------------------------------------------------------------------------------"
        );

        try {
            Scanner in = new Scanner(System.in);
            int number = in.nextInt();

            switch (number) {
                case 1:
                    ConsoleForTransportService consoleForTransportService = new ConsoleForTransportService();
                    consoleForTransportService.serviceForTransports();
                    break;
                case 2:
                    ConsoleForRouteService consoleForRouteService = new ConsoleForRouteService();
                    consoleForRouteService.serviceForRouts();
                    break;
                case 3:
                    ConsoleForDriverService consoleForDriverService = new ConsoleForDriverService();
                    consoleForDriverService.serviceForDrivers();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Введено некоректное значение ! ");
                    timerForStartPanel();
            }
        } catch (InputMismatchException e) {
            System.err.println("Введено недопустимое значение !");
            timerForStartPanel();
        }
    }

    private void timerForStartPanel() throws InterruptedException {
        System.out.println("Через 5 секунд возвращаю в главное меню !");
        Thread.sleep(5000);
        startPanel();
    }
}





