import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TestBank {

    public static void main(String[] args) {

        // VERSION 2.0 //
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
        // Prevent continueing to transactions if not log in
        if (!loggedIn) {
            return;
        }
        // -------------------------------------------------------------------------

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
