import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class RideBookingSystem {
        public static void main(String[] args){
            try {
                Class.forName("org.postgresql.Driver");
                Connection cn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/fsd", "postgres", "1ch005E&!");
                System.out.println("Connected to the PostgreSQL database!");

                Statement st = cn.createStatement();
//                cn.close();
//                System.out.println("Connection Closed");
            } catch (Exception e){
                e.printStackTrace();
            }
        }

    public List<Ride> rideList = new ArrayList<>();
    public List<User> userList = new ArrayList<>();
    public List<Booking> bookingList = new ArrayList<>();

    private User loggedInUser = null;

    public void registerUser(String name, String email, long mobile, String password) {
        User user = new User(name, email, mobile, password);
        userList.add(user);
        System.out.println("User registered successfully");
    }

    public boolean login(String email, String password) {
        for (User user : userList) {
            if (user.getEmail().equals(email) &&
                    user.getPassword().equals(password)) {

                loggedInUser = user;
                System.out.println("Login successful");
                return true;
            }
        }
        System.out.println("Invalid credentials");
        return false;
    }

    public void updateUser(String newName, long newMobile) {
        if (loggedInUser != null) {
            loggedInUser.setName(newName);
            loggedInUser.setMobile(newMobile);
            System.out.println("User updated");
        }
    }

    public void deleteUser() {
        if (loggedInUser != null) {
            userList.remove(loggedInUser);
            loggedInUser = null;
            System.out.println("User deleted");
        }
    }

    //  RIDE MANAGEMENT

    public void createRide(String source, String destination,
                           int total_seats, int available_seats, double fare) {

        if (loggedInUser == null) {
            System.out.println("Login first to create ride");
            return;
        }
        // verify DL

        Ride ride = new Ride(source, destination, total_seats, available_seats, fare);
        ride.created_by = loggedInUser;
        rideList.add(ride);

        System.out.println("Ride created");
    }

    public List<Ride> getAllRide() {
        return rideList;
    }

    public List<Ride> searchRide(String source, String destination) {

        List<Ride> result = new ArrayList<>();

        for (Ride ride : rideList) {
            if (ride.source.equalsIgnoreCase(source) &&
                    ride.destination.equalsIgnoreCase(destination) &&
                    ride.available_seats > 0) {

                result.add(ride);
            }
        }
        return result;
    }

    public void deleteRide(Ride ride) {
        if (ride.created_by == loggedInUser) {
            rideList.remove(ride);
            System.out.println("Ride deleted");
        } else {
            System.out.println("You cannot delete this ride");
        }
    }


    public void bookRide(Ride ride, int seats) {

        if (loggedInUser == null) {
            System.out.println("Login first");
            return;
        }

        if (ride.available_seats >= seats) {
            ride.available_seats -= seats;
            bookingList.add(new Booking(ride, seats));
            System.out.println("Ride booked");
        } else {
            System.out.println("Not enough seats");
        }
    }

    public List<Ride> getUserBookedRides() {

        List<Ride> list = new ArrayList<>();

        for (Booking b : bookingList) {
            if (b.user == loggedInUser) {
                list.add(b.ride);
            }
        }
        return list;
    }

    public List<Ride> getUserCreatedRides() {

        List<Ride> list = new ArrayList<>();

        for (Ride ride : rideList) {
            if (ride.created_by == loggedInUser) {
                list.add(ride);
            }
        }
        return list;
    }

    public void updateBooking(Booking booking, int newSeatCount) {

        if (booking.user != loggedInUser) {
            System.out.println("Cannot update booking");
            return;
        }

        int oldSeats = booking.bookedSeats;
        int diff = newSeatCount - oldSeats;

        if (diff > 0 && booking.ride.available_seats >= diff) {
            booking.ride.available_seats -= diff;
            booking.bookedSeats = newSeatCount;
            System.out.println("Booking updated");
        }
        else if (diff < 0) {
            booking.ride.available_seats += (-diff);
            booking.bookedSeats = newSeatCount;
            System.out.println("Booking updated");
        }
    }

    public void deleteBooking(Booking booking) {
        booking.ride.available_seats += booking.bookedSeats;
        bookingList.remove(booking);
        System.out.println("Booking deleted");
    }
}