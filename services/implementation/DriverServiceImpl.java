package courseworke3.services.implementation;


import courseworke3.models.Route;
import courseworke3.models.drivers.Driver;
import courseworke3.models.transports.Transport;
import courseworke3.repositories.implementation.TransportRepoImpl;
import courseworke3.repositories.repointerfaces.DriversRepo;
import courseworke3.repositories.repointerfaces.RouteRepo;
import courseworke3.repositories.repointerfaces.TransportRepo;
import courseworke3.services.interfaces.DriverService;
import courseworke3.services.interfaces.TransportService;

import java.util.ArrayList;
import java.util.List;

public class DriverServiceImpl implements DriverService {

    DriversRepo driversRepo;
    TransportRepo transportRepo;

    public DriverServiceImpl(DriversRepo driversRepo, TransportRepo transportRepo) {
        this.driversRepo = driversRepo;
        this.transportRepo = transportRepo;
    }

    @Override
    public Driver addDriver(Driver driver) {
        if (driver != null){
            driversRepo.add(driver);
        } else {
            System.err.println("Введено некоректное значение ! ");
        }
        return driversRepo.add(driver);
    }

    @Override
    public void removeDriver(Integer id) {
        if (driversRepo.findById(id) != null) {
            if (driversRepo.findById(id).getTransport() == null) {
                driversRepo.remove(id);
                System.out.println("Водитель успешно удален !");
            } else {
                System.err.println("Невозможно удалить водителя ! Данный водитель зареплен за транспортом !");
            }
        } else {
            System.err.println("Водителя с таким id не существует !");
        }
    }

    @Override
    public Driver findDriverById(Integer id) {
        if (driversRepo.findById(id) != null) {
            return driversRepo.findById(id);
        } else {
            System.err.println("Водителя с данным id не существует");
        }
        return driversRepo.findById(id);
    }

    @Override
    public List<Driver> findAllDriversBySurname(String surname) {
        List <Driver> tempList = driversRepo.findAll();
        List <Driver> list = new ArrayList<>();
        if (surname != null) {
            for (Driver dr: tempList) {
                if (dr.getSurnameOfDriver() != null) {
                    if (dr.getSurnameOfDriver().equals(surname)) {
                        list.add(dr);
                    }
                }
            }
        } else {
            System.err.println("Введено некоректное значение ! ");
        }

        if (list.isEmpty()){
            System.err.println("Введенной фамилии не существует !");
        }
        return list;
    }

    @Override
    public List<Driver> findAllDrivers() {
        return driversRepo.findAll();
    }

    @Override
    public List<Driver> findAllDriversOnRoute(Route route) {
        List<Driver> drivers = new ArrayList<>();
        if (route != null) {
            if (route.getTransport().getDriver() != null) {
                drivers.add(route.getTransport().getDriver());
            } else {
                System.err.println("На данном маршруте водитель отсутствует !");
            }
        } else {
            System.err.println("Заданного маршрута не существует !");
        }
        return drivers;
    }

    @Override
    public List<Transport> findAllTransportsWithoutDriver() {
        List<Transport> transportList = transportRepo.findAll();
        List<Transport> transportListtemp = new ArrayList<>();

        for (Transport tr: transportList) {
            if(!tr.getHasDriver()){
                transportListtemp.add(tr);
            }
        }

        if (transportListtemp.isEmpty()) {
            System.err.println("Лист пуст !");
        }
        return transportListtemp;
    }

    @Override
    public Transport addDriverOnTransport(Driver driver, Transport transport) {
        if (driver != null && transport != null) {
            if (driver.getQualificationEnum().equals(transport.getDriverQualificationEnum())) {
                transport.setDriver(driver);
            } else {
                System.err.println("Невозможно добавить водителя на транспорт !" +
                        "Квалификация водителя или транспорта не совпадают !");
                return null;
            }
        } else System.err.println("Введенного водителя или трансопрта не найдено !");

        return transport;
    }
}
