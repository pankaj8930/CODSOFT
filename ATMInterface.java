import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class ATM {
    private String accountNumber;
    private double balance;
    private List<String> transactionHistory;
    public ATM(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
    }
    public void accountBalanceInquiry() {
        System.out.println("Account Balance: $" + balance);
    }
    public void cashWithdrawal(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds!");
        } else {
            balance -= amount;
            transactionHistory.add("Withdrawal: -$" + amount);
            System.out.println("Withdrawal successful. New balance: $" + balance);
        }
    }
    public void cashDeposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposit: +$" + amount);
        System.out.println("Deposit successful. New balance: $" + balance);
    }
    public void transactionHistory() {
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
    public static void main(String[] args) {
        ATM atm = new ATM("1234567890", 5000.0);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("ATM Menu:");
            System.out.println("1. Account Balance Inquiry");
            System.out.println("2. Cash Withdrawal");
            System.out.println("3. Cash Deposit");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    atm.accountBalanceInquiry();
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawalAmount = scanner.nextDouble();
                    atm.cashWithdrawal(withdrawalAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    atm.cashDeposit(depositAmount);
                    break;
                case 4:
                    atm.transactionHistory();
                    break;
                case 5:
                    System.out.println("thank you for using this atm");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

