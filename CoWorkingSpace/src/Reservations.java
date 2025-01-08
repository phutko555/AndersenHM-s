import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class Reservations implements Serializable {

    private CustomArray<WorkSpaces> reservations;
    public Reservations() {
        this.reservations = new CustomArray<>();
    }

    public CustomArray<WorkSpaces> getReservations() {
        return reservations;
    }
}
