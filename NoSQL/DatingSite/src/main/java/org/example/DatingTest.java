package org.example;


public class DatingTest {
    private static final DatingStorage redis = new DatingStorage();
    private static int counter = 0;
    private static final int USERS_COUNT = 20;

    public static void main(String[] args) throws InterruptedException {

        redis.init();

        for (int i = 1; i <= USERS_COUNT; i++) {
            redis.addUser(i);
        }

        while (true) {
            if (counter == 10) {
                counter = 0;
                int randomUser = (int) ((Math.random() * (USERS_COUNT - 1)) + 1);
                redis.addUser(randomUser);
                System.out.println("Пользователь " + randomUser + " оплатил платную услугу!");
                redis.showUser();
                continue;
            }
            counter++;
            redis.showUser();
        }
    }


}
