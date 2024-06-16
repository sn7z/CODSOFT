import java.util.Scanner;

public class ATM {
    private double balance;

    // constructor for value of balance
    public ATM(double initialBalance) {
        this.balance = initialBalance;
    }

    public static void main(String[] args) {
        ATM atm = new ATM(1000); // Initial balance of 1000
        atm.showMenu();
    }

    // method to show menu
    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        int option=0;

        do{
            System.out.println("\nATM Menu:\n1. Check Balance\n2. Deposit Money\n3. Withdraw Money\n4. Exit\n");
            System.out.print("Please select an option: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }while (option != 4);
        sc.close();
    }

    //method to check the available balance
    private void checkBalance() {
        System.out.println("Your current balance is: Rs." + balance);
    }

    //methods to deposit and withdraw
    private void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited Rs." + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }
    private void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew Rs." + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }
}
