import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class WorkspaceManager implements Serializable {
    private CustomArray<WorkSpaces> spaces;
    public WorkspaceManager() {
        this.spaces = new CustomArray<>();
    }

    public CustomArray<WorkSpaces> getSpaces() {
        return spaces;
    }
}