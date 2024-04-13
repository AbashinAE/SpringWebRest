package ru.gb.Spring.Web.Rest.services;

import org.springframework.stereotype.Service;
import ru.gb.Spring.Web.Rest.domain.User;

@Service
public class NotificationService {

    public void notifyUser(User user) {
        System.out.println("Создан новый пользователь: " + user.getName());
    }

    public void sendNotification(String s) {
        System.out.println(s);
    }
}