package courseworke3.models.drivers;

import courseworke3.models.transports.Transport;

public class Driver {
    private Integer id;
    private String nameOfDriver;
    private String surnameOfDriver;
    private String numberOfPhone;
    private DriverQualificationEnum qualificationEnum;

    private Transport transport;

    public Driver(Integer id, String nameOfDriver, String surnameOfDriver, String numberOfPhone, DriverQualificationEnum qualificationEnum) {
        this.id = id;
        this.nameOfDriver = nameOfDriver;
        this.surnameOfDriver = surnameOfDriver;
        this.numberOfPhone = numberOfPhone;
        this.qualificationEnum = qualificationEnum;
    }

    public Driver(Integer id, String nameOfDriver, String surnameOfDriver, String numberOfPhone, DriverQualificationEnum qualificationEnum, Transport transport) {
        this.id = id;
        this.nameOfDriver = nameOfDriver;
        this.surnameOfDriver = surnameOfDriver;
        this.numberOfPhone = numberOfPhone;
        this.qualificationEnum = qualificationEnum;
        this.transport = transport;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameOfDriver() {
        return nameOfDriver;
    }

    public void setNameOfDriver(String nameOfDriver) {
        this.nameOfDriver = nameOfDriver;
    }

    public String getSurnameOfDriver() {
        return surnameOfDriver;
    }

    public void setSurnameOfDriver(String surnameOfDriver) {
        this.surnameOfDriver = surnameOfDriver;
    }

    public String getNumberOfPhone() {
        return numberOfPhone;
    }

    public void setNumberOfPhone(String numberOfPhone) {
        this.numberOfPhone = numberOfPhone;
    }

    public DriverQualificationEnum getQualificationEnum() {
        return qualificationEnum;
    }

    public void setQualificationEnum(DriverQualificationEnum qualificationEnum) {
        this.qualificationEnum = qualificationEnum;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", nameOfDriver='" + nameOfDriver + '\'' +
                ", surnameOfDriver='" + surnameOfDriver + '\'' +
                ", numberOfPhone='" + numberOfPhone + '\'' +
                ", qualificationEnum=" + qualificationEnum +
                '}';
    }
}
