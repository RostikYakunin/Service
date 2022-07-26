package courseworke3.services.serviceimpl;


import courseworke3.models.Route;
import courseworke3.repositories.repointerfaces.RouteRepo;
import courseworke3.services.interfaces.RouteService;

import java.util.ArrayList;
import java.util.List;

public class RouteServiceImpl implements RouteService {

    private final RouteRepo routeRepo;

    public RouteServiceImpl(RouteRepo routeRepo) {
        this.routeRepo = routeRepo;
    }

    @Override
    public Route addRoute(Route route) {
        if (route != null) {
            return routeRepo.add(route);
        } else {
            System.err.println("Введено некоректное значение ! ");
        }
        return null;
    }

    @Override
    public void removeRoute(Integer id) {
        if (routeRepo.findById(id) != null) {
            if (routeRepo.findById(id).getTransport() == null) {
                routeRepo.remove(id);
                System.out.println("Маршрут успешно удален !");
            } else {
                System.err.println("Невозможно удалить маршрут ! Данный маршрут зареплен за транспортом !");
            }
        } else {
            System.err.println("Маршрута с таким id не существует !");
        }
    }

    @Override
    public Route findRouteById(Integer id) {
        if (routeRepo.findById(id) != null) {
            return routeRepo.findById(id);
        } else {
            System.err.println("Маршрута с данным id не существует");
        }
        return routeRepo.findById(id);
    }

    @Override
    public List<Route> findAllRoutes() {
        return routeRepo.findAll();
    }

    @Override
    public List<Route> findAllRoutesWithoutTransport() {
        List <Route> list = routeRepo.findAll();
        List <Route> temp = new ArrayList<>();

        for (Route r : list) {
            if (!r.hasTransport()) {
                temp.add(r);
            }
        }

        if (temp.isEmpty()) {
            System.err.println("Лист пуст !");
        }

        return temp;
    }
}
