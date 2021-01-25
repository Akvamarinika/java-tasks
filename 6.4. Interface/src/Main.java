import java.util.ArrayList;
import java.util.List;

/*
* TODO: 1.	Создайте и наймите в компанию: 180 операторов Operator, 80 менеджеров по продажам Manager, 10 топ-менеджеров TopManager.
        2.	Распечатайте список из 10–15 самых высоких зарплат в компании.
        3.	Распечатайте список из 30 самых низких зарплат в компании.
        4.	Увольте 50% сотрудников.

* */
public class Main {
    public static void main(String[] args) {
        Company company = new Company(generatorIncome());
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < 180; i++){
            employees.add(new Operator(company, generatorHoursWork() * generatorCostWork()));
        }
        for (int i = 0; i < 80; i++){
            employees.add(new Manager(company, generatorHoursWork() * generatorCostWork()));
        }
        for (int i = 0; i < 10; i++){
            employees.add(new TopManager(company, generatorHoursWork() * generatorCostWork()));
        }

        company.hireAll(employees);
        System.out.println("Employees in company: " + employees.size());
        System.out.println("Top salary: ");
        print(company.getTopSalaryStaff(10));
        System.out.println("\nLowest salary: ");
        print(company.getLowestSalaryStaff(30));

        for (int i = 0; i < company.getEmployeesList().size()/2; i++){
            company.fire(company.getEmployeesList().get(i));
        }
        System.out.println("Employees in company before dismissal: " + company.getEmployeesList().size());

    }
    public static double generatorIncome(){
        return Math.random() * (190000-115000) + 115000;
    }

    public static double generatorHoursWork(){
        return Math.random() * (170-130) + 130;
    }

    public static double generatorCostWork(){
        return Math.random() * (800-100) + 100;
    }

    public  static  void print(List<Employee> emp){
        for (Employee e : emp){
            System.out.println(Math.round(e.getMonthSalary()) + " руб.");
        }
    }
}
