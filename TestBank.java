import java.util.ArrayList;
import java.util.Scanner;

public class TestBank {

    public static void main(String[] args) {
    	
   
    BankAccount account = new BankAccount(1000.00);  // this is test account
    
    //--------------------------------------------------------------------------
    
    //For the Login and register part
    
    
    
    //-------------------------------------------------------------------------
   
    
    
    
    //This is for selecting the transaction
    int continue_Choice = 2;
    while (continue_Choice == 2) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Click the number:\n (1)Withdraw\n (2)Deposit\n (3) transfer (4)Check Balance\n: ");
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

            System.out.println("Your balance is: " + account.getBalance() + " Baht");

        } else {

            System.out.println("Invalid Input");
        }
        
        System.out.print("\n(1) Exit\n(2) Continue\nChoose: ");
        continue_Choice = scanner.nextInt();
        }
    System.out.print("Transaction success");

    }
}


//TODO LIST
//1. Create customer account contain firstname, lastname, password and balance of each account
//2. make loop for customer in case if the account does not exist and when the transaction is out of bound
//3. complete the login/register part








