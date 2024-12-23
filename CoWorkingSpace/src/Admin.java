
public class Admin {

    private WorkspaceManager workspaceManager;

    public Admin(WorkspaceManager workSpace) {
        this.workspaceManager = workSpace;
    }

    public void addCoSpace(WorkSpaces workSpaces) {
        workspaceManager.getSpaces().add(workSpaces);
        System.out.println("Added successfully: " + workSpaces);
    }
    public void removeCoSpace(int id) {
        for (int i = 0; i < workspaceManager.getSpaces().size(); i++) {
            if (workspaceManager.getSpaces().get(i).getId() == id) {
                workspaceManager.getSpaces().remove(i);
                System.out.println("Workspace with ID " + id + " removed successfully.");
                return;
            }
        }
        System.out.println("Workspace with ID " + id + " not found.");
    }

    public void viewAllReservations(){
        System.out.println("Reservations: ");
        for(WorkSpaces work1 : workspaceManager.getSpaces()){
            if(!work1.isAvailabilityStatus()){
                System.out.println(work1);
            }
        }
    }
}





