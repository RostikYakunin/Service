package courseworke3.models.transports;


import courseworke3.models.Route;
import courseworke3.models.drivers.DriverQualificationEnum;

public class Bus extends Transport{
    private String type;
    private Integer numbersOfDoors;

    public Bus(Integer id, String brandOfTransport, Integer numbersOfPassengers, boolean hasDriver, DriverQualificationEnum driverQualificationEnum, String type, Integer numbersOfDoors) {
        super(id, brandOfTransport, numbersOfPassengers, hasDriver, driverQualificationEnum);
        this.type = type;
        this.numbersOfDoors = numbersOfDoors;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getNumbersOfDoors() {
        return numbersOfDoors;
    }

    public void setNumbersOfDoors(Integer numbersOfDoors) {
        this.numbersOfDoors = numbersOfDoors;
    }

    @Override
    public String toString() {
        return super.toString() + ", тип транспорта: " + type+ ", количество дверей: " + numbersOfDoors;
    }
}
