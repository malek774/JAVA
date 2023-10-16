import java.util.Random;

public class BankAccount {
    // Member variables
    private double checkingBalance;
    private double savingsBalance;
    private static int numberOfAccounts = 0;
    private static double totalMoneyStored = 0;
    private final String accountNumber;

    // Constructor
    public BankAccount() {
        numberOfAccounts++;
        this.checkingBalance = 0;
        this.savingsBalance = 0;
        this.accountNumber = generateAccountNumber();
    }

    // Getter methods
    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    // Deposit money into either checking or savings
    public void deposit(String accountType, double amount) {
        if (accountType.equals("checking")) {
            checkingBalance += amount;
        } else if (accountType.equals("savings")) {
            savingsBalance += amount;
        }
        totalMoneyStored += amount;
    }

    // Withdraw money from either checking or savings
    public void withdraw(String accountType, double amount) {
        if (accountType.equals("checking") && checkingBalance >= amount) {
            checkingBalance -= amount;
            totalMoneyStored -= amount;
        } else if (accountType.equals("savings") && savingsBalance >= amount) {
            savingsBalance -= amount;
            totalMoneyStored -= amount;
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    // Get total money stored
    public static double getTotalMoneyStored() {
        return totalMoneyStored;
    }

    // Private method to generate a random ten-digit account number
    private String generateAccountNumber() {
        Random random = new Random();
        StringBuilder accountNumber = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            accountNumber.append(random.nextInt(10));
        }
        return accountNumber.toString();
    }
}
