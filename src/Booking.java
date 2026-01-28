public class Booking {
    public int bookedSeats;
    int booking_id;
    Ride ride;
    User user;
    int total_seats;
    double total_fare;

    public Booking(int bookedSeats, int booking_id, Ride ride, User user, int total_seats, double total_fare) {
        this.bookedSeats = bookedSeats;
        this.booking_id = booking_id;
        this.ride = ride;
        this.user = user;
        this.total_seats = total_seats;
        this.total_fare = total_fare;
    }

    public Booking(User loggedInUser, Ride ride, int seats) {

    }

    @Override
    public String toString() {
        return "Booking{" +
                "booking_id=" + booking_id +
                ", ride=" + ride +
                ", user=" + user +
                ", total_seats=" + total_seats +
                ", total_fare=" + total_fare +
                '}';
    }
}
