import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Bank {
    private static final int AMOUNT_FOR_CHECK = 50000;

    private Map<String, Account> accounts;
    private final Random random = new Random();

    public Bank(Map<String, Account> accounts) {
        this.accounts = accounts;
    }

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами. Если сумма транзакции > 50000,
     * то после совершения транзакции, она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка счетов (как – на ваше
     * усмотрение)
     */
    public void transfer(String fromAccountNum, String toAccountNum, long amount) {
        Account from = getAccountValue(fromAccountNum);
        Account to = getAccountValue(toAccountNum);
        if ((from != null && to != null) && from != to) {
            synchronized (from.compareTo(to) > 0 ? from : to) {
                synchronized (from.compareTo(to) > 0 ? to : from) {
                    if (!from.isBlock() && !to.isBlock()) {
                        try {
                            if (amount > AMOUNT_FOR_CHECK && isFraud(fromAccountNum, toAccountNum, amount)) {
                                from.setBlock(true);
                                to.setBlock(true);
                                System.out.printf("""
                                                Transfer from %s to %s with amount %s.
                                                Fraud operation. Transaction blocked!
                                                """
                                        , fromAccountNum, toAccountNum, amount);
                                return;
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (from.getMoney() < amount) return;
                        from.setMoney(getBalance(fromAccountNum) - amount);
                        to.setMoney(getBalance(toAccountNum) - amount);
                        System.out.printf("""
                                        Transfer from %s to %s with amount %s.
                                        Balance for account %s is: %d
                                        Balance for account %s is: %d
                                                                        
                                        """
                                , fromAccountNum, toAccountNum, amount, fromAccountNum,
                                getBalance(fromAccountNum), toAccountNum, getBalance(toAccountNum));
                    } else {
                        System.out.printf("""
                                            Transaction with blocked accounts.
                                            From %s (block status: %s) to %s (bloc status: %s) with amount %s.
                                            Transaction canceled!
                                                                                                
                                          """
                        , fromAccountNum, from.isBlock(), toAccountNum, to.isBlock(), amount);

                    }
                }
            }
        }
    }

    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public long getBalance(String accountNum) {
        return getAccountValue(accountNum).getMoney();
    }

    public long getSumAllAccounts() {
        return accounts
                .entrySet()
                .parallelStream()
                .mapToLong(acc -> acc.getValue().getMoney())
                .sum();
    }

    public Account getAccountValue(String accNumber) {
        return accounts
                .entrySet()
                .parallelStream()
                .filter(acc -> acc.getValue().getAccNumber().equals(accNumber))
                .findAny()
                .get()
                .getValue();
    }
}
