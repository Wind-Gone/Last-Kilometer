package com.example.accessingdatamongodb.Controller;


import com.example.accessingdatamongodb.Entity.User;
import com.example.accessingdatamongodb.Service.UserService;
import com.example.accessingdatamongodb.dto.ResponseValue;
import io.swagger.annotations.ApiOperation;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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
    public ResponseValue<?> getAll() {
        return ResponseValue.success(userService.findAll());
    }

    /**
     * 查询用户（通过名字）
     *
     * @param name 单个用户名
     * @return 用户信息
     */
    @ApiOperation("获取单个用户信息")
    @GetMapping("/getByName/{name}")
    public ResponseValue<?> getByName(@Validated @PathVariable String name) {
        return ResponseValue.success(userService.getByName(name));
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
    public ResponseValue<?> getGoodScore(@Validated @PathVariable double score) {
        return ResponseValue.success(userService.getGoodScore(score));
    }

    /**
     * 增加一个用户
     *
     * @param user 用户信息
     * @return 该用户
     */
    @ApiOperation("增加一个用户")
    @PostMapping("/addOne")
    public ResponseValue<?> addOne(@Validated @RequestBody User user) {
        userService.addUser(user);
        return ResponseValue.success(user.getStudentID());
    }

    /**
     * 更新用户信息
     *
     * @param user 用户信息
     * @return 该用户
     */
    @ApiOperation("更新用户信息")
    @PostMapping("/update")
    public ResponseValue<?> update(@Validated @RequestBody User user) {
        userService.update(user);
        return ResponseValue.success(null);
    }

    /**
     * 删除用户
     *
     * @param id 数据库_id
     * @return void
     */
    @ApiOperation("删除用户信息")
    @DeleteMapping("/delete/{id}")
    public ResponseValue<?> delete(@Validated @PathVariable String id) {
        userService.delete(id);
        return ResponseValue.success(null);
    }

    @ApiOperation("推荐系统")
    @GetMapping("/recommend/{id}")
    public ResponseValue<?> getRecommendParcel(@Validated @PathVariable long id) throws IOException, TasteException {
        List<RecommendedItem> parcels = userService.getRecommendParcel(id);
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
