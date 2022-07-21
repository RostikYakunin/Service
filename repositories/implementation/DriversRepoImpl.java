package courseworke3.repositories.implementation;

import courseworke3.models.drivers.Driver;
import courseworke3.repositories.repointerfaces.DriversRepo;
import java.util.ArrayList;
import java.util.List;

public class DriversRepoImpl implements DriversRepo {

    private final List<Driver> listOfDrivers;

    public DriversRepoImpl() {
        this.listOfDrivers = new ArrayList<>();
    }

    @Override
    public Driver add(Driver driver) {
        listOfDrivers.add(driver);
        return driver;
    }

    @Override
    public void remove(Integer id) {
        for (Driver d:listOfDrivers) {
            if (d.getId().equals(id)) {
                d = null;
            }
        }
    }

    @Override
    public Driver findById(Integer id) {
        if (id<listOfDrivers.size()) return listOfDrivers.get(id);
        else return null;
    }

    @Override
    public List<Driver> findAll() {
        return listOfDrivers;
    }

}
