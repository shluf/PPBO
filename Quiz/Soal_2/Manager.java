class Manager extends Employee {
    public Manager(String id, String name, String dob, String department, double salary) {
        super(id, name, dob, department, salary);
    }

    @Override
    public String getPosition() {
        return "Manager";
    }
}