package accounts;

public abstract class BankAccount {
    private double balance;
    BankAccount(){
        balance = 0;
    }

    BankAccount(double money){
        balance = money;
    }

    public void withdrawMoney(double money){
        if (balance > money){
            balance -= money;
        }else {
            System.out.println("Недостаточно средств на счете! ");
        }

    }

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
}
