import java.util.ArrayList;
import java.util.List;

public class WorkspaceManager {
    private  List<WorkSpaces> spaces;
    public WorkspaceManager() {
        this.spaces = new ArrayList<>();
    }

    public List<WorkSpaces> getSpaces() {
        return spaces;
    }
}