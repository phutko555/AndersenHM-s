import model.WorkSpaces;
import service.workspace.WorkSpaceService;
import java.io.Serializable;
import java.sql.SQLException;

public class Admin implements Serializable {
    private static final long serialVersionUID = 5467568632194107991L;
    private WorkSpaceService workSpaceService;

    public Admin(WorkSpaceService workSpaceService) {
        this.workSpaceService = workSpaceService;
    }

    public Admin() {
    }

    public void addWorkSpace(WorkSpaces workSpaces) throws SQLException {
        try{
            workSpaceService.addWorkSpace(workSpaces);
            System.out.println("Workspace Added successfully!");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void removeWorkSpace(int id)throws SQLException{
        try{
            workSpaceService.removeWorkSpace(id);
            System.out.println("Workspace with ID " + id + " removed successfully!");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void viewAllReservations()throws SQLException{
        try{
            System.out.println("Reservations: ");
            workSpaceService.viewAllReservations();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}