package ru.gb.Spring.Web.Rest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.Spring.Web.Rest.domain.User;
import ru.gb.Spring.Web.Rest.repository.UserRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataProcessingService {
    @Autowired
    private UserRepository repository;

    public UserRepository getRepository() {
        return repository;
    }

    public void addUserToRepo(User user) {
        repository.addUserToDB(user);
    }

    public List<User> sortUsersByAge() {
        return repository.getUsers()
                .stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
    }

    public List<User> filterUsersByAge(int age) {
        return repository.getUsers()
                .stream()
                .filter(user -> user.getAge() > age)
                .collect(Collectors.toList());
    }

    public double calculateAverageAge() {
        return repository.getUsers()
                .stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
    }
}
