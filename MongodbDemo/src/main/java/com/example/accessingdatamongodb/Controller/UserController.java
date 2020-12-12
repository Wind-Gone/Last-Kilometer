package com.example.accessingdatamongodb.Controller;


import com.example.accessingdatamongodb.Entity.User;
import com.example.accessingdatamongodb.Service.UserService;
import com.example.accessingdatamongodb.dto.ResponseValue;
import io.swagger.annotations.ApiOperation;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取所有用户信息
     *
     * @return 所有的用户
     */
    @ApiOperation("获取所有用户信息")
    @GetMapping("/getAll")
    public List<User> getAll() {
        return userService.findAll();
    }

    /**
     * 查询用户（通过名字）
     *
     * @param name 单个用户名
     * @return 用户信息
     */
    @ApiOperation("获取单个用户信息")
    @GetMapping("/getByName/{name}")
    public List<User> getByName(@PathVariable String name) {
        return userService.getByName(name);
    }

    //大于score的用户
    /**
     * 查询用户（通过信誉分）
     *
     * @param score 信誉分值
     * @return 大于该信誉分阈值的所有用户
     */
    @ApiOperation("获取大于某个信誉分阈值的用户们")
    @GetMapping("/getGoodScore/{score}")
    public List<User> getGoodScore(@PathVariable double score) {
        return userService.getGoodScore(score);
    }

    /**
     * 增加一个用户
     *
     * @param user  用户信息
     * @return 该用户
     */
    @ApiOperation("增加一个用户")
    @PostMapping("/addOne")
    public User addOne(@RequestBody User user) {
        return userService.addUser(user);
    }

    /**
     * 更新用户信息
     *
     * @param user  用户信息
     * @return 该用户
     */
    @ApiOperation("更新用户信息")
    @PostMapping("/update")
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    /**
     * 删除用户
     *
     * @param id 数据库_id
     * @return void
     */
    @ApiOperation("更新用户信息")
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        userService.delete(id);
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseValue<?> getRecommendParcel(@PathVariable long userId) {
        List<RecommendedItem> parcels = userService.getRecommendParcel(userId);
        return ResponseValue.success(parcels);
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
