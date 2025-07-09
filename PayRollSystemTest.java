package labTask4;

public class PayRollSystemTest {
    public static void main(String[] args) {
        Employee[] employees = new Employee[4];

        employees[0] = new SalariedEmployee("Sujana", "Farid", "1297479", 12000.00);
        employees[1] = new HourlyEmployee("Miftahul", "Jannat", "9237283", 150.0, 48);
        employees[2] = new CommissionEmployee("Sadia", "Promy", "2838300", 70000.0, 0.07);
        employees[3] = new BasePlusCommissionEmployee("Tania", "Sultana", "4673629", 60000.0, 0.06, 8000.0);

        for (Employee emp : employees) {
            System.out.println(emp);
            System.out.println("\n");

            if(emp instanceof BasePlusCommissionEmployee){
                System.out.println("Base Salary Increased By 10%");
                System.out.println("Increased Base Salary:" + ((BasePlusCommissionEmployee)emp).increaseBaseSalary()+ "\n");
            }
        }
    }
}

