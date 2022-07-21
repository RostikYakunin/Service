package courseworke3.services.implementation;


import courseworke3.models.Route;
import courseworke3.repositories.repointerfaces.RouteRepo;
import courseworke3.services.interfaces.RouteService;

import java.util.ArrayList;
import java.util.List;

public class RouteServiceImpl implements RouteService {

    private RouteRepo routeRepo;

    public RouteServiceImpl(RouteRepo routeRepo) {
        this.routeRepo = routeRepo;
    }

    @Override
    public Route addRoute(Route route) {
        return routeRepo.add(route);
    }

    @Override
    public void removeRoute(Integer id) {
        routeRepo.remove(id);
    }

    @Override
    public Route findRouteById(Integer id) {
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
        return temp;
    }
}
