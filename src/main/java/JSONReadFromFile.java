import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class JSONReadFromFile {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public List<Customer> read(String file) throws IOException {
        Gson gson = new Gson();
        String line;
        List<Customer> customers = new ArrayList<>();
        Customer customer;


        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                try {
                    customer = gson.fromJson(line, Customer.class);
                    if (!customer.isValid()) {
                        LOGGER.log(Level.WARNING,
                                   "Invalid customer, it's missing some attributes:{0}\nIgnoring it!",
                                   customer);
                    } else { customers.add(customer); }
                } catch (JsonSyntaxException e) {
                    LOGGER.log(Level.WARNING,
                               "Invalid Json. Ignoring customer.\n" + line + "\n" + e.getLocalizedMessage());
                }
            }
        }

        return customers;
    }
}
