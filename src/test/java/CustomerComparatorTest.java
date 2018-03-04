import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerComparatorTest {

    private CustomerComparator customerComparator = new CustomerComparator();

    @org.junit.jupiter.api.Test
    void compare_ordered() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1, 2, 1, "Ricardo"));
        customers.add(new Customer(1, 2, 2, "Ricardo2"));
        customers.add(new Customer(1, 2, 3, "Ricardo3"));

        customers.sort(customerComparator);

        assertEquals(1, customers.get(0).getUser_id());
        assertEquals(2, customers.get(1).getUser_id());
        assertEquals(3, customers.get(2).getUser_id());
    }


    @org.junit.jupiter.api.Test
    void compare_reversed() {
        List<Customer> customers = new ArrayList<>();

        customers.add(new Customer(1, 2, 3, "Ricardo3"));
        customers.add(new Customer(1, 2, 2, "Ricardo2"));
        customers.add(new Customer(1, 2, 1, "Ricardo1"));

        customers.sort(customerComparator);

        assertEquals(1, customers.get(0).getUser_id());
        assertEquals(2, customers.get(1).getUser_id());
        assertEquals(3, customers.get(2).getUser_id());
    }

    @org.junit.jupiter.api.Test
    void compare_random_order() {
        List<Customer> customers = new ArrayList<>();

        customers.add(new Customer(1, 2, 2, "Ricardo2"));
        customers.add(new Customer(1, 2, 1, "Ricardo1"));
        customers.add(new Customer(1, 2, 3, "Ricardo3"));

        customers.sort(customerComparator);

        assertEquals(1, customers.get(0).getUser_id());
        assertEquals(2, customers.get(1).getUser_id());
        assertEquals(3, customers.get(2).getUser_id());
    }

    @org.junit.jupiter.api.Test
    void compare_wrong_instance() {
        int compare = customerComparator.compare(new Customer(), new Object());

        assertEquals(-1,compare);
    }

    @org.junit.jupiter.api.Test
    void compare_null() {
        int compare = customerComparator.compare(new Customer(), null);

        assertEquals(-1,compare);
    }

}