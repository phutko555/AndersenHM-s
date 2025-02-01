package model;

import javax.persistence.*;

@Entity
@Table(name = "reservations")
public class ReservationsE {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    private WorkSpacesE workSpacesE;

    @OneToOne
    private CustomerE customer;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public WorkSpacesE getWorkSpacesE() {
        return workSpacesE;
    }

    public void setWorkSpacesE(WorkSpacesE workSpacesE) {
        this.workSpacesE = workSpacesE;
    }

    public CustomerE getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerE customer) {
        this.customer = customer;
    }


}
