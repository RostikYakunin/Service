package courseworke3.repositories.repoimpl;


import courseworke3.models.Route;
import courseworke3.repositories.repointerfaces.RouteRepo;

import java.util.ArrayList;
import java.util.List;

public class RouteRepoImpl implements RouteRepo {

    private final List<Route> listOfRoutes;

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
        listOfRoutes.remove(findById(id));
    }

    @Override
    public Route findById(Integer id) {
        for (Route route: listOfRoutes) {
            if (route.getId().equals(id)){
                return route;
            }
        }
        return null;
    }

    @Override
    public List<Route> findAll() {
        return listOfRoutes;
    }
}
