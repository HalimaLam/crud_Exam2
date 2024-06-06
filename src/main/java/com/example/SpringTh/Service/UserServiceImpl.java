package com.example.SpringTh.Service;

import com.example.SpringTh.Entity.User;
import com.example.SpringTh.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

     @Autowired
     private UserRepo  userRepo;
    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public void saveUser(User user) {
        userRepo.save(user);
    }

    @Override
    public User getUserById(long id) {
        Optional<User> optional=userRepo.findById(id);
        User user=null;
        if(optional.isPresent()){
            user=optional.get();
        }else{
            throw new RuntimeException("User not found for id : " + id);
        }
        return user;
    }

    @Override
    public void deleteUserById(long id) {
        this.userRepo.deleteById(id);
    }
}
