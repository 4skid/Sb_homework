import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Map<String, Account> accounts = new HashMap<>();

        for (int i = 1; i < 101; i++) {
            accounts.put(String.valueOf(i), new Account(String.valueOf(i), (long) (100000 * Math.random())));
        }

        Bank bank = new Bank(accounts);
        System.out.printf("Total bank cash: %d.", bank.getSumAllAccounts());

        ArrayList<Thread> threads = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            int from = random.nextInt(100) + 1;
            int to = random.nextInt(100) + 1;
            int amount = random.nextInt(100000) + 1000;
            threads.add(new Thread(() -> bank.transfer(String.valueOf(from), String.valueOf(to), amount)));
        }

        threads.forEach(Thread::start);
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("AccountNumber | Balance | BlockedStatus");
        accounts.forEach((key, value) -> {
            System.out.print(value.getAccNumber() + "\t\t\t\t");
            System.out.print(value.getMoney() + "\t\t\t\t");
            System.out.println(value.isBlock());
        });

        System.out.printf("""
                ==============================
                Total bank cash: %d.
                """, bank.getSumAllAccounts());
    }
}
