package courseworke3.models.transports;

import courseworke3.models.Route;
import courseworke3.models.drivers.Driver;
import courseworke3.models.drivers.DriverQualificationEnum;

public class Transport {
    private Integer id;
    private String brandOfTransport;
    private Integer numbersOfPassengers;
    private boolean hasDriver;
    private Route route;
    private DriverQualificationEnum driverQualificationEnum;

    private Driver driver;

    public Transport(Integer id, String brandOfTransport, Integer numbersOfPassengers, boolean hasDriver, DriverQualificationEnum driverQualificationEnum) {
        this.id = id;
        this.brandOfTransport = brandOfTransport;
        this.numbersOfPassengers = numbersOfPassengers;
        this.hasDriver = hasDriver;
        this.driverQualificationEnum = driverQualificationEnum;
    }

    public Transport(Integer id, String brandOfTransport, Integer numbersOfPassengers, boolean hasDriver, Route route, DriverQualificationEnum driverQualificationEnum) {
        this.id = id;
        this.brandOfTransport = brandOfTransport;
        this.numbersOfPassengers = numbersOfPassengers;
        this.hasDriver = hasDriver;
        this.route = route;
        this.driverQualificationEnum = driverQualificationEnum;
    }

    public Transport(Integer id, String brandOfTransport, Integer numbersOfPassengers, boolean hasDriver, Route route, DriverQualificationEnum driverQualificationEnum, Driver driver) {
        this.id = id;
        this.brandOfTransport = brandOfTransport;
        this.numbersOfPassengers = numbersOfPassengers;
        this.hasDriver = hasDriver;
        this.route = route;
        this.driverQualificationEnum = driverQualificationEnum;
        this.driver = driver;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrandOfTransport() {
        return brandOfTransport;
    }

    public void setBrandOfTransport(String brandOfTransport) {
        this.brandOfTransport = brandOfTransport;
    }

    public Integer getNumbersOfPassengers() {
        return numbersOfPassengers;
    }

    public void setNumbersOfPassengers(Integer numbersOfPassengers) {
        this.numbersOfPassengers = numbersOfPassengers;
    }

    public boolean getHasDriver() {
        return hasDriver;
    }

    public void setHasDriver(boolean hasDriver) {
        this.hasDriver = hasDriver;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public DriverQualificationEnum getDriverQualificationEnum() {
        return driverQualificationEnum;
    }

    public void setDriverQualificationEnum(DriverQualificationEnum driverQualificationEnum) {
        this.driverQualificationEnum = driverQualificationEnum;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
        this.hasDriver = true;
    }

    @Override
    public String toString() {
        return "\nТранспорт № " + id + ", модель: " + brandOfTransport + ", количество мест для пассажиров: " +
                ", квалификация водителя: " + driverQualificationEnum;
    }
}
