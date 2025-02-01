package app.dao.reservations;

public class CustomerTest {
//    private WorkSpaces workSpaces;
//    private ReservationsDAO reservationsDAO;
//    private ReservationsService reservationsService;
//    @BeforeEach
//    public void setUp() throws SQLException {
//        workSpaces = new WorkSpaces(875,"VIP",50.5,false);
//        reservationsDAO = new ReservationsDAOImpl();
//        reservationsService = new ReservationsService(reservationsDAO);
//        reservationsDAO.makeReservation(workSpaces.getId());
//
//    }
//    @AfterEach
//    public void tearDown() throws SQLException{
//        String cleaupSQL = "DELETE FROM reservations WHERE workspace_id = ?";
//        try(Connection connection = HibernateUtil.getConnection()){
//            PreparedStatement preparedStatement = connection.prepareStatement(cleaupSQL);
//            preparedStatement.setInt(1,workSpaces.getId());
//            preparedStatement.executeUpdate();
//        }
//    }
//    @Test
//    public void shouldAddWorkspaceToReservationsWhenReservationIsMade() throws SQLException {
//        reservationsDAO.makeReservation(workSpaces.getId());
//        String sql = "SELECT * FROM workspacemanager WHERE id = ?";
//        try (Connection connection = HibernateUtil.getConnection()) {
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setInt(1, workSpaces.getId());
//            ResultSet resultSet = statement.executeQuery();
//            Assertions.assertTrue(resultSet.next(), "Workspace should exist in the database");
//            Assertions.assertEquals(workSpaces.getId(), resultSet.getInt("id"), "Workspace ID mismatch");
//            Assertions.assertEquals(workSpaces.getType(), resultSet.getString("type"), "Workspace type mismatch");
//            Assertions.assertEquals(workSpaces.getPrice(), resultSet.getDouble("price"), "Workspace price mismatch");
//            Assertions.assertFalse(resultSet.getBoolean("availabilitystatus"), "Workspace should be marked unavailable");
//        } catch (SQLException e) {
//            e.printStackTrace();
//            Assertions.fail("Database operation failed: " + e.getMessage());
//        }
//    }
//
//    @Test
//    public void shouldThrowExceptionWhenReservationIsInvalid()  {
//        SQLException notFoundException = Assertions.assertThrows(SQLException.class, () ->{
//            reservationsService.makeReservation(2);
//        });
//        Assertions.assertEquals("Workspace 2 does not exist or is not available.", notFoundException.getMessage());
//    }
//    @Test
//    public void shouldRemoveWorkspaceFromReservationsWhenCancelled() throws SQLException {
//        reservationsDAO.cancelReservation(workSpaces.getId());
//        String sql = "SELECT * FROM reservations WHERE id = ? ";
//        try(Connection connection = HibernateUtil.getConnection()){
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setInt(1,workSpaces.getId());
//            ResultSet resultSet = preparedStatement.executeQuery();
//            Assertions.assertFalse(resultSet.next());
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//
//    }
}