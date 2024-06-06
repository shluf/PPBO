class Developer extends Employee {
    public Developer(String id, String name, String dob, String department, double salary) {
        super(id, name, dob, department, salary);
    }

    @Override
    public String getPosition() {
        return "Developer";
    }
}