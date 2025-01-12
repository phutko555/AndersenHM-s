import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomerTest {
    private Customer customer;
    private Reservations reservations;
    private WorkspaceManager workspaceManager;
    private WorkSpaces workSpaces;
    private Admin admin;

    @BeforeEach
    public void setUp(){
        workspaceManager = new WorkspaceManager();
        reservations = new Reservations();
        customer = new Customer(reservations,workspaceManager);
        workSpaces = new WorkSpaces(1,"VIP",50.5,true);
        admin = new Admin(workspaceManager);
        admin.addCoSpace(workSpaces);
    }

    @Test
    public void shouldAddWorkspaceToReservationsWhenReservationIsMade() throws NotFoundException {
        customer.makeReservation(1);
        Assertions.assertTrue(reservations.getReservations().contains(workSpaces));
    }
    @Test
    public void shouldThrowExceptionWhenReservationIsInvalid()  {
        NotFoundException notFoundException = Assertions.assertThrows(NotFoundException.class, () ->{
            customer.makeReservation(2);
        });
        Assertions.assertEquals("No available workspace found with ID 2",notFoundException.getMessage());
    }
    @Test
    public void shouldRemoveWorkspaceFromReservationsWhenCancelled() throws NotFoundException {
        customer.makeReservation(1);
        int initialSize = reservations.getReservations().size();
        customer.cancelReservation(1);
        Assertions.assertEquals(initialSize - 1,reservations.getReservations().size());
    }
}