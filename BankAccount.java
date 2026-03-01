public class BankAccount implements iBankAccount {

    private double balance;

    // Used only for thread demonstration
    private double transactionAmount;
    private boolean isDeposit;

    // Normal constructor
    public BankAccount(double balance) {
        this.balance = balance;
    }

    // Constructor used for concurrency demo
    public BankAccount(double balance, double transactionAmount, boolean isDeposit) {
        this.balance = balance;
        this.transactionAmount = transactionAmount;
        this.isDeposit = isDeposit;
    }

    public synchronized double getBalance() {
        return balance;
    }

    public synchronized void deposit(double amount) {

        try {
            Thread.sleep(100); // Scheduling simulation
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        balance += amount;

        System.out.println(Thread.currentThread().getName() +
                " deposited " + amount +
                " | Balance: " + balance);
    }

    public synchronized void withdraw(double amount) {

        if (balance >= amount) {

            try {
                Thread.sleep(100); // Scheduling simulation
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            balance -= amount;

            System.out.println(Thread.currentThread().getName() +
                    " withdrew " + amount +
                    " | Balance: " + balance);

        } else {
            System.out.println(Thread.currentThread().getName() +
                    " failed withdrawal. Insufficient balance.");
        }
    }

    // Synchronized transfer method to ensure thread safety during transfers
    public synchronized void transfer(String transFName, String transLName, double amount) {

        for (Customer c : Customer.getCustomers()) {

            if (c.getFirstName().equalsIgnoreCase(transFName)
                    && c.getLastName().equalsIgnoreCase(transLName)) {

                if (balance >= amount) {

                    try {
                        Thread.sleep(100); // Scheduling simulation
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    balance -= amount;

                    // Deposit to recipient account (also synchronized)
                    c.getAccount().deposit(amount);

                    System.out.println(Thread.currentThread().getName() +
                            " transferred " + amount +
                            " to " + transFName + " " + transLName +
                            " | Balance: " + balance);

                } else {
                    System.out.println("Insufficient balance for transfer.");
                }
                return;
            }
        }

        System.out.println("Recipient not found: "
                + transFName + " " + transLName);
    }
}