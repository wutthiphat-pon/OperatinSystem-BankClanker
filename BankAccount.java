public class BankAccount {

    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;

    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {

        balance += amount;
        System.out.println("Deposit successful.");

    }

    public void withdraw(double amount) {

        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdraw successful.");

        } else
            System.out.println("You broke bruh.");

    }

    public void transfer(String transFName, String transLName, double amount) {
        for (Customer c : Customer.getCustomers()) {
            if (c.getFirstName().equalsIgnoreCase(transFName) && c.getLastName().equalsIgnoreCase(transLName)) {
                if (balance >= amount) {
                    balance -= amount;
                    c.getAccount().deposit(amount);
                    System.out.println("Transfer " + amount + " to " + transFName + " " + transLName + " successful.");
                } else {
                    System.out.println("Insufficient balance for transfer.");
                }
                return;
            }
        }
        System.out.println("Recipient not found: " + transFName + " " + transLName);
    }

}
