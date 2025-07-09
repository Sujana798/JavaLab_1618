package labTask4;

public abstract class Employee {
    private String firstName;
    private String lastName;
    private String socialSecurityNumber;

    public Employee(String firstName, String lastName, String ssn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = ssn;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getSSN() { return socialSecurityNumber; }

    public abstract double earnings();

    public String toString() {
        return String.format("%s %s\nSSN: %s", firstName, lastName, socialSecurityNumber);
    }
}

