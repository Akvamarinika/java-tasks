public class Manager implements Employee{
    private Company company;
    private double salaryFixPart;
    private final double BONUS_PERCENT = 0.05;

    public Manager(Company company, double salaryFixPart){
        this.company = company;
        this.salaryFixPart = salaryFixPart;
    }

    @Override
    public double getMonthSalary() {
        return salaryFixPart + (company.getIncome() * BONUS_PERCENT);
    }

    @Override
    public double getSalaryFixPart() {
        return salaryFixPart;
    }
}
