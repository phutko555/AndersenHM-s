package dao.reservations;
import utils.DatabaseConnectionManager;
import java.sql.*;
public class ReservationsDAOImpl implements ReservationsDAO{
    @Override
    public void getAvailableSpaces() {
        String sql = "SELECT * FROM workspacemanager WHERE availabilitystatus = true";
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
    public boolean isAvailableSpaces() throws SQLException {
        String sql = "SELECT 1 FROM workspacemanager WHERE availabilitystatus = true";
        try(Connection connection = DatabaseConnectionManager.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            return resultSet.next();
        }
    }

    @Override
    public void makeReservation(int id) throws SQLException {
        String sql = "INSERT INTO reservations (workspace_id) VALUES (?)";
        try(Connection connection = DatabaseConnectionManager.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean isAvailable(int id) throws SQLException {
        String sql = "SELECT id FROM workspacemanager WHERE id = ? AND availabilitystatus = true";
        try(Connection connection = DatabaseConnectionManager.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        }
    }

    @Override
    public void changeAvailability(int id) throws SQLException {
        String sql = "UPDATE workspacemanager SET availabilitystatus = false WHERE id = ?";
        try(Connection connection = DatabaseConnectionManager.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void ownReservations() throws SQLException {
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

    @Override
    public void cancelReservation(int id) throws SQLException {
        String sql = "DELETE FROM reservations WHERE id = ?";
        try(Connection connection = DatabaseConnectionManager.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public boolean reservationExists(int id) throws SQLException {
        String sql = "SELECT 1 FROM reservations WHERE id = ?";
        try(Connection connection = DatabaseConnectionManager.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        }
    }
}