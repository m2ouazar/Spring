package com.m2ouazar.Sport.QCM.service;
import com.m2ouazar.Sport.QCM.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.m2ouazar.Sport.QCM.model.user;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userService {

    private userRepository userRepository;

    @Autowired
    public userService(userRepository userRepository) {
        this.userRepository = userRepository;
    }

    //CRUD Operations
    //GET ALL userS
    public List<user> getAllusers(){
        return userRepository.findAll();
    }

    //GET user BY ID
    public user userById(String id){
        return userRepository.findById(id).orElse(null);
    }

    //POST user
    public user saveuser(user user){
        return userRepository.save(user);
    }

    //PUT user
    public user updateuser(String id, user user){
        if(userRepository.existsById(id)){
            user.setId(id);
            return userRepository.save(user);
        }
        else return null;
    }

    //DELETE user
    public void deleteuser(String id){
        userRepository.deleteById(id);
    }

    //TODO
}
