package checking.account;

public class LegalEntity extends Client {

    public LegalEntity(double balance){
        super(balance);
    }

    @Override
    public void withdraw(double money) {
        double balance;
        if (getBalance() >= (money + money * 0.01)){
            balance = getBalance() - (money + money * 0.01);
            setBalance(balance);
            System.out.printf("%nСнятие денег со счёта:  %5.2f$.", money);
            accountBalance();
        }else {
            System.out.println("Недостаточно средств на счете!");
        }
    }

    @Override
    public String toString(){
        return "\nЮридическое лицо — снятие с комиссией 1%. Пополнение без комиссии.";
    }
}
