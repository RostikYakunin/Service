package courseworke3.services.interfaces;

import courseworke3.models.Route;
import courseworke3.models.transports.Transport;

import java.util.List;

public interface TransportService {
    Transport addTransport (Transport transport);
    void removeTransport (Integer id);
    Transport findTransportById (Integer id);
    List<Transport> findAllTransports ();
    List<Transport> findTransportByBrand(String brand);
    List<Transport> findTransportWithoutDriver();
    void addTransportToRoute(Integer idOfTransport, Route route);
    void removeTransportFromRoute(Transport transport, Route route);
}
