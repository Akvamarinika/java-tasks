import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DepositAccount extends BankAccount{
    private Date date;
    private DateFormat df;
    public void depositAmount(double money){
        super.depositAmount(money);
        date = new Date();

    }

    public void withdrawMoney(double money){
        Date date2 = new Date();
        long milliseconds = date2.getTime() - date.getTime();
        int days = (int) (milliseconds / (24 * 60 * 60 * 1000));
        if (30 > days){
            double balance = super.getBalance();
            balance -= money;
            super.setBalance(balance);
        }else {
            System.out.println("Месяц после последнего внесения денег не прошел");
        }

    }

    public void dateOfLastDeposit(){
        if (date == null){
            System.out.println("Вы не положили денег на счет");
        }else {
            df = new SimpleDateFormat("dd.MM.yyyy");
            System.out.println(df.format(date));
        }

    }


}
