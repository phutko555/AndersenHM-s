package controller;

import model.WorkSpacesE;
import service.admin.AdminService;

import java.sql.SQLException;

public class AdminController {
        private AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    public AdminController() {
    }

    public void addWorkSpace(WorkSpacesE workSpaces) throws SQLException {
            adminService.addWorkSpace(workSpaces);
    }
    public void removeWorkspace(int id) throws SQLException {
        try{
            adminService.removeWorkSpace(id);
            System.out.println("Workspace removed successfully");
        }catch (SQLException e){
            System.out.println("Error removing workspace: " + e.getMessage());
        }
    }

    public void viewAllReservations() throws SQLException{
        adminService.viewAllReservations();
    }
}