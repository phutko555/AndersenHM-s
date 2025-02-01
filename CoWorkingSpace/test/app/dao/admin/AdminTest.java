package app.dao.admin;

public class AdminTest {
//    private WorkSpaceDAO workSpaceDAO;
//    private WorkSpaceService workSpaceService;
//    private WorkSpaces workSpaces1;
//
//    @BeforeEach
//     public void setUp() throws SQLException {
//        workSpaceDAO = new WorkSpaceDAOImpl();
//        workSpaceService = new WorkSpaceService(workSpaceDAO);
//        workSpaces1 = new WorkSpaces(1,"Private Office",500.0,true);
//        workSpaceDAO.addWorkSpace(workSpaces1);
//    }
//
//    @AfterEach
//    public void tearDown() throws SQLException{
//        String cleaupSQL = "DELETE FROM workspacemanager WHERE id = ?";
//        try(Connection connection = HibernateUtil.getConnection()){
//            PreparedStatement preparedStatement = connection.prepareStatement(cleaupSQL);
//            preparedStatement.setInt(1,workSpaces1.getId());
//            preparedStatement.executeUpdate();
//        }
//    }
//
//    @Test
//    public void shouldContainWorkspaceAfterAdding() throws SQLException {
//      String sql = "SELECT * FROM workspacemanager WHERE id = ?";
//      try(Connection connection = HibernateUtil.getConnection()){
//          PreparedStatement preparedStatement = connection.prepareStatement(sql);
//          preparedStatement.setInt(1,workSpaces1.getId());
//          ResultSet resultSet = preparedStatement.executeQuery();
//          Assertions.assertTrue(resultSet.next(), "Workspace should exist in the database");
//          Assertions.assertEquals(workSpaces1.getType(),resultSet.getString("type"),"Workspace type mismatch");
//          Assertions.assertEquals(workSpaces1.getPrice(), resultSet.getDouble("price"), "Workspace price mismatch");
//          Assertions.assertEquals(workSpaces1.isAvailabilityStatus(),resultSet.getBoolean("availabilitystatus"),"Workspace availability status mismatch");
//      }catch (SQLException e){
//          e.printStackTrace();
//      }
//    }
//
//    @Test
//    public void shouldRemoveWorkspace() throws SQLException{
//        int idToRemove = workSpaces1.getId();
//        workSpaceDAO.removeWorkSpace(idToRemove);
//        String sql = "SELECT * FROM workspacemanager WHERE id = ?";
//        try(Connection connection = HibernateUtil.getConnection()){
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setInt(1,idToRemove);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            Assertions.assertFalse(resultSet.next(),"Workspace should no longer exist in the database");
//        }
//    }
//    @Test
//    public void shouldThrowExceptionWhenSpaceIsInvalid(){
//        int nonExistentId = 999;
//        SQLException exception = Assertions.assertThrows(SQLException.class,() ->{
//            workSpaceService.removeWorkSpace(nonExistentId);
//        });
//        Assertions.assertEquals("Workspace with ID "+ nonExistentId + " is not found",exception.getMessage());
//    }
}