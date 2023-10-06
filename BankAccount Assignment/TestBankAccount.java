public class TestBankAccount {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount();
        BankAccount account2 = new BankAccount();

        account1.deposit("checking", 1000);
        account1.deposit("savings", 2000);

        account2.deposit("checking", 500);
        account2.withdraw("checking", 200);

        System.out.println("Account 1 - Checking Balance: $" + account1.getCheckingBalance());
        System.out.println("Account 1 - Savings Balance: $" + account1.getSavingsBalance());

        System.out.println("Account 2 - Checking Balance: $" + account2.getCheckingBalance());
        System.out.println("Account 2 - Savings Balance: $" + account2.getSavingsBalance());

        System.out.println("Total Money Stored in All Accounts: $" + BankAccount.getTotalMoneyStored());
    }
}
