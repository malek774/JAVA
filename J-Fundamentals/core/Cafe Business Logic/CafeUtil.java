import java.util.ArrayList;

public class CafeUtil {

    // Method to calculate the streak goal based on the number of weeks
    public int getStreakGoal(int numWeeks) {
        int streakGoal = 0;
        for (int i = 1; i <= numWeeks; i++) {
            streakGoal += i;
        }
        return streakGoal;
    }

    // Method to calculate the total order cost given an array of item prices
    public double getOrderTotal(double[] prices) {
        double total = 0;
        for (double price : prices) {
            total += price;
        }
        return total;
    }

    // Method to display menu items along with their indices
    public void displayMenu(ArrayList<String> menuItems) {
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println(i + " " + menuItems.get(i));
        }
    }

    // Method to add a customer to the given list and display a welcome message
    public void addCustomer(ArrayList<String> customers) {
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        System.out.println("Hello, " + userName + "!");
        int numCustomersAhead = customers.size();
        System.out.println("There are " + numCustomersAhead + " people in front of you");
        customers.add(userName);
        System.out.println(customers);
    }
}
