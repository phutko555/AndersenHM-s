package dao.reservations;

import java.sql.SQLException;

public interface ReservationsDAO {
    void getAvailableSpaces() throws SQLException;
    boolean isAvailableSpaces() throws SQLException;
    void makeReservation(int id) throws SQLException;
    boolean isAvailable(int id) throws SQLException;
    void changeAvailability(int id) throws SQLException;
    void ownReservations() throws SQLException;
    boolean areReservations() throws SQLException;
    void cancelReservation(int id) throws SQLException;
    boolean reservationExists(int id) throws SQLException;

}
