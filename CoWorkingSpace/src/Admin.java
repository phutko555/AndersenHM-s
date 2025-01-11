import java.io.Serializable;
public class Admin implements Serializable {
    private static final long serialVersionUID = 5467568632194107991L;
    private WorkspaceManager workspaceManager;

    public Admin() {
    }
    public Admin(WorkspaceManager workSpace) {
        this.workspaceManager = workSpace;
    }

    public void addCoSpace(WorkSpaces workSpaces) {
        workspaceManager.getSpaces().add(workSpaces);
        System.out.println("Added successfully: " + workSpaces);
    }
    public void removeCoSpace(int id) throws NotFoundException{
        for (int i = 0; i < workspaceManager.getSpaces().size(); i++) {
            if (workspaceManager.getSpaces().get(i).getId() == id) {
                workspaceManager.getSpaces().remove(i);
                System.out.println("Workspace with ID " + id + " removed successfully.");
                return;
            }
        }
        throw new NotFoundException("Workspace with ID " + id + " not found!");
    }
    public void viewAllReservations(){
        workspaceManager.getSpaces().stream().forEach(x -> {
            if(!x.isAvailabilityStatus()){
                System.out.println("Reservation: " + x);
            }else{
                System.out.println("There aren't any reservations");
            }
        });
    }
}