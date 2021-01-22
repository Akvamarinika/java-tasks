package checking.account;

public class IndividualEntrepreneur extends Client {

    public IndividualEntrepreneur(double balance){
        super(balance);
    }

    @Override
    public void toDeposit(double money){
        double balance;
        if (money > 1000 && (money * 0.01 ) < getBalance()){
            balance = getBalance() - (money * 0.01 ) + money;
            setBalance(balance);
            System.out.printf("%nПополнение счёта:  %5.2f$.", money);
            accountBalance();
        }else if(money <= 1000 && (money * 0.005) < getBalance()){
            balance = getBalance() - (money * 0.005) + money;
            setBalance(balance);
            System.out.printf("%nПополнение счёта:  %5.2f$.", money);
            accountBalance();
        }

    }

    public String toString(){
        return "\nИП — пополнение с комиссией 1%, если сумма меньше 1000 рублей. И с комиссией 0,5%, если сумма больше либо равна 1000 рублей.";
    }
}
