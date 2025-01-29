package dao.workspace;
import model.WorkSpaces;
import utils.DatabaseConnectionManager;
import java.sql.*;

public class WorkSpaceDAOImpl implements WorkSpaceDAO {
    @Override
    public void addWorkSpace(WorkSpaces workSpace) {
        String sql = "INSERT INTO workspacemanager (id, type, price, availabilitystatus) VALUES (?, ?, ?, ?)";
        try(Connection connection = DatabaseConnectionManager.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,workSpace.getId());
            preparedStatement.setString(2,workSpace.getType());
            preparedStatement.setDouble(3,workSpace.getPrice());
            preparedStatement.setBoolean(4,workSpace.isAvailabilityStatus());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean workspaceExists(int id) throws SQLException {
        String sql = "SELECT COUNT(*) FROM workspacemanager WHERE id = ?";
        try(Connection connection = DatabaseConnectionManager.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                return resultSet.getInt(1) > 0;
            }
        }
        return false;
    }

    @Override
    public void removeWorkSpace(int id) throws SQLException {
        String sql = "DELETE FROM workspacemanager WHERE id = ?";
        try(Connection connection = DatabaseConnectionManager.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void viewAllReservations() throws SQLException {
        String sql = "SELECT * FROM workspacemanager WHERE availabilitystatus = false";
        try(Connection connection = DatabaseConnectionManager.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String type = resultSet.getString("type");
                double price = resultSet.getInt("price");
                boolean available = resultSet.getBoolean("availabilitystatus");
                System.out.println("ID: " + id + ", Type: " + type + ", Price: $" + price + ", Available: " + available);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean areReservations() throws SQLException {
            String sql = "SELECT 1 FROM workspacemanager WHERE availabilitystatus = false";
            try(Connection connection = DatabaseConnectionManager.getConnection()){
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                return resultSet.next();
            }
    }
}