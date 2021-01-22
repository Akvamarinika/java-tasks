package accounts;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class DepositAccount extends BankAccount {
    private LocalDate dateStart;

    @Override
    public void depositAmount(double money){
        super.depositAmount(money);
        dateStart = LocalDate.of(2020, 12, 10); // LocalDate.now();

    }
    @Override
    public boolean withdrawMoney(double money){
      /*  Date date2 = new Date();
        long milliseconds = date2.getTime() - date.getTime();
        int days = (int) (milliseconds / (24 * 60 * 60 * 1000));*/
        if (Period.between(dateStart, LocalDate.now()).getMonths() >= 1 ){
            if (money < getBalance()) {
                double balance = super.getBalance();
                balance -= money;
                super.setBalance(balance);
                return true;
            } else {
                return  false;
            }
        }else {
            System.out.println("Месяц после последнего внесения денег не прошел");
            return false;
        }

    }

    public void dateOfLastDeposit(){
        if (dateStart == null){
            System.out.println("Вы не положили денег на счет");
        }else {
            System.out.println("Вы положили деньги на счет: " + dateStart);
            System.out.println("Прошло дней: " + ChronoUnit.DAYS.between(dateStart, LocalDate.now()));
        }

    }

    @Override
    public  String toString(){
       return  "Депозитный расчётный счёт:\t"  + super.toString();
    }

    @Override
    public boolean send(BankAccount receiver, double money) {
        System.out.println("Перевод денег с депозитного счета на карточный: ");
        if (withdrawMoney(money)){
            receiver.depositAmount(money);
            return true;
        }else {
            return  false;
        }

    }
}
