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

        if(balance >=amount) {
            balance -= amount;
            System.out.println("Withdraw successful.");
            
        }else System.out.println("You broke bruh.");
            
    }
    
    public void transfer(double amount) {
	   
   } 
    
}


   
