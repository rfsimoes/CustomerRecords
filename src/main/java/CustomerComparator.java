import java.util.Comparator;

public class CustomerComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {

        if (o1 == null || o2 == null) { return -1; }

        if (!(o1 instanceof Customer) || !(o2 instanceof Customer)) { return -1; }

        Customer c1 = (Customer) o1;
        Customer c2 = (Customer) o2;

        return Integer.compare(c1.getUser_id(), c2.getUser_id());

    }
}
