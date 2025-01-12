import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

public class AdminTest {
    private WorkspaceManager workspaceManager;
    private Admin admin;
    private WorkSpaces workSpaces;

    @BeforeEach
     public void setUp(){
         workspaceManager = new WorkspaceManager();
         admin = new Admin(workspaceManager);
         workSpaces = new WorkSpaces(1,"VIP",50.5,true);
        admin.addCoSpace(workSpaces);
    }

    @Test
    public void shouldContainWorkspaceAfterAdding(){
      Assertions.assertTrue(workspaceManager.getSpaces().contains(workSpaces),"Workspace should be in the list after being added.");
    }
    @Test
    public void shouldRemoveWorkspace() throws NotFoundException{
        int initialSize = workspaceManager.getSpaces().size();
        admin.removeCoSpace(1);
        Assertions.assertFalse(workspaceManager.getSpaces().contains(workSpaces));
        Assertions.assertEquals(initialSize - 1,workspaceManager.getSpaces().size());
    }
    @Test
    public void shouldThrowExceptionWhenSpaceIsInvalid(){
        NotFoundException exception = Assertions.assertThrows(NotFoundException.class, () -> {
            admin.removeCoSpace(2);
        });
        Assertions.assertEquals("Workspace with ID 2 not found!", exception.getMessage());
    }
    @Test
    public void shouldAvoidDuplicateValues(){
        admin.addCoSpace(workSpaces);
        Assertions.assertEquals(1,workspaceManager.getSpaces().size());
    }

}