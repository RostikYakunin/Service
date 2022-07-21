package courseworke3.services.interfaces;


import courseworke3.models.Route;
import courseworke3.models.drivers.Driver;
import courseworke3.models.transports.Transport;

import java.util.List;

public interface DriverService {
    Driver addDriver (Driver driver);
    void removeDriver (Integer id);
    Driver findDriverById (Integer id);
    List <Driver> findAllDriversBySurname(String surname);
    List <Driver> findAllDrivers();
    List <Driver> findAllDriversOnRoute(Route route);
    List <Transport> findAllTransportsWithoutDriver();
    Transport addDriverOnTransport (Driver driver, Transport transport);


}
