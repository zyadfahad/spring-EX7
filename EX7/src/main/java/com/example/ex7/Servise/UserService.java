package com.example.ex7.Servise;

import com.example.ex7.Model.UserModel;
import com.example.ex7.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class UserService {
   public UserRepository userRepository;


    public List<UserModel> getUser() {
        return userRepository.findAll();
    }

    public void addUser(UserModel user) {
        userRepository.save(user);
    }

    public boolean updateUser(Integer id, UserModel userModel) {
        UserModel oldUser = userRepository.getById(id);

        if(oldUser==null)return false;

        oldUser.setUsername(userModel.getUsername());
        oldUser.setName(userModel.getName());
        oldUser.setAge(userModel.getAge());
        oldUser.setRole(userModel.getRole());
        oldUser.setEmail(userModel.getEmail());
        oldUser.setPassword((userModel.getPassword()));

        userRepository.save(oldUser);

        return true;    }

    public boolean delateUser(Integer id) {

         UserModel userModel = userRepository.getById(id);
        if (userModel == null) return false;


        userRepository.delete(userModel);
        return true;
    }
}
