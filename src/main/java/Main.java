import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final String
            CUSTOMERS_FILE = System.getProperty("user.dir") + "\\src\\main\\resources\\customers.json";
    private static final double OFFICE_LATITUDE = 53.339428;
    private static final double OFFICE_LONGITUDE = -6.257664;
    private static final double RADIUS_WITHIN_KM = 100;
    private static final double EARTH_RADIUS_KM = 6371;
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {


        List<Customer> customers;
        List<Customer> customersToInvite = new ArrayList<>();

        JSONReadFromFile jsonReadFromFile = new JSONReadFromFile();
        DistanceCalculator distanceCalculator = new DistanceCalculator();

        try {
            customers = jsonReadFromFile.read(CUSTOMERS_FILE);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error reading from file: " + e.getLocalizedMessage());
            return;
        }

        if (customers.isEmpty()) { LOGGER.log(Level.INFO, ("Customers file was empty")); return;}

        for (Customer customer : customers) {

            if (distanceCalculator.isWithin(OFFICE_LATITUDE,
                                            OFFICE_LONGITUDE,
                                            customer.getLatitude(),
                                            customer.getLongitude(),
                                            RADIUS_WITHIN_KM,
                                            EARTH_RADIUS_KM)) {
                customersToInvite.add(customer);
            }
        }

        customersToInvite.sort(new CustomerComparator());

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("List of customers to invite:\n");

        for (Customer customer : customersToInvite) {
            stringBuilder.append("Name: ");
            stringBuilder.append(customer.getName());
            stringBuilder.append(" ID: ");
            stringBuilder.append(customer.getUser_id());
            stringBuilder.append("\n");
        }

        String invitationList = stringBuilder.toString();

        LOGGER.log(Level.INFO, invitationList);

    }
}
