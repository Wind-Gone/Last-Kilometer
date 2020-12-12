package com.example.accessingdatamongodb.Controller;

import com.example.accessingdatamongodb.Entity.Parcel;
import com.example.accessingdatamongodb.Service.ParcelService;
import com.example.accessingdatamongodb.dto.ResponseValue;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Parcel")
public class ParcelController {
    @Autowired
    ParcelService parcelService;

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
