class BankAccount {
    private int balance;

    
    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    
    public void deposit(int amount) {
        balance += amount;
        System.out.println("Amount deposited Balance = " + balance);
    }
    
    public void withdraw(int amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("Amount withdrawn Balance = " + balance);
        }
    }

    
    public void displayBalance() {
        System.out.println("Balance = " + balance);
    }
}

public class BankApp {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000); // initial balance

        // Hardcoded sequence of operations (sample input: 1 500 3 4)
        int[] operations = {1, 500, 3, 4}; 

        int i = 0;
        while (i < operations.length) {
            int choice = operations[i];
            switch (choice) {
                case 1: // Deposit
                    int depositAmount = operations[++i];
                    account.deposit(depositAmount);
                    break;
                case 2: // Withdraw
                    int withdrawAmount = operations[++i];
                    account.withdraw(withdrawAmount);
                    break;
                case 3: // Display balance
                    account.displayBalance();
                    break;
                case 4: // Exit
                    System.out.println("Exit");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
            i++;
        }
    }
}
