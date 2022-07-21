package courseworke3.models;

import courseworke3.models.drivers.Driver;
import courseworke3.models.transports.Transport;

public class Route {
    private Integer id;
    private String startOfWay;
    private String endOfWay;

    private boolean hasTransport;

    private Transport transport;
    private Driver driver;

    public Route(Integer id, String startOfWay, String endOfWay, boolean hasTransport) {
        this.id = id;
        this.startOfWay = startOfWay;
        this.endOfWay = endOfWay;
        this.hasTransport = hasTransport;
    }

    public Route(Integer id, String startOfWay, String endOfWay, boolean hasTransport, Transport transport) {
        this.id = id;
        this.startOfWay = startOfWay;
        this.endOfWay = endOfWay;
        this.hasTransport = hasTransport;
        this.transport = transport;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartOfWay() {
        return startOfWay;
    }

    public void setStartOfWay(String startOfWay) {
        this.startOfWay = startOfWay;
    }

    public String getEndOfWay() {
        return endOfWay;
    }

    public void setEndOfWay(String endOfWay) {
        this.endOfWay = endOfWay;
    }

    public boolean hasTransport() {
        return hasTransport;
    }

    public void setEmptyRouteByTransport(boolean emptyRouteByTransport) {
        hasTransport = emptyRouteByTransport;
    }

    @Override
    public String toString() {
        return "\nRoute{" +
                "id=" + id +
                ", startOfWay='" + startOfWay + '\'' +
                ", endOfWay='" + endOfWay + '\'' +
                ", transport=" + transport;
    }
}
