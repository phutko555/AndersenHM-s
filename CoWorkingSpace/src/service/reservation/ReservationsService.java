package service.reservation;
import dao.reservations.ReservationsDAO;
import java.sql.SQLException;

public class ReservationsService {
    ReservationsDAO reservationsDAO;

    public ReservationsService(ReservationsDAO reservationsDAO) {
        this.reservationsDAO = reservationsDAO;
    }

    public void getAvailableSpaces() throws SQLException {
        if(reservationsDAO.isAvailableSpaces()){
            reservationsDAO.getAvailableSpaces();
        }else{
            throw new SQLException("There are not any available spaces");
        }
    }

    public void makeReservation(int id) throws SQLException {
        if(reservationsDAO.isAvailable(id)){
            reservationsDAO.changeAvailability(id);
            reservationsDAO.makeReservation(id);
        }else{
            throw new SQLException("Workspace " + id + " does not exist or is not available.");
        }

    }
    public void ownReservations() throws SQLException{
            if(reservationsDAO.areReservations()){
                reservationsDAO.ownReservations();
            }else{
                throw new SQLException("You don't have any reservation");
            }
    }
    public void cancelReservation(int id) throws SQLException{
        if(reservationsDAO.reservationExists(id)){
            reservationsDAO.cancelReservation(id);
        }else {
            throw new SQLException("No active reservation found with ID "+ id);
        }
    }
}