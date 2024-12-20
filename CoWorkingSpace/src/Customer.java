import java.util.ArrayList;
import java.util.List;

public class Customer{
    private Admin admin;
    private List<WorkSpace> work;

    public Customer(Admin admin){
        this.admin = admin;
        this.work = new ArrayList<>();
    }
    public void browseAvailableSpaces(){
        boolean available = false;
        System.out.println("Available spaces: ");
        for (WorkSpace workSpace : admin.getWork()) {
            if(workSpace.isAvailabilityStatus()){
                System.out.println(workSpace);
                available = true;
            }
        }
        if(!available){
            System.out.println("There are no available spaces");
        }

    }
    public void makeReservation(int id ){
        WorkSpace worker = null;
        for (WorkSpace workSpace : admin.getWork()) {
            if(workSpace.isAvailabilityStatus() && workSpace.getId() == id){
                workSpace.setAvailabilityStatus(false);
                worker = workSpace;
                break;
            }
        }
        if (worker != null) {
            work.add(worker);
            System.out.println("Reservation successful for workspace with ID: " + id);
        } else {
            System.out.println("No available workspace found with ID " + id);
        }

    }
    public void ownReservation(){
        if (work.isEmpty()) {
            System.out.println("You don't have any reservations.");
        } else {
            for (WorkSpace workSpace : work) {
                System.out.println(workSpace);
            }
        }

    }
    public void cancelReservation(int id){
        WorkSpace worker = null;
        for(WorkSpace workSpace: work){
            if(workSpace.getId() == id){
                worker = workSpace;
            }
        }
        if(worker != null){
            work.remove(worker);
            System.out.println("Reservation removed successfully " + id);

        }else{
            System.out.println("No active reservation found with ID " + id);
        }
    }
}
