import java.util.ArrayList;
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
    String fName, lName, transFName, transLName,password;
    double balance;
    System.out.println("Enter number \n(1) Login or (2) Register: ");
    int input = scanner.nextInt();
    if (input == 1) {

        loggedIn = login(scanner, testLogin);

        if (!loggedIn) {
            System.out.println("You don't have an account yet.");
            System.out.println("Do you want to register? (1) Yes (2) No");
            int choice = scanner.nextInt();

            if (choice == 1) {
                loggedIn = register(scanner); // assume success after register
            } else {
                System.out.println("See you next time.");
                return;
            }
        }

    } else if (input == 2) {
        loggedIn = register(scanner);
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
    //-------------------------------------------------------------------------
    
    
    
    //This is for selecting the transaction
    int continue_Choice = 2;
    while (continue_Choice == 2) {
        
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
            System.out.println("Transfer successful.");

        } else if (choice == 4) {

            System.out.println("Your balance is: " + account.getBalance() + " Baht");

        } else {

            System.out.println("Invalid Input");
        }
        
        System.out.print("\n(1) Exit\n(2) Continue\nChoose: ");
        continue_Choice = scanner.nextInt();
        }
    System.out.print("Transaction success");

    }
    // Useful methods for login and register //
    public static boolean login(Scanner scanner, int testLogin) {
        System.out.println("Enter your firstname: ");
        String fName = scanner.next();
        System.out.println("Enter your lastname: ");
        String lName = scanner.next();
        System.out.println("Enter your password: ");
        String password = scanner.next();
        if (testLogin == 1) {
            System.out.println("Login successful.");
            return true;
        } else {
            return false;
        }
    }
    public static boolean register(Scanner scanner) {
        System.out.println("Enter your firstname: ");
        String fName = scanner.next();
        System.out.println("Enter your lastname: ");
        String lName = scanner.next();
        System.out.println("Enter your password: ");
        String password = scanner.next();
        System.out.println("Enter your initial balance: ");
        double balance = scanner.nextDouble();
        System.out.println("Registration successful.");
        System.out.println("Do you want to login now? (1) Yes (2) No");
        int choice = scanner.nextInt();
        if (choice == 1) {
            return login(scanner, 1);  // assume success
        } else {
            System.out.println("See you next time.");
            return false;
        }
    }
}

//TODO LIST
//1. Create customer account contain firstname, lastname, password and balance of each account
//2. make loop for customer in case if the account does not exist and when the transaction is out of bound
//3. complete the login/register part
