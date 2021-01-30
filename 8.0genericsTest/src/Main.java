//import java.util.Collections;

public class Main {
    public static void main(String[] args){
        Team<Pupil>  pupils= new Team<>("Boys");
        pupils.addNewGamer(new Pupil("Ivan", 12));
        pupils.addNewGamer(new Pupil("Alex", 15));
        pupils.addNewGamer(new Pupil("Mike", 13));
        pupils.addNewGamer(new Pupil("Alex", 12));
        pupils.addNewGamer(new Pupil("Sergei", 14));

        Team<Pupil> pupils2 = new Team<>("Girls");
        pupils2.addNewGamer(new Pupil("Ann", 13));
        pupils2.addNewGamer(new Pupil("Kate",15));
        pupils2.addNewGamer(new Pupil("Inna",14));
        pupils2.addNewGamer(new Pupil("Kate",12));
        pupils2.addNewGamer(new Pupil("Aleks",14));

        Team<Student> students = new Team<>("University");
        students.addNewGamer(new Student("Aleksandr", 20));
        students.addNewGamer(new Student("Britney", 18));
        students.addNewGamer(new Student("Denis",19));
        students.addNewGamer(new Student("Slava", 20));
        students.addNewGamer(new Student("Aleksandr",19));

        Team<Student> students2 = new Team<>("Cybernetics");
        students2.addNewGamer(new Student("Igor", 21));
        students2.addNewGamer(new Student("Cortney", 19));
        students2.addNewGamer(new Student("Vasiliy",20));
        students2.addNewGamer(new Student("Mike", 18));
        students2.addNewGamer(new Student("Alex",21));

        Team<Employee> employee = new Team<>("Workers");
        employee.addNewGamer(new Employee("Victor", 32));
        employee.addNewGamer(new Employee("Max", 30));
        employee.addNewGamer(new Employee("Bogdan", 28));
        employee.addNewGamer(new Employee("Maria", 25));
        employee.addNewGamer(new Employee("Irina", 27));

        Team<Employee> employee2 = new Team<>("Engineers");
        employee2.addNewGamer(new Employee("Nik", 29));
        employee2.addNewGamer(new Employee("Anton", 31));
        employee2.addNewGamer(new Employee("Marta", 26));
        employee2.addNewGamer(new Employee("Alena", 29));
        employee2.addNewGamer(new Employee("Artem", 33));

        System.out.println(pupils.getName() + ": " + pupils.getTeam());
        System.out.println(pupils2.getName() + ": " + pupils2.getTeam());
        System.out.println(pupils.play(pupils2));

        System.out.println(students.getName() + ": " + students.getTeam());
        System.out.println(students2.getName() + ": " + students2.getTeam());
        System.out.println(students.play(students2));

        System.out.println(employee.getName() + ": " + employee.getTeam());
        System.out.println(employee2.getName() + ": " + employee2.getTeam());
        System.out.println(employee.play(employee2));
        //Collections.sort(employee2, new gamersComparator());
        System.out.println(employee2.getName() + ": " + employee2.getTeam());
    }
}
