import accounts.BankAccount;
import accounts.CardAccount;
import accounts.DepositAccount;
/*TODO
*   Напишите метод в классе BankAccount:
    boolean send(BankAccount receiver, double money)
    для отправки денег с одного счёта на другой. Метод должен вернуть true, если деньги успешно переведены.
*/
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

        //BankAccount bankAccountDeposit = depositAccount;
        System.out.println(cardAccount.send(depositAccount, 400));
        System.out.println(depositAccount);
        System.out.println(cardAccount);

       // BankAccount bankAccountCard = cardAccount;
        System.out.println(depositAccount.send(cardAccount, 1100));
        System.out.println(cardAccount);
        System.out.println(depositAccount);



    }
}
