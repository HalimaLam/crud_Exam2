package com.example.SpringTh.Service;

import com.example.SpringTh.Entity.User;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void saveUser(User user);
    User getUserById(long id);
    void deleteUserById(long id);
    boolean assignProjectToEmployee(String employeeName, String projectName);
}
