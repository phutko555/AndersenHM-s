package model;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class CustomerE {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToOne(mappedBy = "customer")
    private ReservationsE reservationsE;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ReservationsE getReservationsE() {
        return reservationsE;
    }

    public void setReservationsE(ReservationsE reservationsE) {
        this.reservationsE = reservationsE;
    }
}
