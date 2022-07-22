package courseworke3.repositories.implementation;

import courseworke3.models.drivers.Driver;
import courseworke3.repositories.repointerfaces.DriversRepo;

import java.util.ArrayList;
import java.util.List;

public class DriversRepoImpl implements DriversRepo {

    private List<Driver> listOfDrivers;

    public DriversRepoImpl() {
        this.listOfDrivers = new ArrayList<>();
    }

    @Override
    public Driver add(Driver driver) {
        if (driver != null) {
            listOfDrivers.add(driver);
        }
        return driver;
    }

    @Override
    public void remove(Integer id) {
        List<Driver> list = listOfDrivers;
        list.remove(findById(id));
        listOfDrivers = list;
    }

    @Override
    public Driver findById(Integer id) {
        return listOfDrivers.get(id);
    }

    @Override
    public List<Driver> findAll() {
        return listOfDrivers;
    }
}
