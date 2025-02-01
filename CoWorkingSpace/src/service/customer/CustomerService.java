package service.customer;
import dao.reservations.ReservationsDAO;
import java.sql.SQLException;

public class CustomerService {
    ReservationsDAO reservationsDAO;

    public CustomerService(ReservationsDAO reservationsDAO) {
        this.reservationsDAO = reservationsDAO;
    }

    public void getAvailableSpaces() throws SQLException {
        try{
            System.out.println("Available spaces: ");
            reservationsDAO.getAvailableSpaces();
        }catch (SQLException e){
            System.out.println("Error retrieving available workspaces: " + e.getMessage());
        }
    }
    public void makeReservation(int id) throws SQLException{
        try{
            reservationsDAO.makeReservation(id);
            System.out.println("Reservation successful for workspace ID: " + id);
        }catch (SQLException e){
            System.out.println("Error making reservation: " +  e.getMessage());
        }
    }

    public void ownReservations() throws SQLException{
        try{
            System.out.println("Own Reservations: ");
            reservationsDAO.ownReservations();
        }catch (SQLException e){
            System.out.println("Error, " + e.getMessage());
        }
    }

        public void cancelReservation(int id)throws SQLException{
        try{
            reservationsDAO.cancelReservation(id);
        }catch (SQLException e){
            System.out.println("Error" + e.getMessage());
        }
        }
}