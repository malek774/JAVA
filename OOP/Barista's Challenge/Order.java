import java.util.ArrayList;

public class Order {
    // MEMBER VARIABLES
    private String name; 
    private boolean ready;
    private ArrayList<Item> items;

    // CONSTRUCTOR
    public Order() {
        this.name = "Guest";
        this.ready = false;
        this.items = new ArrayList<>();
    }

    // OVERLOADED CONSTRUCTOR
    public Order(String name) {
        this.name = name;
        this.ready = false;
        this.items = new ArrayList<>();
    }

    // ADD ITEM METHOD
    public void addItem(Item item) {
        items.add(item);
    }

    // GETTERS & SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    // GET ORDER TOTAL METHOD
    public double getOrderTotal() {
        double total = 0.0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }

    // GET STATUS MESSAGE METHOD
    public String getStatusMessage() {
        if (ready) {
            return "Your order is ready.";
        } else {
            return "Thank you for waiting. Your order will be ready soon.";
        }
    }

    // DISPLAY METHOD
    public void display() {
        System.out.println("Customer Name: " + name);
        for (Item item : items) {
            System.out.println(item.getName() + " - $" + item.getPrice());
        }
        System.out.println("Total: $" + getOrderTotal());
    }
}
