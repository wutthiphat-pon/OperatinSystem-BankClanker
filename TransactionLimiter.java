
public class TransactionLimiter {

    private int maxTransactions;   
    private int currentCount;     
    private double maxAmount;      

    // Constructor
    public TransactionLimiter(int maxTransactions, double maxAmount) {
        this.maxTransactions = maxTransactions;
        this.maxAmount = maxAmount;
        this.currentCount = 0;
    }

    // Boolean method
    public boolean isAllowed(double amount) {
        if (currentCount >= maxTransactions) {
            return false;
        }

        if (amount > maxAmount) {
            return false;
        }

        return true;
    }

    // Transaction method
    public void transaction(double amount) {
        if (isAllowed(amount)) 
        {
            currentCount++;
            System.out.println("Transaction success.");
        } 
        
        else 
        {
            System.out.println("Transaction fail.");
        }
    }
}
