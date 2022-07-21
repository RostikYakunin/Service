package courseworke3.services.interfaces;



import courseworke3.models.Route;

import java.util.List;

public interface RouteService {

    Route addRoute(Route route);
    void removeRoute (Integer id);
    Route findRouteById (Integer id);
    List <Route> findAllRoutes ();
    List <Route> findAllRoutesWithoutTransport ();

}
