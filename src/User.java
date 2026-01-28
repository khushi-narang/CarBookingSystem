import java.util.ArrayList;
import java.util.List;

public class User {
    int user_id;
    private String name;
    private String email;
    private long mobile;
    private String password;

    private List<Ride> bookedRides = new ArrayList<>();

    // generate constructors
    public User(String name, String email, long mobile, String password) {
        this.user_id = user_id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.password = password;
    }

    public void addBookedRide(Ride ride){
        this.bookedRides.add(ride);
    }

    public List<Ride> getBookedRides() {
        return bookedRides;
    }

    public int getUser_id(){ return  user_id; }
    public String getEmail() { return email; }
    public String getName() { return name; }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", name='" + name + '\'' +
                '}';
    }

//    public String getPasssword() {
//        return password;
//    }

    public Object getPassword() {
        return password;
    }
}
