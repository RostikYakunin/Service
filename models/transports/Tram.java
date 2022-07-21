package courseworke3.models.transports;


import courseworke3.models.Route;
import courseworke3.models.drivers.DriverQualificationEnum;

public class Tram extends Transport{
    private Integer numbersOfRailcar;

    public Tram(Integer id, String brandOfTransport, Integer numbersOfPassengers, boolean driver, DriverQualificationEnum driverQualificationEnum, Integer numbersOfRailcar) {
        super(id, brandOfTransport, numbersOfPassengers, driver, driverQualificationEnum);
        this.numbersOfRailcar = numbersOfRailcar;
    }

    public Integer getNumbersOfRailcar() {
        return numbersOfRailcar;
    }

    public void setNumbersOfRailcar(Integer numbersOfRailcar) {
        this.numbersOfRailcar = numbersOfRailcar;
    }
}
