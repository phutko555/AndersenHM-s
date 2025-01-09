import java.io.Serializable;
import java.util.Optional;

public class Customer implements Serializable {

    private static final long serialVersionUID = 134528019936612357L;
    private Reservations reservations;
    private WorkspaceManager workspaceManager;

    public Customer(Reservations reservations, WorkspaceManager workspaceManager) {
        this.reservations = reservations;
        this.workspaceManager = workspaceManager;
    }
    public void browseAvailableSpaces(){
        long availableCount = workspaceManager.getSpaces().stream().filter(x -> x.isAvailabilityStatus())
                .peek(x-> System.out.println("Available: " + x)).count();
        if(availableCount == 0){
            System.out.println("There aren't any available spaces");
        }
    }
    public void makeReservation(int id) throws NotFoundException{
        WorkSpaces work = workspaceManager.getSpaces().stream().filter(x -> x.isAvailabilityStatus() && x.getId() == id)
                .findFirst().orElseThrow(() -> new NotFoundException("No available workspace found with ID " + id));

            work.setAvailabilityStatus(false);
            reservations.getReservations().add(work);
            System.out.println("Reservation successful for workspace with ID: " + id);
    }

    public void ownReservation(){
        reservations.getReservations().stream().findFirst().ifPresentOrElse
                (x -> reservations.getReservations().forEach(System.out::println),
                () -> System.out.println("You don't have any reservations."));
    }

    public void cancelReservation(int id) throws NotFoundException{
        WorkSpaces workSpaces = reservations.getReservations().stream().
                filter(x -> x.getId() == id).findFirst().
                orElseThrow(() -> new NotFoundException("No active reservation found with ID " + id));

            reservations.getReservations().remove(workSpaces.getId());
            System.out.println("Reservation with ID: " + id +" Removed Successfully");
    }
}