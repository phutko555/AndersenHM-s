package app.dao.admin;

import dao.workspace.WorkSpaceDAO;
import dao.workspace.WorkSpaceDAOImpl;
import model.WorkSpaces;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.workspace.WorkSpaceService;
import utils.DatabaseConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminTest {
    private WorkSpaceDAO workSpaceDAO;
    private WorkSpaceService workSpaceService;
    private WorkSpaces workSpaces1;

    @BeforeEach
     public void setUp() throws SQLException {
        workSpaceDAO = new WorkSpaceDAOImpl();
        workSpaceService = new WorkSpaceService(workSpaceDAO);
        workSpaces1 = new WorkSpaces(1,"Private Office",500.0,true);
        workSpaceDAO.addWorkSpace(workSpaces1);
    }

    @AfterEach
    public void tearDown() throws SQLException{
        String cleaupSQL = "DELETE FROM workspacemanager WHERE id = ?";
        try(Connection connection = DatabaseConnectionManager.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(cleaupSQL);
            preparedStatement.setInt(1,workSpaces1.getId());
            preparedStatement.executeUpdate();
        }
    }

    @Test
    public void shouldContainWorkspaceAfterAdding() throws SQLException {
      String sql = "SELECT * FROM workspacemanager WHERE id = ?";
      try(Connection connection = DatabaseConnectionManager.getConnection()){
          PreparedStatement preparedStatement = connection.prepareStatement(sql);
          preparedStatement.setInt(1,workSpaces1.getId());
          ResultSet resultSet = preparedStatement.executeQuery();
          Assertions.assertTrue(resultSet.next(), "Workspace should exist in the database");
          Assertions.assertEquals(workSpaces1.getType(),resultSet.getString("type"),"Workspace type mismatch");
          Assertions.assertEquals(workSpaces1.getPrice(), resultSet.getDouble("price"), "Workspace price mismatch");
          Assertions.assertEquals(workSpaces1.isAvailabilityStatus(),resultSet.getBoolean("availabilitystatus"),"Workspace availability status mismatch");
      }catch (SQLException e){
          e.printStackTrace();
      }
    }

    @Test
    public void shouldRemoveWorkspace() throws SQLException{
        int idToRemove = workSpaces1.getId();
        workSpaceDAO.removeWorkSpace(idToRemove);
        String sql = "SELECT * FROM workspacemanager WHERE id = ?";
        try(Connection connection = DatabaseConnectionManager.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,idToRemove);
            ResultSet resultSet = preparedStatement.executeQuery();
            Assertions.assertFalse(resultSet.next(),"Workspace should no longer exist in the database");
        }
    }
    @Test
    public void shouldThrowExceptionWhenSpaceIsInvalid(){
        int nonExistentId = 999;
        SQLException exception = Assertions.assertThrows(SQLException.class,() ->{
            workSpaceService.removeWorkSpace(nonExistentId);
        });
        Assertions.assertEquals("Workspace with ID "+ nonExistentId + " is not found",exception.getMessage());
    }
}