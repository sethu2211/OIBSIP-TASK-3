import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ATMSystem {
    private static Map<String, User> users = new HashMap<>();

    public static void main(String[] args) {
        initializeUsers(); // Initialize sample user data

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter User PIN: ");
        String userPin = scanner.nextLine();

        User currentUser = authenticateUser(userId, userPin);

        if (currentUser != null) {
            displayMenu(currentUser);
        } else {
            System.out.println("Authentication failed. Invalid User ID or PIN.");
        }
    }

    private static void initializeUsers() {
        // Initialize sample user data (replace with your data)
        users.put("user1", new User("user1", "1234", 1000.0));
        users.put("user2", new User("user2", "5678", 2000.0));
    }

    private static User authenticateUser(String userId, String userPin) {
        if (users.containsKey(userId)) {
            User user = users.get(userId);
            if (user.getUserPin().equals(userPin)) {
                return user;
            }
        }
        return null;
    }

    private static void displayMenu(User user) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Transaction History");
            System.out.println("6. Quit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.println("Balance: $" + user.getBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    user.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawalAmount = scanner.nextDouble();
                    user.withdraw(withdrawalAmount);
                    break;
                case 4:
                    System.out.print("Enter recipient's User ID: ");
                    String recipientUserId = scanner.nextLine();
                    System.out.print("Enter transfer amount: $");
                    double transferAmount = scanner.nextDouble();
                    User recipient = users.get(recipientUserId);
                    if (recipient != null) {
                        user.transfer(recipient, transferAmount);
                    } else {
                        System.out.println("Recipient not found.");
                    }
                    break;
                case 5:
                    displayTransactionHistory(user);
                    break;
                case 6:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void displayTransactionHistory(User user) {
        System.out.println("\nTransaction History:");
        Map<String, Double> history = user.getTransactionHistory();
        for (Map.Entry<String, Double> entry : history.entrySet()) {
            System.out.println(entry.getKey() + ": $" + entry.getValue());
        }
    }
}
