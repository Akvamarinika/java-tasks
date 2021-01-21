public class CardAccount extends BankAccount {
    private double percent;

    CardAccount(){
        super();
        percent = 0.01;
    }

    CardAccount(double money){
        super(money);
        percent = 0.01;
    }

    public void withdrawMoney(double money){
        double balance = getBalance();
        if (balance + (balance * percent) > money){
            balance = balance - (money + (balance * percent));
            super.setBalance(balance);
        }else {
            System.out.println("Недостаточно средств на счете! ");
        }

    }

}
