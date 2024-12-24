import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class WorkspaceManager implements Serializable {
    private  List<WorkSpaces> spaces;
    public WorkspaceManager() {
        this.spaces = new ArrayList<>();
    }

    public List<WorkSpaces> getSpaces() {
        return spaces;
    }
}