import com.google.gson.JsonSyntaxException;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JSONReadFromFileTest {

    JSONReadFromFile jsonReadFromFile = new JSONReadFromFile();

    @Test
    void read_malformatted() {
        List<Customer> customerList = new ArrayList<>();
        try {
            customerList = jsonReadFromFile.read("src/test/resources/malformatted.json");
        } catch (Exception e) {
            fail("Unexpected error! " + e.getLocalizedMessage());
        }

        assertEquals(1, customerList.size());
        assertEquals(2, customerList.get(0).getUser_id());
        assertEquals(1, customerList.get(0).getLatitude());
        assertEquals(3, customerList.get(0).getLongitude());
        assertEquals("Ricardo Simoes", customerList.get(0).getName());
    }

    @Test
    void read_missing_info() {
        List<Customer> customerList = new ArrayList<>();
        try {
            customerList = jsonReadFromFile.read("src/test/resources/missinginfo.json");
        } catch (Exception e) {
            fail("Unexpected error! " + e.getLocalizedMessage());
        }

        assertEquals(1, customerList.size());
        assertEquals(2, customerList.get(0).getUser_id());
        assertEquals(1, customerList.get(0).getLatitude());
        assertEquals(3, customerList.get(0).getLongitude());
        assertEquals("Ricardo Simoes", customerList.get(0).getName());
    }

    @Test
    void read_file_doesnt_exist() {
        try {
            jsonReadFromFile.read("src/test/resources/notfound.json");
        } catch (Exception e) {
            assertEquals(FileNotFoundException.class, e.getClass());
        }
    }

    @Test
    void read_empty() {
        List<Customer> customerList = new ArrayList<>();
        try {
            customerList = jsonReadFromFile.read("src/test/resources/empty.json");
        } catch (Exception e) {
            fail("Unexpected error! " + e.getLocalizedMessage());
        }

        assertTrue(customerList.isEmpty());
    }

    @Test
    void read_success() {
        List<Customer> customerList = new ArrayList<>();
        try {
            customerList = jsonReadFromFile.read("src/test/resources/customers.json");
        } catch (Exception e) {
            fail("Unexpected erro! " + e.getLocalizedMessage());
        }

        assertEquals(2, customerList.size());
        assertEquals(12, customerList.get(0).getUser_id());
        assertEquals(52.986375, customerList.get(0).getLatitude());
        assertEquals(-6.043701, customerList.get(0).getLongitude());
        assertEquals("Christina McArdle", customerList.get(0).getName());
        assertEquals(1, customerList.get(1).getUser_id());
        assertEquals(51.92893, customerList.get(1).getLatitude());
        assertEquals(-10.27699, customerList.get(1).getLongitude());
        assertEquals("Alice Cahill", customerList.get(1).getName());
    }


}