package accounts;

public abstract class BankAccount {
    private double balance;
    BankAccount(){
        balance = 0;
    }

    BankAccount(double money){
        balance = money;
    }

    public abstract boolean withdrawMoney(double money);

    public void depositAmount(double money){
        balance += money;
    }

    public final double getBalance(){
        return balance;
    }

    protected final void setBalance(double balance){
        this.balance = balance;
    }

    @Override
    public  String toString(){
        return "На вашем счете " + balance + "$";
    }

    public abstract boolean send(BankAccount receiver, double amount);

}
