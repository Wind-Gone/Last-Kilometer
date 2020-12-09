package com.example.accessingdatamongodb;

import com.example.accessingdatamongodb.Entity.User;
import com.example.accessingdatamongodb.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;

@SpringBootTest
public class
MyTest {
    @Autowired
    UserRepository userRepository;

    @Test
    public void czhtest(){
        User user = new User();
        user.setName("Alice");
        Example<User> e = Example.of(user);
        System.out.println("aaaa"+userRepository.findOne(e));
    }

}
