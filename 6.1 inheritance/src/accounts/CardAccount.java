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
    public void withdrawMoney(double money){
        double balance = getBalance();
        if (balance + (money * percent) > money){
            balance = balance - (money + (money * percent));
            super.setBalance(balance);
        }else {
            System.out.println("Недостаточно средств на счете! ");
        }

    }

    @Override
    public  String toString(){
        return  "Карточный счёт:\t"  + super.toString();
    }

}
