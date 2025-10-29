import java.util.ArrayList;
import java.util.List;

public abstract class Employee {
    protected String employeeId;
    protected String name;
    protected String department;
    protected double baseSalary;

    public Employee(String employeeId, String name, String department, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.baseSalary = baseSalary;
    }

    // Abstract methods to be implemented by subclasses
    public abstract double calculatePay();
    public abstract String getEmployeeType();

    // Common methods shared across all employees
    public void transferDepartment(String newDepartment) {
        System.out.println(name + " is transferring from " + department + " to " + newDepartment);
        this.department = newDepartment;
    }

    public void annualReview() {
        System.out.println("Conducting annual performance review for " + name + " (" + getEmployeeType() + ")");
    }

    public void promote(double raiseAmount) {
        baseSalary += raiseAmount;
        System.out.println(name + " has been promoted! New base salary: £" + baseSalary);
    }

    @Override
    public String toString() {
        return String.format("[%s] %s (%s Department) - Base Salary: £%.2f", employeeId, name, department, baseSalary);
    }
}

class FullTimeEmployee extends Employee{
     private double benefits; // annual benefits value

    public FullTimeEmployee(String employeeId, String name, String department, double baseSalary, double benefits) {
        super(employeeId, name, department, baseSalary);
        this.benefits = benefits;
    }

    @Override
    public double calculatePay() {
        // Full-time employees have fixed monthly salary + prorated benefits
        return baseSalary + (benefits / 12);
    }

    @Override
    public String getEmployeeType() {
        return "Full-Time Employee";
    }

    public double getBenefits() {
        return benefits;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Type: %s | Benefits: £%.2f", getEmployeeType(), benefits);
    }
}

class PartTimeEmployee extends Employee{
    private double hourlyRate;
    private int hoursWorked;

    public PartTimeEmployee(String employeeId, String name, String department, double hourlyRate, int hoursWorked) {
        super(employeeId, name, department, 0); // baseSalary not used for part-timers
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculatePay() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public String getEmployeeType() {
        return "Part-Time Employee";
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Type: %s | Hourly Rate: £%.2f | Hours Worked: %d", 
                getEmployeeType(), hourlyRate, hoursWorked);
    }
}

class ContractEmployee extends Employee{
    private String projectName;
    private double projectPayment;

    public ContractEmployee(String employeeId, String name, String department, String projectName, double projectPayment) {
        super(employeeId, name, department, 0);
        this.projectName = projectName;
        this.projectPayment = projectPayment;
    }

    @Override
    public double calculatePay() {
        // Project-based payment
        return projectPayment;
    }

    @Override
    public String getEmployeeType() {
        return "Contract Employee";
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Type: %s | Project: %s | Payment: £%.2f",
                getEmployeeType(), projectName, projectPayment);
    }
}

class Manager extends FullTimeEmployee{
    private List<Employee> teamMembers;

    public Manager(String employeeId, String name, String department, double baseSalary, double benefits) {
        super(employeeId, name, department, baseSalary, benefits);
        this.teamMembers = new ArrayList<>();
    }

    public void addTeamMember(Employee e) {
        teamMembers.add(e);
        System.out.println(e.name + " has been added to " + name + "’s team.");
    }

    public void conductMeeting() {
        System.out.println(name + " is conducting a team meeting for " + department + ".");
    }

    public void listTeamMembers() {
        System.out.println(name + " manages the following team members:");
        for (Employee e : teamMembers) {
            System.out.println(" - " + e.name + " (" + e.getEmployeeType() + ")");
        }
    }

    @Override
    public String getEmployeeType() {
        return "Manager";
    }

    @Override
    public double calculatePay() {
        // Managers get a 15% leadership bonus on top of full-time pay
        return super.calculatePay() * 1.15;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Type: %s | Team Size: %d", getEmployeeType(), teamMembers.size());
    }
}

class EmployeeTest{
    public static void main(String[] args) {
        FullTimeEmployee fte = new FullTimeEmployee("E001", "Alice Johnson", "Engineering", 48000, 6000);
        PartTimeEmployee pte = new PartTimeEmployee("E002", "Bob Smith", "Marketing", 25, 80);
        ContractEmployee ce = new ContractEmployee("E003", "Clara White", "Design", "Website Redesign", 5000);
        Manager mgr = new Manager("M001", "David Green", "Engineering", 60000, 10000);

        // Demonstrate polymorphism
        Employee[] employees = {fte, pte, ce, mgr};
        for (Employee e : employees) {
            System.out.println(e.toString());
            System.out.println("Calculated Pay: £" + e.calculatePay());
            System.out.println();
        }

        // Manager-specific behavior
        mgr.addTeamMember(fte);
        mgr.addTeamMember(pte);
        mgr.conductMeeting();
        mgr.listTeamMembers();

        // Demonstrate business logic
        fte.annualReview();
        fte.promote(3000);
        pte.transferDepartment("Customer Support");
        ce.annualReview();
        mgr.promote(5000);
    }
}