package accounts;

import accounts.BankAccount;

public class CardAccount extends BankAccount {
    private double percent;

    public CardAccount(){
        super();
        percent = 0.01;
    }

   public CardAccount(double money){
        super(money);
        percent = 0.01;
    }

    @Override
    public boolean withdrawMoney(double money){
        double balance = getBalance();
        if (balance + (money * percent) > money){
            balance = balance - (money + (money * percent));
            super.setBalance(balance);
            return true;
        }else {
            System.out.println("Недостаточно средств на счете! ");
            return false;
        }

    }

    @Override
    public  String toString(){
        return  "Карточный счёт:\t"  + super.toString();
    }

    @Override
    public boolean send(BankAccount receiver, double money) {
        System.out.println("Перевод денег с карточного на депозитный счет: ");
        if (withdrawMoney(money)) {
            receiver.depositAmount(money);
            return true;
        } else {
            return  false;
        }

    }
}
