package org.example;

import org.redisson.Redisson;
import org.redisson.api.RScoredSortedSet;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisConnectionException;
import org.redisson.config.Config;

import java.util.Collection;
import java.util.Date;

public class DatingStorage {
    private RedissonClient redisson;
    private RScoredSortedSet<String> users;
    private final static String KEY = "REGISTERED_USERS";

    private double getTs() {
        return new Date().getTime();
    }

    void init() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        try {
            redisson = Redisson.create(config);
        } catch (RedisConnectionException ex) {
            System.out.println("Не удалось подключиться к Redis");
            System.out.println(ex.getMessage());
        }
        users = redisson.getScoredSortedSet(KEY);
        users.clear();
    }

    void addUser(int user_id) {
        users.add(getTs(), String.valueOf(user_id));
    }

    void showUser() {
        Collection<String> printList = users.valueRange(0, users.size());

        printList.forEach((usr) -> {
            System.out.println("На главной странице показываем пользователя " + usr);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

}
