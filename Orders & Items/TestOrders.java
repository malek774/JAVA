import java.util.ArrayList;

public class TestOrders {
    public static void main(String[] args) {

        // Create Item objects
        Item item1 = new Item("mocha", 3.5);
        Item item2 = new Item("latte", 4.0);
        Item item3 = new Item("drip coffee", 2.0);
        Item item4 = new Item("cappuccino", 4.5);

        // Create Order objects
        Order order1 = new Order("Cindhuri");
        Order order2 = new Order("Jimmy");
        Order order3 = new Order("Noah");
        Order order4 = new Order("Sam");

        // Print order1 to the console
        System.out.println("Order 1:");
        System.out.printf("Name: %s\n", order1.name);
        System.out.printf("Total: %.2f\n", order1.total);
        System.out.printf("Ready: %s\n\n", order1.ready);

        // Add item1 to order2's item list and increment the order's total
        order2.items.add(item1);
        order2.total += item1.price;

        // Order 3 ordered a cappuccino. Add the cappuccino to their order list and update their tab.
        order3.items.add(item4);
        order3.total += item4.price;

        // Order 4 added a latte. Update accordingly.
        order4.items.add(item2);
        order4.total += item2.price;

        // Cindhuri’s order is now ready. Update her status.
        order1.ready = true;

        // Sam ordered more drinks - 2 lattes. Update their order as well.
        order4.items.add(item2);
        order4.total += item2.price * 2;

        // Jimmy’s order is now ready. Update his status.
        order2.ready = true;

        // Print order1 again to see the updated status
        System.out.println("Updated Order 1:");
        System.out.printf("Name: %s\n", order1.name);
        System.out.printf("Total: %.2f\n", order1.total);
        System.out.printf("Ready: %s\n", order1.ready);
    }
}
