package com.krishna.msuser;


import java.util.List;

public interface UserService {

    User registerUser(User user);

    List<User> getAllUsers();
}
