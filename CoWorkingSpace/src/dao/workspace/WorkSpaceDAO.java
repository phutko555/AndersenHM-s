package dao.workspace;

import model.WorkSpaces;

import java.sql.SQLException;

public interface WorkSpaceDAO {
    void addWorkSpace(WorkSpaces workSpace) throws SQLException;
    boolean workspaceExists(int id) throws SQLException;
    void removeWorkSpace(int id) throws SQLException;
    void viewAllReservations() throws SQLException;
    boolean areReservations() throws SQLException;
}
