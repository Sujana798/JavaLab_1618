package labTask4;

public class HourlyEmployee extends Employee {
    private double wage;
    private double hours;

    public HourlyEmployee(String first, String last, String ssn, double wage, double hours) {
        super(first, last, ssn);
        this.wage = wage;
        this.hours = hours;
    }

    public double earnings() {
        if (hours <= 40)
            return wage * hours;
        else
            return 40 * wage + (hours - 40) * wage * 1.5;
    }

    public String toString() {
        return String.format("Hourly Employee: %s\nEarnings: %.2ftk", super.toString(), earnings());
    }
}

