import java.util.ArrayList;

public class Customer {

    private String first_Name;
    private String last_Name;
    private String password;
    private BankAccount account;

    private static ArrayList<Customer> customers = new ArrayList<>();

    public Customer(String firstName, String lastName, String password, double initialBalance) {
        this.first_Name = firstName;
        this.last_Name = lastName;
        this.password = password;
        this.account = new BankAccount(initialBalance);
        customers.add(this);
    }

    public String getFirstName() {
        return first_Name;
    }

    public String getLastName() {
        return last_Name;
    }

    public boolean login(String firstName, String lastName, String password) {
        return this.first_Name.equalsIgnoreCase(firstName)
                && this.last_Name.equalsIgnoreCase(lastName)
                && this.password.equals(password);
    }

    public BankAccount getAccount() {
        return account;
    }

    public static ArrayList<Customer> getCustomers() {
        return customers;
    }
}
