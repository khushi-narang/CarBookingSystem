import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        RideBookingSystem system = new RideBookingSystem();

        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Create Ride");
            System.out.println("4. View All Rides");
            System.out.println("5. Search Ride");
            System.out.println("6. Book Ride");
            System.out.println("7. View My Bookings");
            System.out.println("8. Update Ride");
            System.out.println("9. Update Booking");
            System.out.println("10. Delete Ride");
            System.out.println("11. Delete Booking");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1: { // Register
                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Mobile: ");
                    long mob = sc.nextLong();
                    sc.nextLine();

                    System.out.print("Password: ");
                    String pass = sc.nextLine();

                    system.registerUser(name, email, mob, pass);
                    break;
                }

                case 2: { // Login
                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Password: ");
                    String pass = sc.nextLine();

                    system.login(email, pass);
                    break;
                }

                case 3: { // create ride
                    System.out.print("Source: ");
                    String src = sc.nextLine();

                    System.out.print("Destination: ");
                    String dest = sc.nextLine();

                    System.out.print("Total seats: ");
                    int total_seats = sc.nextInt();

                    System.out.print("Available seats: ");
                    int avail_seats = sc.nextInt();

                    System.out.print("Fare: ");
                    double fare = sc.nextDouble();
                    sc.nextLine();

                    system.createRide(src, dest, total_seats, avail_seats, fare);
                    break;
                }

                case 4: {
                    List<Ride> rides = system.getAllRide();
                    if (rides.isEmpty()) {
                        System.out.println("No rides available");
                    } else {
                        for (int i = 0; i < rides.size(); i++) {
                            System.out.println(i + " -> " + rides.get(i));
                        }
                    }
                    break;
                }

                case 5: {
                    System.out.print("Source: ");
                    String src = sc.nextLine();

                    System.out.print("Destination: ");
                    String dest = sc.nextLine();

                    List<Ride> rides = system.searchRide(src, dest);
                    for (Ride r : rides) {
                        System.out.println(r);
                    }
                    break;
                }

                case 6: {
                    List<Ride> rides = system.getAllRide();
                    if (rides.isEmpty()) {
                        System.out.println("No rides available");
                        break;
                    }

                    for (int i = 0; i < rides.size(); i++) {
                        System.out.println(i + " -> " + rides.get(i));
                    }

                    System.out.print("Select ride index: ");
                    int idx = sc.nextInt();

                    System.out.print("Seats to book: ");
                    int seats = sc.nextInt();
                    sc.nextLine();

                    system.bookRide(rides.get(idx), seats);
                    break;
                }

                case 7: {
                    List<Ride> myRides = system.getUserBookedRides();
                    if (myRides.isEmpty()) {
                        System.out.println("No bookings found");
                    } else {
                        for (Ride r : myRides) {
                            System.out.println(r);
                        }
                    }
                    break;
                }

                case 8: {

                }

                case 9: {

                }

                case 10: {

                }

                case 11: {

                }

                case 0:
                    System.out.println("Exiting");
                    System.exit(0);

                default:
                    System.out.println("Invalid");
            }
        }
    }
}
