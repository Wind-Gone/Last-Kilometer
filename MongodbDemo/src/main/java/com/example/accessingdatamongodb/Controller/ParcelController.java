package com.example.accessingdatamongodb.Controller;

import com.example.accessingdatamongodb.Entity.Parcel;
import com.example.accessingdatamongodb.Service.ParcelService;
import com.example.accessingdatamongodb.Util.CfUtil;
import com.example.accessingdatamongodb.dto.ResponseValue;
import io.swagger.annotations.ApiOperation;
import org.apache.mahout.cf.taste.common.TasteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Parcel")
public class ParcelController {
    @Autowired
    ParcelService parcelService;

    @Autowired
    private CfUtil cfUtil;

    /**
     * 基于物品协同过滤获取推荐包裹信息
     *
     * @param UserID 当前用户ID（学号？） Item 当前ItemID（快递单号？）
     * @return 推荐ItemID列表（还没有数据集，有数据集了再把返回值改为 推荐包裹列表）
     */
    @ApiOperation("基于物品的CF")
    @PostMapping("/getByCFItemBased/{UserID}/{ItemID}")
    public List<Long> getByCFItemBased(@PathVariable int UserID,@PathVariable int ItemID) throws TasteException {
        return cfUtil.CfItemBased(UserID,ItemID,3);
    }

    /**
     * 基于用户协同过滤获取推荐包裹信息
     *
     * @param UserID 当前用户ID（学号？）
     * @return 推荐ItemID列表（还没有数据集，有数据集了再把返回值改为 推荐包裹列表）
     */
    @ApiOperation("基于用户的CF")
    @PostMapping("/getByCFUserBased/{UserID}")
    public List<Long> getByCFUserBased(@PathVariable int UserID) throws TasteException {
        return cfUtil.CfUserBased(UserID,3);
    }



    /**
     * 获取所有包裹信息
     *
     * @return 所有的包裹
     */
    @ApiOperation("获取所有包裹信息")
    @GetMapping("/getAll")
    public List<Parcel> getAll() {
        return parcelService.findAll();
    }


    /**
     * 新增一条包裹信息
     *
     * @param parcel 单个包裹
     * @return 插入的包裹的ID
     */
    @ApiOperation("新增一条包裹信息")
    @PostMapping("/addOne")
    public ResponseValue<?> addOne(@Validated @RequestBody Parcel parcel) {
        String id = parcelService.addOne(parcel);
        return ResponseValue.success(id);
    }

    /**
     * 更新一条包裹信息
     *
     * @param parcel 单个包裹
     * @return null
     */
    @ApiOperation("更新一条包裹信息")
    @PostMapping("/update")
    public ResponseValue<?> update(@Validated @RequestBody Parcel parcel) {
        parcelService.update(parcel);
        return ResponseValue.success(null);
    }


    /**
     * 删除一条包裹信息
     *
     * @param id 包裹id
     * @return null
     */
    @ApiOperation("删除一条包裹信息")
    @DeleteMapping("/delete/{id}")
    public ResponseValue<?> delete(@Validated @PathVariable Long id) {
        parcelService.delete(id);
        return ResponseValue.success(null);
    }

}
