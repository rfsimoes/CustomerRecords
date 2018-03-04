public class Customer {

    private Double latitude;
    private Double longitude;
    private Integer user_id;
    private String name;

    public Customer(double latitude, double longitude, int user_id, String name) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.user_id = user_id;
        this.name = name;
    }

    public Customer() {

    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getName() {
        return name;
    }

    public boolean isValid() {
        return latitude != null && longitude != null && user_id != null && name != null;
    }

    @Override public String toString() {
        return "Customer{" +
               "latitude=" + (latitude != null ? latitude : "null") +
               ", longitude=" + (longitude != null ? longitude : "null") +
               ", user_id=" + (user_id != null ? user_id : "null") +
               ", name='" + (name != null ? name : "null") + '\'' +
               '}';
    }
}
