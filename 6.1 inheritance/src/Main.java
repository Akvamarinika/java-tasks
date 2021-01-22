import accounts.CardAccount;
import accounts.DepositAccount;

public class Main {
    public static void main(String[] args){
        CardAccount cardAccount = new CardAccount();
        System.out.println(cardAccount);
        cardAccount.withdrawMoney(500);

        cardAccount.depositAmount(1000);
        System.out.println(cardAccount);

        cardAccount.withdrawMoney(500);
        System.out.println(cardAccount);

        DepositAccount depositAccount = new DepositAccount();
        depositAccount.depositAmount(820);
        System.out.println(depositAccount);
        depositAccount.withdrawMoney(100);
        System.out.println(depositAccount);
        depositAccount.dateOfLastDeposit();

    }
}
