import service.reservation.ReservationsService;

import java.io.Serializable;
import java.sql.SQLException;

public class Customer implements Serializable {

    private static final long serialVersionUID = 134528019936612357L;
    ReservationsService reservationsService;

    public Customer(ReservationsService reservationsService) {
        this.reservationsService = reservationsService;
    }

    public void getAvailableSpaces() throws SQLException {
        try{
            System.out.println("Available Spaces: ");
            reservationsService.getAvailableSpaces();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void makeReservation(int id) throws SQLException {
        try{
            reservationsService.makeReservation(id);
            System.out.println("Reserved Successfully");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void ownReservations() throws SQLException{
        try{
            System.out.println("Reservations : ");
            reservationsService.ownReservations();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
    public void cancelReservation(int id) throws SQLException{
        try{
            reservationsService.cancelReservation(id);
            System.out.println("Reservation cancelled successfully");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

}