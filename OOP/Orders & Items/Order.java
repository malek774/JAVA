import java.util.ArrayList;

public class Order {
    String name;
    double total;
    boolean ready;
    ArrayList<Item> items;

    // Constructor
    public Order(String name) {
        this.name = name;
        this.total = 0.0;
        this.ready = false;
        this.items = new ArrayList<Item>();
    }
}
