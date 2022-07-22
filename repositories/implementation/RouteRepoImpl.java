package courseworke3.repositories.implementation;


import courseworke3.models.Route;
import courseworke3.models.drivers.Driver;
import courseworke3.repositories.repointerfaces.RouteRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RouteRepoImpl implements RouteRepo {

    private List<Route> listOfRoutes;

    public List<Route> getListOfRoutes() {
        return listOfRoutes;
    }

    public RouteRepoImpl() {
        this.listOfRoutes = new ArrayList<>();
    }

    @Override
    public Route add(Route route) {
        listOfRoutes.add(route);
        return route;
    }

    @Override
    public void remove(Integer id) {
        List<Route> list = listOfRoutes;
        list.remove(findById(id));
        listOfRoutes = list;
    }

    @Override
    public Route findById(Integer id) {
        return listOfRoutes.get(id);
    }

    @Override
    public List<Route> findAll() {
        return listOfRoutes;
    }
}
