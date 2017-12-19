package com.krishna.msuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    @Value("${spring.kakfa.topic.user-created}")
    private static String USER_CREATED_TOPIC;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Sender sender;

    @Override
    public User registerUser(User user) {
        final User save = userRepository.save(user);
        sender.send(USER_CREATED_TOPIC, save);
        return save;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }
}
