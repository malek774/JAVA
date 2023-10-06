public class TestOrders {
    public static void main(String[] args) {
        // Create Item objects
        Item item1 = new Item("mocha", 3.5);
        Item item2 = new Item("latte", 4.0);

        // Create Order objects
        Order order1 = new Order();
        Order order2 = new Order("Cindhuri");

        // Add items to orders
        order1.addItem(item1);
        order1.addItem(item2);
        order2.addItem(item1);

        // Set order status
        order2.setReady(true);

        // Test getStatusMessage
        System.out.println(order1.getStatusMessage());
        System.out.println(order2.getStatusMessage());

        // Test getOrderTotal
        System.out.println("Order 1 Total: $" + order1.getOrderTotal());
        System.out.println("Order 2 Total: $" + order2.getOrderTotal());

        // Test display
        order1.display();
        order2.display();
    }
}
