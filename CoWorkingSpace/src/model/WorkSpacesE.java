package model;

import javax.persistence.*;

@Entity
@Table(name = "workspaces")
public class WorkSpacesE {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String type;

    private double price;
    private boolean availabilityStatus;

    @ManyToOne
    private AdminE admin;

    @OneToOne(mappedBy = "workSpacesE")
    private ReservationsE reservationsE;

    public WorkSpacesE() {
    }

    public WorkSpacesE(String type, double price, boolean availabilityStatus) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.availabilityStatus = availabilityStatus;
    }

    public int getId() {
        return id;
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

    public boolean isAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(boolean availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    @Override
    public String toString() {
        return "WorkSpacesE{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", availabilityStatus=" + availabilityStatus +
                '}';
    }
}
