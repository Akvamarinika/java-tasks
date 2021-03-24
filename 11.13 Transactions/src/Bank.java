import java.util.HashMap;
import java.util.Random;

public class Bank
{
    private HashMap<String, Account> accounts;
    private final Random random = new Random();
    private static final int MAX_AMOUNT = 50_000;

    public synchronized boolean isFraud(String fromAccountID, String toAccountID, long amount)
        throws InterruptedException
    {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами.
     * Если сумма транзакции > 50000, то после совершения транзакции,
     * она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка
     * счетов (как – на ваше усмотрение)
     */
    public void transfer(String fromAccountID, String toAccountID, long amount, boolean isBlocked) throws Exception
    {
        if(getAccount(fromAccountID).getIsBlocked() || getAccount(toAccountID).getIsBlocked()){
            throw new Exception("Sorry, one from Account is Blocked!");
        }

        if(getAccount(fromAccountID).equals(getAccount(fromAccountID))){
            throw new Exception("Sorry, two identical bank accounts!");
        }

        if (amount > MAX_AMOUNT){
            try {
                boolean isFraud = isFraud(fromAccountID, toAccountID, amount);
                if (isFraud){

                }
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        } else {
            System.out.println("Sorry, you account is blocked!");
        }
    }

    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public long getBalance(String accountID){
        return getAccount(accountID).getMoney();
    }

    public boolean isExistAccountID(String accountID) {
            return accounts.containsKey(accountID);
    }

    public Account getAccount(String accountID){
        if(isExistAccountID(accountID)){
            return accounts.get(accountID);
        } else {

            try {
                throw new Exception(accountID);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    public void blockedAccount(String accountID){
        //getAccount(accountID)
    }
}
