abstract class Employee {
    protected String id;
    protected String name;
    protected String dob;
    protected String department;
    protected double salary;

    public Employee(String id, String name, String dob, String department, double salary) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.department = department;
        this.salary = salary;
    }

    public abstract String getPosition();

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", DOB: " + dob + ", Department: " + department + ", Position: " + getPosition() + ", Salary: " + salary;
    }
}

