public abstract class Employee{
    private String name;
    private double salary;

    public Employee(String name, double salary){
        this.name=name;
        this.salary=salary;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public double getSalary(){
        return salary;
    }

    public void displayInfo(){
        System.out.println("The employees name is: " +name+ ".\nThe employees salary is: " +salary);
    }

    public abstract void calculateBonus();
    

}

class Manager extends Employee{

    private String department;
    private int managerBonus;

    public Manager(String name, double salary, String department) {
        super(name, salary);
        this.department=department;
    }

    @Override
    public void calculateBonus(){
        double managerBonus = getSalary() / 10;
        System.out.println("The managers bonus is: " +managerBonus);
        
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("In department: " + department);
    }

}

class Developer extends Employee{
    private String programmingLanguage;
    private int developerBonus;

    public Developer(String name, double salary, String programmingLanguage) {
        super(name, salary);
        this.programmingLanguage=programmingLanguage;
    }

    @Override
    public void calculateBonus(){
        double developerBonus = getSalary() / 5;
        System.out.println("The developers bonus is: " +developerBonus);
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Their programming lanuage is: " +programmingLanguage);
    }
}

class Main {
    public static void main(String[] args) {
        Manager manager1 = new Manager ("Jeff", 78000, "HR");
        Developer developer1 = new Developer ("Jess",67999,"Java");
    
        manager1.displayInfo();
        manager1.calculateBonus();

        developer1.displayInfo();
        developer1.calculateBonus();
    }
}