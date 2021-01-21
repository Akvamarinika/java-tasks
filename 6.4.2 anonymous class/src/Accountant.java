public class Accountant implements Counter {
    @Override
    public String prepareReport(int month) {
        return "Отчет за " + month + " месяцев";
    }
}
