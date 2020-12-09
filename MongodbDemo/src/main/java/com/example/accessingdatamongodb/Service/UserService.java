package com.example.accessingdatamongodb.Service;

import com.example.accessingdatamongodb.Entity.User;
import com.example.accessingdatamongodb.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;


    public List<User> findAll() {
        return userRepository.findAll();
    }

    public List<User> findByName(String Name){
        return userRepository.findByName(Name);
    }


    public User addUser(User user) {
        return userRepository.insert(user);
    }

    public User update(User user) {
        return userRepository.save(user);
    }

    public void delete(String id) {
        userRepository.deleteById(id);
    }

    public List<User> findByExample(User user) {
        user.setName("Alice");
        Example<User> e = Example.of(user);
        return userRepository.findAll(e);
    }

    public List<User> getByName(String name) {
        return userRepository.findByName(name);
    }

    public List<User> getGoodScore(double score) {
        return userRepository.findGoodScore(score);
    }
}
