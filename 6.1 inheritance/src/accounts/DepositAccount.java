package accounts;
import java.time.LocalDate;
import java.time.Period;

public class DepositAccount extends BankAccount {
    private LocalDate dateStart;

    @Override
    public void depositAmount(double money){
        super.depositAmount(money);
        dateStart = LocalDate.now();

    }
    @Override
    public void withdrawMoney(double money){
      /*  Date date2 = new Date();
        long milliseconds = date2.getTime() - date.getTime();
        int days = (int) (milliseconds / (24 * 60 * 60 * 1000));*/
        System.out.println(Period.between(dateStart, LocalDate.now()).getMonths());
        if (Period.between(dateStart, LocalDate.now()).getMonths() >= 1){
            double balance = super.getBalance();
            balance -= money;
            super.setBalance(balance);
        }else {
            System.out.println("Месяц после последнего внесения денег не прошел");
        }

    }

    public void dateOfLastDeposit(){
        if (dateStart == null){
            System.out.println("Вы не положили денег на счет");
        }else {
            System.out.println("Вы положили деньги на счет: " + dateStart);
            System.out.println("Прошло дней: " + Period.between(dateStart, LocalDate.now()).getDays());
        }

    }

    @Override
    public  String toString(){
       return  "Депозитный расчётный счёт:\t"  + super.toString();
    }


}
