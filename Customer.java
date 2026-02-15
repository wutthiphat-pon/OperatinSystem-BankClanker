
public class Customer {
	
	private String first_Name;
    private String last_Name;
    private String password;
    private BankAccount account;

	
    public Customer(String firstName, String lastName, String password, double initialBalance) {
        this.first_Name = firstName;
        this.last_Name = lastName;
        this.password = password;
        this.account = new BankAccount(initialBalance);
    }
    
    public boolean login(String firstName, String lastName, String password) {
    	
    	
    	
    	
    }
	
    
    public BankAccount getAccount() {
        return account;
    }
}
