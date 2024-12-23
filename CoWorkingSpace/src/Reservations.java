import java.util.ArrayList;
import java.util.List;

public class Reservations {
    private List<WorkSpaces> reservations;

    public Reservations() {
        this.reservations = new ArrayList<>();
    }

    public List<WorkSpaces> getReservations() {
        return reservations;
    }
}
