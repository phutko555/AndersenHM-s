package service.workspace;
import dao.workspace.WorkSpaceDAO;
import model.WorkSpaces;
import java.sql.SQLException;

public class WorkSpaceService {
    WorkSpaceDAO workSpaceDAO;

    public WorkSpaceService(WorkSpaceDAO workSpaceDAO) {
        this.workSpaceDAO = workSpaceDAO;
    }

    public void addWorkSpace(WorkSpaces workSpaces) throws SQLException {
        if(workSpaceDAO.workspaceExists(workSpaces.getId())){
            throw new SQLException("Workspace with ID" + workSpaces.getId() + " already exists");
        }
        workSpaceDAO.addWorkSpace(workSpaces);
    }
    public void removeWorkSpace(int id) throws SQLException{
        if(!workSpaceDAO.workspaceExists(id)){
            throw new SQLException("Workspace with ID "+ id + " is not found");
        }
        workSpaceDAO.removeWorkSpace(id);
    }
    public void viewAllReservations() throws SQLException{
        if(workSpaceDAO.areReservations()){
            workSpaceDAO.viewAllReservations();
        }else {
            throw new SQLException("There are not any reservations");
        }
    }
}