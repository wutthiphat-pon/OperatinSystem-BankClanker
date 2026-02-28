import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TestBank {
    
    public static void main(String[] args) {
        // Begining of 3 Main Tasks --------------------------- //
        
        // ===============================
        // HEAP ALLOCATOR DEMONSTRATION
        // ===============================
        // 1) Multiple accounts
        BankAccount acc1 = new BankAccount(1000.00);
        BankAccount acc2 = new BankAccount(500.00);
        BankAccount acc3 = new BankAccount(2000.00);

        System.out.println("Objects created.");

        // 3) Reference reassignment
        acc1 = acc2;
        System.out.println("acc1 reassigned to acc2.");

        // 4) Garbage collection eligibility
        acc1 = null;
        acc2 = null;
        System.out.println("acc1 and acc2 set to null.");

        System.out.println("\n=== Concurrency Demonstration ===");
        // Shared object in HEAP
        BankAccount sharedAccount = new BankAccount(1000);

        // Create threads that access same object
        Thread t1 = new Thread(() -> sharedAccount.withdraw(300), "Thread-1");
        Thread t2 = new Thread(() -> sharedAccount.withdraw(300), "Thread-2");
        Thread t3 = new Thread(() -> sharedAccount.deposit(200), "Thread-3");

        // Start threads (concurrent execution)
        t1.start();
        t2.start();
        t3.start();

        // Wait for completion (thread scheduling control)
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Balance: " + sharedAccount.getBalance());

        System.out.println("\n===== PARAMETER PASSING DEMON =====");

        // Primitive example
        double prAmount = 1000;
        double copyAmount = prAmount;

        copyAmount = copyAmount + 500;

        System.out.println("Original primitive amount: " + prAmount);
        System.out.println("Modified copy: " + copyAmount);


        // Reference example
        BankAccount ref1 = new BankAccount(3000);
        BankAccount ref2 = ref1;

        ref2.deposit(1000);

        System.out.println("ref1 balance after ref2 deposit: " + ref1.getBalance());
        System.out.println("ref2 balance: " + ref2.getBalance());


        System.out.println("\n===== STRING IMMUTABILITY =====");

        String customer1 = "Alice Smith";
        String customer2 = customer1;

        customer1 = customer1 + " (VIP)";

        System.out.println("customer1: " + customer1);
        System.out.println("customer2: " + customer2);
        // End of 3 Main Tasks --------------------------- //

        // ------------------------------------------------------------------------ //
        BankAccount account = new BankAccount(1000.00);
        Scanner scanner = new Scanner(System.in);
        Customer customer = null;
        boolean loggedIn = false;

        int testLogin = 0; // 1 = has account
        String fName, lName, transFName, transLName, password;
        double balance;
        System.out.println("Enter number \n(1) Login or (2) Register: ");
        int input = scanner.nextInt();
        if (input == 1) {

            loggedIn = BankSystem.login(scanner, testLogin);

            if (!loggedIn) {
                System.out.println("You don't have an account yet.");
                System.out.println("Do you want to register? (1) Yes (2) No");
                int choice = scanner.nextInt();

                if (choice == 1) {
                    loggedIn = BankSystem.register(scanner); // assume success after register
                } else {
                    System.out.println("See you next time.");
                    return;
                }
            }

        } else if (input == 2) {
            loggedIn = BankSystem.register(scanner);
            if (!loggedIn) {
                return;
            }
        } else {
            System.out.println("Invalid input. Please enter number 1 or 2.");
            return;
        }
        // Prevent continuing to transactions if not log in
        if (!loggedIn) {
            return;
        }
        // ------------------------------------------------------------------------
        // This is for selecting the transaction
        int continue_Choice = 2;
        while (continue_Choice == 2) {

            try {
                System.out.print("Click the number:\n (1)Withdraw\n (2)Deposit\n (3)transfer\n (4)Check Balance\n : ");
                int choice = scanner.nextInt();

                if (choice == 1) {

                    System.out.print("How much money to withdraw: ");
                    double amount = scanner.nextDouble();
                    account.withdraw(amount);

                } else if (choice == 2) {

                    System.out.print("How much money to deposit: ");
                    double amount = scanner.nextDouble();
                    account.deposit(amount);

                } else if (choice == 3) {
                    System.out.println("Enter the details of the account you would like to transfer to: ");
                    System.out.println("Firstname: ");
                    transFName = scanner.next();
                    System.out.println("Lastname: ");
                    transLName = scanner.next();
                    System.out.println("Amount: ");
                    double amount = scanner.nextDouble();
                    account.transfer(transFName, transLName, amount);
                } else if (choice == 4) {

                    System.out.println("Your balance is: " + account.getBalance() + " Baht");

                } else {

                    System.out.println("Invalid Input");
                }

                System.out.print("\n(1) Exit\n(2) Continue\nChoose: ");
                continue_Choice = scanner.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // clear bad input
            }
        }
        System.out.print("Transaction success");

    }
    
}
