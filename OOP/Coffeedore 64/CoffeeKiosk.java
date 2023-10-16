import java.util.ArrayList;
import java.util.Scanner;

public class CoffeeKiosk {
    private ArrayList<Item> menu;
    private ArrayList<Order> orders;

    public CoffeeKiosk() {
        menu = new ArrayList<>();
        orders = new ArrayList<>();
    }

    public void addMenuItem(String name, double price) {
        Item newItem = new Item(name, price);
        newItem.setIndex(menu.size());
        menu.add(newItem);
    }

    public void displayMenu() {
        for (int i = 0; i < menu.size(); i++) {
            Item item = menu.get(i);
            System.out.printf("%d %s -- $%.2f%n", i, item.getName(), item.getPrice());
        }
    }

    public void newOrder() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter customer name for new order:");
        String customerName = scanner.nextLine();

        Order order = new Order(customerName);
        System.out.println("Menu:");
        displayMenu();
        System.out.println("Please enter menu item indexes (e.g., 0,1,2) or 'q' to quit:");

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("q")) {
                break;
            }

            try {
                int itemIndex = Integer.parseInt(input);
                if (itemIndex >= 0 && itemIndex < menu.size()) {
                    Item menuItem = menu.get(itemIndex);
                    order.addItem(menuItem);
                } else {
                    System.out.println("Invalid item index. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid item index or 'q' to quit.");
            }
        }

        orders.add(order);
        System.out.println("Order details:");
        order.display();
    }

    public static void main(String[] args) {
        CoffeeKiosk kiosk = new CoffeeKiosk();
        kiosk.addMenuItem("banana", 2.00);
        kiosk.addMenuItem("coffee", 1.50);
        kiosk.addMenuItem("latte", 4.50);
        kiosk.addMenuItem("capuccino", 3.00);
        kiosk.addMenuItem("muffin", 4.00);

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Options:");
            System.out.println("1. New Order");
            System.out.println("2. Add Menu Item");
            System.out.println("3. Quit");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    kiosk.newOrder();
                    break;
                case "2":
                    // Add menu item (NINJA BONUS)
                    break;
                case "3":
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
