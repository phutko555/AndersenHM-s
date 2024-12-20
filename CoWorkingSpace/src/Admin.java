import java.util.ArrayList;
import java.util.List;

public class Admin {
    private List<WorkSpace> work;
    public Admin() {
        this.work = new ArrayList<>();

    }
    public void addCoSpace(WorkSpace workSpace) {
        work.add(workSpace);
        System.out.println("Added Successfully: " + workSpace);
    }
    public void removeCoSpace(int id) {
        for (int i = 0; i < work.size(); i++) {
            if (work.get(i).getId() == id) {
                work.remove(i);
                System.out.println("Workspace with ID " + id + " removed successfully.");
                return;
            }
        }
        System.out.println("Workspace with ID " + id + " not found.");
    }

    public List<WorkSpace> getWork() {
        return work;
    }

    public void viewAllReservations(){
        System.out.println("Reservations: ");
        for(WorkSpace work1 : work){
            if(!work1.isAvailabilityStatus()){
                System.out.println(work1);
            }
        }
    }
}