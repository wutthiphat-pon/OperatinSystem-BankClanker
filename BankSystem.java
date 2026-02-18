import java.util.ArrayList;
import java.util.Scanner;

public class BankSystem {

	private ArrayList<Customer> customers;

	public BankSystem() {
		customers = new ArrayList<>();
	}

	public void register(String firstName, String lastName, String password, double balance) {
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
			return login(scanner, 1); // assume success
		} else {
			System.out.println("See you next time.");
			return false;
		}
	}

}
