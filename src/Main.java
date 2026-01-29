public class Main {
    public static void main(String[] args){
        RideBookingSystem rideBookingSystem = new RideBookingSystem();

        rideBookingSystem.registerUser( "Khushi", "khushi@gmail.com", 1162244855, "qwerty123");
        rideBookingSystem.login("khushi@gmail.com", "qwerty123");
        rideBookingSystem.createRide("Noida", "Delhi", 5, 3, 700.00);
        System.out.println(rideBookingSystem.getAllRide());

//        rideBookingSystem.bookRide();

        System.out.println();

    }

}
