import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

public class Account
{
    private AtomicLong money = new AtomicLong(0);
    private String accNumber;
    private boolean isBlocked;

    public Account(long money, String accNumber){
        this.money.set(money);
        this.accNumber = accNumber;
        isBlocked = false;
    }

    public boolean getIsBlocked(){
        return isBlocked;
    }

    public String getAccNumber(){
        return accNumber;
    }

    public long getMoney(){
        return money.get();
    }

    public boolean replenish(long amount) throws Exception {
        if (amount > 0 && !getIsBlocked()) {
            this.money.accumulateAndGet(amount, (balance, s) -> balance + s);
            return true;
        } else {
            throw new Exception("Sorry, account is blocked or amount < 0 ");
        }
    }

    public boolean withdraw(long amount) throws Exception{
        if (amount < money.get() && amount > 0 && !getIsBlocked()){
            this.money.accumulateAndGet(amount, (balance, s) -> balance - s);
            return true;
        }else{
            throw  new Exception("Sorry, account is blocked or amount < 0 or amount > balance");
        }

    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Account){
            Account account = (Account) obj;
            if (this.accNumber.equals(account.accNumber)){
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accNumber);
    }
}
