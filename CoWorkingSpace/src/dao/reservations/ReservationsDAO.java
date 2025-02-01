package dao.reservations;

import java.sql.SQLException;

public interface ReservationsDAO {
    void getAvailableSpaces() throws SQLException;
    void makeReservation(int id) throws SQLException;
    void ownReservations() throws SQLException;
    void cancelReservation(int id) throws SQLException;
}
