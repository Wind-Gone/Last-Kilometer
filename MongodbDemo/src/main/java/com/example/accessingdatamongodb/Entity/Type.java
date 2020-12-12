package com.example.accessingdatamongodb.Entity;


import com.example.accessingdatamongodb.enums.ParcelType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.mongodb.core.mapping.MongoId;

@ApiModel(value = "包裹分类")
public class Type {
    @ApiModelProperty(value = "分类id")
    @MongoId
    private Long id;

    @ApiModelProperty(value = "快递大小")
    private int parcelSize;

    @ApiModelProperty(value = "具体种类")
    private ParcelType parcelType;

    public Type(Long id, int parcelSize, ParcelType parcelType) {
        this.id = id;
        this.parcelSize = parcelSize;
        this.parcelType = parcelType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getParcelSize() {
        return parcelSize;
    }

    public void setParcelSize(int parcelSize) {
        this.parcelSize = parcelSize;
    }

    public ParcelType getParcelType() {
        return parcelType;
    }

    public void setParcelType(ParcelType parcelType) {
        this.parcelType = parcelType;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", parcelSize=" + parcelSize +
                ", parcelType=" + parcelType +
                '}';
    }
}
