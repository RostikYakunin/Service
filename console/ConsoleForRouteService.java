package courseworke3.console;

import courseworke3.models.Route;

import java.util.Scanner;

public class ConsoleForRouteService extends ConsoleMain {

    public ConsoleForRouteService() {
        super();
    }

    protected void serviceForRouts() throws InterruptedException {
        System.out.println("============================================================================================" +
                "\nВведите номер желаемого действия: \n" +
                "\nДобавить маршрут введите - 1 " +
                "\nУдалить маршрут введите - 2" +
                "\nНайти маршрут по id введите - 3 " +
                "\nНайти все маршруты введите - 4 " +
                "\nНайти маршруты без транспорта - 5 " +
                "\nВернуться в главное меню - 6 ");

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
                System.out.println("Маршрут: " + routeService.findRouteById(id3));
                timerForRouts();
                break;
            case 4:
                System.out.println("Список маршрутов: " + routeService.findAllRoutes());
                timerForRouts();
            case 5:
                System.out.println("Список маршрутов: " + routeService.findAllRoutesWithoutTransport());
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
                    System.out.println("------------------------------------------------------------------------------------");
                    System.out.println("Вы успешно создали маршрут: " + route);
                    System.out.println("------------------------------------------------------------------------------------");
                }
            }
        }
    }

    private void timerForRouts() throws InterruptedException {
        System.out.println("Через 5 секунд возвращаю в меню сервиса маршрутов !");
        Thread.sleep(5000);
        serviceForRouts();
    }
}
