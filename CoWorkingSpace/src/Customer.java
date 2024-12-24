import java.io.Serializable;

public class Customer implements Serializable {

    private static final long serialVersionUID = 134528019936612357L;
    private Reservations reservations;
    private WorkspaceManager workspaceManager;

    public Customer(Reservations reservations, WorkspaceManager workspaceManager) {
        this.reservations = reservations;
        this.workspaceManager = workspaceManager;
    }
    public void browseAvailableSpaces(){
        boolean available = false;
        System.out.println("Available spaces: ");
        for (WorkSpaces workSpaces : workspaceManager.getSpaces()) {
            if(workSpaces.isAvailabilityStatus()){
                System.out.println(workSpaces);
                available = true;
            }
        }
        if(!available){
            System.out.println("There are no available spaces");
        }
    }
    public void makeReservation(int id ) throws NotFoundException{
        WorkSpaces worker = null;
        for (WorkSpaces workSpaces : workspaceManager.getSpaces()) {
            if(workSpaces.isAvailabilityStatus() && workSpaces.getId() == id){
                workSpaces.setAvailabilityStatus(false);
                worker = workSpaces;
                break;
            }
        }
        if (worker != null) {
            reservations.getReservations().add(worker);
            System.out.println("Reservation successful for workspace with ID: " + id);
        } else {
            throw new NotFoundException("No available workspace found with ID " + id);

        }

    }
    public void ownReservation(){
        if (reservations.getReservations().isEmpty()) {
            System.out.println("You don't have any reservations.");
        } else {
            for (WorkSpaces workSpaces : reservations.getReservations()) {
                System.out.println(workSpaces);
            }
        }
    }
    public void cancelReservation(int id) throws NotFoundException{
        WorkSpaces worker = null;
        for(WorkSpaces workSpaces : reservations.getReservations()){
            if(workSpaces.getId() == id){
                worker = workSpaces;
                break;
            }
        }
        if(worker != null){
            reservations.getReservations().remove(worker);
            System.out.println("Reservation with ID: " + id +" Removed Successfully");
        }else{
            throw new NotFoundException("No active reservation found with ID " + id);
        }
    }
}