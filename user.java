import java.util.HashMap;
import java.util.Map;

class User {
    private String userId;
    private String userPin;
    private double balance;
    private Map<String, Double> transactionHistory;

    public User(String userId, String userPin, double initialBalance) {
        this.userId = userId;
        this.userPin = userPin;
        this.balance = initialBalance;
        this.transactionHistory = new HashMap<>();
    }

    public String getUserId() {
        return userId;
    }

    public String getUserPin() {
        return userPin;
    }

    public double getBalance() {
        return balance;
    }

    public Map<String, Double> getTransactionHistory() {
        return transactionHistory;
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.put("Deposit", amount);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactionHistory.put("Withdraw", amount);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void transfer(User recipient, double amount) {
        if (balance >= amount) {
            balance -= amount;
            recipient.deposit(amount);
            transactionHistory.put("Transfer to " + recipient.getUserId(), amount);
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}
