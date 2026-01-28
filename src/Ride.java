import java.util.List;

public class Ride {

    String source;
    String destination;
    int total_seats;
    int available_seats;
    double fare;
    User created_by;

    public Ride(String source, String destination, int total_seats, int available_seats, double fare) {
        this.source = source;
        this.destination = destination;
        this.total_seats = total_seats;
        this.available_seats = available_seats;
        this.fare = fare;
    }



    @Override
    public String toString() {
        return "Ride{" +
                "source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", total_seats=" + total_seats +
                ", available_seats=" + available_seats +
                ", fare=" + fare +
                ", created_by=" + created_by +
                '}';
    }
}
