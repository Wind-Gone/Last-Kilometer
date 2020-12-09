package com.example.accessingdatamongodb.Controller;


import com.example.accessingdatamongodb.Entity.User;
import com.example.accessingdatamongodb.Repository.UserRepository;
import com.example.accessingdatamongodb.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.*;


@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAll")
    public List<User> getAll() {
        return userService.findAll();
    }

    @GetMapping("/getByName/{name}")
    public List<User> getByName(@PathVariable String name){
        return userService.getByName(name);
    }

    //大于score的用户
    @GetMapping("/getGoodScore/{score}")
    public List<User> getGoodScore(@PathVariable double score){
        return userService.getGoodScore(score);
    }

    @PostMapping("/addOne")
    public User addOne(@RequestBody User user){
        return userService.addUser(user);
    }

    @PostMapping("/update")
    public User update(@RequestBody User user){
        return userService.update(user);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id){
        userService.delete(id);
    }



    //似乎是匹配任意一个或几个属性值(不知道哪错了。。。，不能实现)
    @GetMapping("/getByExample")
    public List<User> getByExample(@RequestBody User user){
        return userService.findByExample(user);
    }



//    @PostMapping("/getByName")
//    public String getByName(@RequestBody User user){
//        userService.findByName()
//    }



//    @Autowired
//    private UserRepository repository;
//
//    @RequestMapping("/getAll")
//    public Map<String , Object > getAll(){
//
//        System.out.println("微信小程序正在调用。。。");
//        Map<String, Object> map = new HashMap<String, Object>();
//        List<String> list = new ArrayList<String>();
//
//        for (User user : repository.findAll()) {
//			list.add(user.getName());
//		}
//
//        map.put("list",list);
//        System.out.println("微信小程序调用完成。。。");
//        return map;
//    }

}
