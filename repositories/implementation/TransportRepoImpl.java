package courseworke3.repositories.implementation;


import courseworke3.models.Route;
import courseworke3.models.drivers.Driver;
import courseworke3.models.transports.Transport;
import courseworke3.repositories.repointerfaces.TransportRepo;

import java.util.ArrayList;
import java.util.List;

public class TransportRepoImpl implements TransportRepo {

    private List<Transport> listOfTransports;

    public TransportRepoImpl() {
        this.listOfTransports = new ArrayList<>();
    }

    @Override
    public Transport add(Transport transport) {
        listOfTransports.add(transport);
        return transport;
    }

    @Override
    public void remove(Integer id) {
        List<Transport> list = listOfTransports;
        list.remove(findById(id));
        listOfTransports = list;
    }

    @Override
    public Transport findById(Integer id) {
        for (Transport transport: listOfTransports) {
            if (transport.getId().equals(id)){
                return transport;
            }
        }
        return null;
    }

    @Override
    public List<Transport> findAll() {
        return listOfTransports;
    }
}
