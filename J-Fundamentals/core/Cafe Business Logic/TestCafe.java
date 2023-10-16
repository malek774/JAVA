import java.util.ArrayList;
import java.util.Arrays;

public class TestCafe {
    public static void main(String[] args) {
        CafeUtil appTest = new CafeUtil(); // Instantiate CafeUtil class
        
        // Streak Goal Test
        int streakGoal = appTest.getStreakGoal(10);
        System.out.println("Purchases needed by week 10: " + streakGoal);
        
        // Order Total Test
        double[] lineItems = {3.5, 1.5, 4.0, 4.5};
        double orderTotal = appTest.getOrderTotal(lineItems);
        System.out.println("Order total: " + orderTotal);
        
        // Display Menu Test
        ArrayList<String> menu = new ArrayList<String>();
        menu.add("drip coffee");
        menu.add("cappuccino");
        menu.add("latte");
        menu.add("mocha");
        appTest.displayMenu(menu);
        
        // Add Customer Test
        ArrayList<String> customers = new ArrayList<String>();
        // --- Test 4 times ---
        for (int i = 0; i < 4; i++) {
            appTest.addCustomer(customers);
            System.out.println("\n");
        }
    }
}
