import java.util.List;
import java.util.ArrayList;

public class Company {
    private List<Employee> employeesList = new ArrayList<>();
    private double income;

    public Company(double income){
        this.income = income;
    }

    public Company(double income, List<Employee> listEmployees){
        this.income = income;
        if (!listEmployees.isEmpty()){
            employeesList.addAll(listEmployees);
        }
    }

   public double getIncome(){
        return income;
    }

   public void setIncome(double income){
        this.income = income;
    }

    public List<Employee> getEmployeesList(){
        return employeesList;
    }

    public void setEmployeesList(List<Employee> employeesList){
        this.employeesList = employeesList;
    }

    void hire(Employee employeeNew){
        if (employeeNew != null){
            employeesList.add(employeeNew);
            System.out.println("New employee added");
        }

    }
    void hireAll(List<Employee> employeesNew){
        if (!employeesNew.isEmpty()){
            employeesList.addAll(employeesNew);
            System.out.println("List employees added");
        }

    }
    void fire(Employee employeeDel){
        if (employeeDel != null && employeesList.contains(employeeDel)){
            employeesList.remove(employeeDel);
            System.out.println("Remove employee completed");
        }
    }

  /*  List<Employee> getTopSalaryStaff(int count){
        //ArrayList<Employee> employees = ArrayList<>();
        //employeesList.sort();
        List<Employee> employeesTopSalary = new ArrayList<>();
        return ;
    }

    List<Employee> getLowestSalaryStaff(int count){}

    @Override
    public int compareTo(Employee obj2) {
        if ()
        return 0;
    }*/
}
