package model;

import java.io.Serializable;

public class WorkSpaces implements Serializable {

    private int id;
    private String type;
    private double price;
    private boolean availabilityStatus;

    public WorkSpaces(int id, String type, double price, boolean availabilityStatus) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.availabilityStatus = availabilityStatus;
    }

    public int getId() {
        return id;
    }
    public boolean isAvailabilityStatus() {
        return availabilityStatus;
    }
    public void setAvailabilityStatus(boolean availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "WorkSpace{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", availabilityStatus=" + availabilityStatus +
                '}';
    }
}