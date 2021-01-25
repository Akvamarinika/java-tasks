public class TopManager implements Employee{
   private Company company;
   private double salaryFixPart;
   private final double BONUS_PERCENT = 1.5;
    private final double NEED_INCOME = 10000000;

    TopManager(Company company, double salaryFixPart){
       this.company = company;
       this.salaryFixPart = salaryFixPart;
   }

    @Override
    public double getMonthSalary() {
        if (company.getIncome() > NEED_INCOME){
            return (salaryFixPart * BONUS_PERCENT) * salaryFixPart;
        }
        return salaryFixPart;
    }

    @Override
    public double getSalaryFixPart() {
        return salaryFixPart;
    }
}
