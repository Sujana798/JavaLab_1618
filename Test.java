package labTask3;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        CurrentAccount current = new CurrentAccount(10000);
        SavingsAccount savings = new SavingsAccount(3000);
        DepositAccount deposit = new DepositAccount(5000);

        while (true) {
            System.out.println(" Menu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Transfer");
            System.out.println("4. Pay Installment (Deposit Account)");
            System.out.println("5. Apply Interest");
            System.out.println("6. Show Balances");
            System.out.println("0. Exit");
            System.out.print(" Choose option: ");
            int choice = sc.nextInt();

            if (choice == 0) {
                System.out.println("Exiting...");
                break;
            }

            System.out.println("Select Account:");
            System.out.println("1. Current");
            System.out.println("2. Savings");
            System.out.println("3. Deposit");
            int accType = sc.nextInt();

            Account selected = null;
            if (accType == 1) selected = current;
            else if (accType == 2) selected = savings;
            else if (accType == 3) selected = deposit;
            else {
                System.out.println("Invalid account!");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double d = sc.nextDouble();
                    selected.deposit(d);
                    break;

                case 2:
                    System.out.print("Enter withdraw amount: ");
                    double w = sc.nextDouble();
                    selected.withdraw(w);
                    break;

                case 3:
                    if (selected instanceof DepositAccount) {
                        System.out.println("Cannot transfer from Deposit Account");
                        break;
                    }

                    System.out.println("Transfer TO (1=Current, 2=Savings): ");
                    int toAcc = sc.nextInt();
                    Account toAccount = (toAcc == 1) ? current : savings;

                    System.out.print("Enter transfer amount: ");
                    double t = sc.nextDouble();
                    selected.transferTo(toAccount, t);
                    break;

                case 4:
                    if (selected instanceof DepositAccount) {
                        System.out.print("Enter installment amount: ");
                        double inst = sc.nextDouble();
                        ((DepositAccount) selected).payInstallment(inst);
                    } else {
                        System.out.println("Only for Deposit Account");
                    }
                    break;

                case 5:
                    selected.applyInterest();
                    break;

                case 6:
                    System.out.println("Balances:");
                    if(selected instanceof CurrentAccount){
                    System.out.println("Current: " + current.getBalance());}
                    if(selected instanceof SavingsAccount){
                    System.out.println("Savings: " + savings.getBalance());}
                    if(selected instanceof DepositAccount){
                    System.out.println("Deposit: " + deposit.getBalance());}
                    break;

                default:
                    System.out.println("Invalid option!");
            }
        }

        sc.close();
    }
}
