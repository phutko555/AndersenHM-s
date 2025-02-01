package service.admin;
import dao.workspace.WorkSpaceDAO;
import model.WorkSpacesE;
import java.sql.SQLException;

public class AdminService {
    WorkSpaceDAO workSpaceDAO;

    public AdminService(WorkSpaceDAO workSpaceDAO) {
        this.workSpaceDAO = workSpaceDAO;
    }

    public void addWorkSpace(WorkSpacesE workSpaces) throws SQLException {
         try{
             workSpaceDAO.addWorkSpace(workSpaces);
         }catch (Exception e){
             System.out.println(e.getMessage());
         }
    }

    public void removeWorkSpace(int id) throws SQLException{
        try{
            workSpaceDAO.removeWorkSpace(id);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void viewAllReservations() throws SQLException{
        try{
            System.out.println("Reservations: ");
            workSpaceDAO.viewAllReservations();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}