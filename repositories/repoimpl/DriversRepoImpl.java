package courseworke3.repositories.repoimpl;

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
        if (driver != null) {
            listOfDrivers.add(driver);
        }
        return driver;
    }

    @Override
    public void remove(Integer id) {
        listOfDrivers.remove(findById(id));
    }

    @Override
    public Driver findById(Integer id) {
        for (Driver dr : listOfDrivers) {
            if (dr.getId().equals(id)) {
                return dr;
            }
        }
        return null;
    }

    @Override
    public List<Driver> findAll() {
        return listOfDrivers;
    }
}
