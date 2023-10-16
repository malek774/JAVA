public class CafeJava {
    public static void main(String[] args) {
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        double mochaPrice = 4.0;
        double dripCoffeePrice = 2.5; // Price for drip coffee
        double lattePrice = 3.8; // Price for latte
        double cappuccinoPrice = 4.2; // Price for cappuccino
        
        String customer1 = "Cindhuri";
        String customer2 = "Sam"; // Customer Sam 
        String customer3 = "Jimmy"; // Customer Jimmy
        String customer4 = "Noah"; // Customer Noah
        
        boolean isReadyOrder1 = true;
        boolean isReadyOrder2 = false; // Order status for customer Sam 
        boolean isReadyOrder3 = true; // Order status for customer Jimmy
        boolean isReadyOrder4 = false; // Order status for customer Noah
        
        System.out.println(generalGreeting + customer1);

        if (isReadyOrder1) {
            System.out.println(customer1 + readyMessage); // Order is ready
            System.out.println(displayTotalMessage + mochaPrice); // Display total price
        } else {
            System.out.println(customer1 + pendingMessage); // Order will be ready shortly
        }

        if (isReadyOrder4) {
            System.out.println(customer4 + readyMessage); // Order is ready
            System.out.println(displayTotalMessage + cappuccinoPrice); // Display total price
        } else {
            System.out.println(customer4 + pendingMessage); // Order will be ready shortly
        }

        System.out.println(generalGreeting + customer2); // Displays "Welcome to Cafe Java, Sam"
        
        // Calculating the total price for 2 lattes
        double totalLattePrice = 2 * lattePrice;
        System.out.println(displayTotalMessage + totalLattePrice); // Display total price for 2 lattes
        
        // Checking and printing the order status message based on the isReadyOrder2 flag
        if (isReadyOrder2) {
            System.out.println(customer2 + readyMessage); // Order is ready
        } else {
            System.out.println(customer2 + pendingMessage); // Order will be ready shortly
        }
        
        // Change the order status flag to test control logic
        isReadyOrder2 = true; // Change the flag to true
        
        // Checking and printing the order status message again after changing the flag
        if (isReadyOrder2) {
            System.out.println(customer2 + readyMessage); // Order is ready
        } else {
            System.out.println(customer2 + pendingMessage); // Order will be ready shortly
        }

        // Simulating customer interaction for Jimmy
        System.out.println(generalGreeting + customer3); // Displays "Welcome to Cafe Java, Jimmy"
        
        // Calculating the price difference between a coffee and a latte
        double priceDifference = lattePrice - dripCoffeePrice;
        
        // Printing the new total message with the calculated price difference
        System.out.println("You were charged for a coffee, but you ordered a latte.");
        System.out.println("You owe an additional $" + priceDifference);
    }
}