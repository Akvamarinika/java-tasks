public class Main {
    public static void main(String[] args){
        Director director = new Director();
        Accountant accountant = new Accountant();
        director.force(accountant, 8);

        director.force(new Counter() {
            @Override
            public String prepareReport(int month) {
                return "Отчет за " + month + " месяцев";
            }
        }, 8);
    }
}
