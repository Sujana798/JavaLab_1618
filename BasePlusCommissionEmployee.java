package labTask4;

public class BasePlusCommissionEmployee extends CommissionEmployee {
    private double baseSalary;

    public BasePlusCommissionEmployee(String first, String last, String ssn, double sales, double rate, double baseSalary) {
        super(first, last, ssn, sales, rate);
        this.baseSalary = baseSalary;
    }

    public double earnings() {
        return super.earnings() + baseSalary;
    }

    public double increaseBaseSalary(){
        return baseSalary+=baseSalary*0.1;
    }

    public String toString() {
        return String.format("Base Plus Commission Employee: %s\nTotal Earnings with Base: %.2ftk",super.toString(), earnings());
    }
}

