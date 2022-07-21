package courseworke3.services.implementation;



import courseworke3.models.Route;
import courseworke3.models.transports.Transport;
import courseworke3.repositories.repointerfaces.TransportRepo;
import courseworke3.services.interfaces.TransportService;

import java.util.ArrayList;
import java.util.List;

public class TransportServiceImpl implements TransportService {

    TransportRepo transportRepo;

    public TransportServiceImpl(TransportRepo transportRepo) {
        this.transportRepo = transportRepo;
    }

    @Override
    public Transport addTransport(Transport transport) {
       return transportRepo.add(transport);
    }

    @Override
    public void removeTransport(Integer id) {
        transportRepo.remove(id);
    }

    @Override
    public Transport findTransportById(Integer id) {
        return transportRepo.findById(id);
    }

    @Override
    public List<Transport> findAllTransports() {
        return transportRepo.findAll();
    }

    @Override
    public List<Transport> findTransportByBrand(String brand) {
        List<Transport> list = transportRepo.findAll();
        List<Transport> tempList = new ArrayList<>();
        for (Transport tr: list) {
            if (tr.getBrandOfTransport().equals(brand)){
                tempList.add(tr);
            }
        }
        return tempList;
    }

    @Override
    public List<Transport> findTransportWithoutDriver() {
        List<Transport> list = transportRepo.findAll();
        List<Transport> tempList = new ArrayList<>();
        for (Transport tr: list) {
            if(!tr.getHasDriver()) {
                tempList.add(tr);
            }
        }
        return tempList;
    }

    @Override
    public void addTransportToRoute(Integer idOfTransport, Route route) {
        Transport transport = transportRepo.findById(idOfTransport);
        if (transport.getDriver() != null){
            if (transport.getRoute() == null){
             route.setTransport(transport);
            System.out.println("Транспорт успешно добавлен !");
            } else {
            System.err.println("Заданный вами транспорт уже назначен на другой маршрут ! ---> " + transport);
            }
        } else
            System.err.println("В заданном вами транспорте не назначен водитель ! ---> " + transport);
    }

    @Override
    public void removeTransportFromRoute(Transport transport,Route route) {
        if (route.getTransport()!= null) {
            route.setTransport(null);
            System.out.println("Транспорт успешно удален с маршрута !");
        } else System.err.println("На данном маршруте отсутствует транспорт для удаления !");
    }
}
