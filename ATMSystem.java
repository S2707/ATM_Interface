import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited $" + amount + ". New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println("Successfully withdrew $" + amount + ". New balance: $" + balance);
            } else {
                System.out.println("Insufficient funds for this withdrawal.");
            }
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    public void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
    }
}

class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void displayMenu() {
        System.out.println("\n--- ATM Menu ---");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void processOption(int option) {
        Scanner scanner = new Scanner(System.in);

        switch (option) {
            case 1:
                System.out.print("Enter the amount to withdraw: $");
                double withdrawAmount = scanner.nextDouble();
                bankAccount.withdraw(withdrawAmount);
                break;
            case 2:
                System.out.print("Enter the amount to deposit: $");
                double depositAmount = scanner.nextDouble();
                bankAccount.deposit(depositAmount);
                break;
            case 3:
                bankAccount.checkBalance();
                break;
            case 4:
                System.out.println("Thank you for using the ATM. Goodbye!");
                break;
            default:
                System.out.println("Invalid option. Please choose a valid number.");
        }
    }
}

public class ATMSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a BankAccount object with an initial balance (e.g., $1000)
        BankAccount userAccount = new BankAccount(1000);

        // Create an ATM object
        ATM atm = new ATM(userAccount);

        boolean running = true;
        while (running) {
            atm.displayMenu();
            System.out.print("Please choose an option (1-4): ");
            int option = scanner.nextInt();

            if (option == 4) {
                atm.processOption(option);
                running = false;
            } else {
                atm.processOption(option);
            }
        }
        scanner.close();
    }
}

