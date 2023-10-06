import java.util.ArrayList;

public class Order {
    private String customerName;
    private ArrayList<Item> items;

    public Order(String customerName) {
        this.customerName = customerName;
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void display() {
        System.out.println("Customer Name: " + customerName);
        for (Item item : items) {
            System.out.printf("%s - $%.2f%n", item.getName(), item.getPrice());
        }
        System.out.println("Total: $" + calculateTotal());
    }

    private double calculateTotal() {
        double total = 0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }
}

