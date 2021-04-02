import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

import static org.junit.Assert.*;

public class WithdrawAccountTest {
    Account account1;
    Account account2;
    Account account3;

    @Before
    public void setUp() {
        account1 = new Account(10000, "111");
        account2 = new Account(5000, "222");
        account3 = new Account(20000, "333");
        account3.setIsBlocked(true);
    }

    @Test(expected = Exception.class)
    public void whenAmountDebitedExceedsAmountOnAnotherAccount() throws Exception {
        account2.withdraw(6000);
    }

    @Test(expected = Exception.class)
    public void whenWriteOffAmountIsZero() throws Exception{
        account2.withdraw(0);
    }

    @Test(expected = Exception.class)
    public void whenNegativeAmountIsDebitedFromAccount() throws Exception {
        account2.withdraw(-1000);
    }

    @Test
    public void whenAmountIsMoreThanZeroAndLessThanAccountBalance() throws Exception {
        account2.withdraw(1000);
        assertEquals(4000, account2.getMoney());
    }

    @Test(expected = Exception.class)
    public void whenAmountIsDebitedFromBlockedAccount() throws Exception{
        account3.withdraw(1000);
    }

    @Test
    public void whenSeveralClientsWithdrawMoneyFromOneAccount(){
        CompletableFuture.runAsync(() -> {
            ArrayList<Thread> threads = new ArrayList<>();
            for (int i = 0; i < 50; i++) {
                threads.add(new Thread(() -> {
                    try {
                        account1.withdraw(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }));
            }
            threads.forEach(Thread::start);
            assertEquals(5000, account1.getMoney());
        });
    }
}