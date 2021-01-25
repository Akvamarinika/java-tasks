public class Operator implements Employee {
    private Company company;
    private double salaryFixPart;

    public Operator(Company company, double salaryFixPart){
        this.company = company;
        this.salaryFixPart = salaryFixPart;
    }

    @Override
    public double getMonthSalary() {
        return salaryFixPart;
    }

    @Override
    public double getSalaryFixPart() {
        return salaryFixPart;
    }
}
