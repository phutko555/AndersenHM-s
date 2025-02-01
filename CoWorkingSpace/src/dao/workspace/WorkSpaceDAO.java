package dao.workspace;

import model.WorkSpacesE;

import java.sql.SQLException;

public interface WorkSpaceDAO {
    void addWorkSpace(WorkSpacesE workSpace) throws SQLException;
    void removeWorkSpace(int id) throws SQLException;
    void viewAllReservations() throws SQLException;
}
