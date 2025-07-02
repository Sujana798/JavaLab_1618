package labTask3;

class DepositAccount extends Account {
    private int installmentsPaid;
    private static final int TOTAL_INSTALLMENTS = 5;

    public DepositAccount(double balance) {
        super(balance);
        this.installmentsPaid = 0;
    }

    public void payInstallment(double amount) {
        deposit(amount);
        installmentsPaid++;
        System.out.println("Installment paid. (" + installmentsPaid + "/" + TOTAL_INSTALLMENTS + ")");
    }

    public void withdraw(double amount) {
        if (installmentsPaid >= TOTAL_INSTALLMENTS) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println("Withdrawn: " + amount);
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Cannot withdraw before 5 installments.");
        }
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean canTransferTo(Account toAccount) {
        return false;
    }

    public void applyInterest() {
        if (installmentsPaid >= TOTAL_INSTALLMENTS) {
            balance += balance * 0.07;
        }
    }
}
