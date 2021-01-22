package checking.account;

public abstract class Client {
    private double balance;

    public Client(double balance){
        this.balance = balance;
    }

    public final double getBalance(){
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    public void toDeposit(double money){
        balance += money;
        System.out.printf("%nПополнение счёта:  %5.2f$.", money);
        accountBalance();
    }

    public void withdraw(double money) {
        if (balance >= money){
            balance -= money;
            System.out.printf("%nСнятие денег со счёта:  %5.2f$.", money);
            accountBalance();
        }else {
            System.out.println("\nНедостаточно средств на счете!");
        }
    }

    protected void accountBalance(){
        System.out.printf("\nВаш баланс: %5.2f$", balance);
    }


}
