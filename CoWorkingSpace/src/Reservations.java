import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class Reservations implements Serializable {

    private List<WorkSpaces> reservations;
    public Reservations() {
        this.reservations = new ArrayList<>();
    }
    public List<WorkSpaces> getReservations() {
        return reservations;
    }
}
