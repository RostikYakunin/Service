package courseworke3.services.implementation;


import courseworke3.models.Route;
import courseworke3.models.drivers.Driver;
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
        if (transport != null) {
            transportRepo.add(transport);
        } else {
            System.err.println("Введено некоректное значение ! ");
        }
        return null;
    }

    @Override
    public void removeTransport(Integer id) {
        if (transportRepo.findById(id) != null) {
            if (transportRepo.findById(id).getDriver() == null) {
                transportRepo.remove(id);
                System.out.println("Транспорт успешно удален !");
            } else {
                System.err.println("Невозможно удалить Транспорт ! За данным транспортом закреплен водитель !");
            }
        } else {
            System.err.println("Транспорт с таким id не существует !");
        }
    }

    @Override
    public Transport findTransportById(Integer id) {
        if (transportRepo.findById(id) != null) {
            return transportRepo.findById(id);
        } else {
            System.err.println("Водителя с данным id не существует");
        }
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

        if (brand != null) {
            for (Transport transport : list) {
                if (transport.getBrandOfTransport() != null) {
                    if (transport.getBrandOfTransport().equals(brand)) {
                        tempList.add(transport);
                    }
                }
            }
        } else {
            System.err.println("Введено некоректное значение ! ");
        }

        if (list.isEmpty()) {
            System.err.println("Введенной марки не найдено !");
        }
        return tempList;
    }

    @Override
    public List<Transport> findTransportWithoutDriver() {
        List<Transport> list = transportRepo.findAll();
        List<Transport> tempList = new ArrayList<>();

        for (Transport tr : list) {
            if (!tr.getHasDriver()) {
                tempList.add(tr);
            }
        }

        return tempList;
    }

    @Override
    public void addTransportToRoute(Integer idOfTransport, Route route) {
        Transport transport = transportRepo.findById(idOfTransport);
        if (idOfTransport != null && route != null) {
            if (transport.getDriver() != null) {
                if (transport.getRoute() == null) {
                    route.setTransport(transport);
                    System.out.println("Транспорт успешно добавлен !");
                } else {
                    System.err.println("Заданный вами транспорт уже назначен на другой маршрут ! ---> " + transport);
                }
            } else
                System.err.println("В заданном вами транспорте не назначен водитель ! ---> " + transport);
        } else {
            System.err.println("Введенного транспорта или маршрута не найдено !");
        }
    }

    @Override
    public void removeTransportFromRoute(Transport transport, Route route) {
       if (transport != null && route != null) {
           if (route.getTransport() != null) {
               route.setTransport(null);
               System.out.println("Транспорт успешно удален с маршрута !");
           } else {
               System.err.println("На данном маршруте отсутствует транспорт для удаления !");
           }
       } else {
           System.err.println("Введенного транспорта или маршрута не найдено !");
       }
    }
}
