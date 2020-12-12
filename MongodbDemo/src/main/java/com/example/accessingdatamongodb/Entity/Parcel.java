package com.example.accessingdatamongodb.Entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@ApiModel(value = "快递实体类")
@Document(value = "Parcel")
public class Parcel {
    @Id
    private String id;

    @ApiModelProperty(value = "快递收件地址")
    private String address;

    @ApiModelProperty(value = "用户头像URL")
    private String author_avatar_url;

    @ApiModelProperty(value = "用户id")
    private String author_id;

    @ApiModelProperty(value = "用户姓名")
    private String author_name;

    @ApiModelProperty(value = "用户包裹名字")
    private String author_parcel_name;

    @ApiModelProperty(value = "楼号")
    private String blockNum;

    @ApiModelProperty(value = "包裹简介")
    private String content;

    @ApiModelProperty(value = "快递单号")
    private String deliver_id;

    @ApiModelProperty(value = "快递图片URL")
    private String image_url;

    @ApiModelProperty(value = "电话")
    private String mobile;

    @ApiModelProperty(value = "Note")
    private String note;

    @ApiModelProperty(value = "pickup_code")
    private String pickup_code;

    @ApiModelProperty(value = "publish_time")
    private Date publish_time;

    @ApiModelProperty(value = "status")
    private int status;

    @ApiModelProperty(value = "更新时间")
    private Date update_time;

    @ApiModelProperty(value = "查看次数")
    private int watch_count;

    public Parcel(String address, String author_avatar_url, String author_id, String author_name, String author_parcel_name, String blockNum, String content, String deliver_id, String image_url, String mobile, String note, String pickup_code, Date publish_time, int status, Date update_time, int watch_count) {
        this.address = address;
        this.author_avatar_url = author_avatar_url;
        this.author_id = author_id;
        this.author_name = author_name;
        this.author_parcel_name = author_parcel_name;
        this.blockNum = blockNum;
        this.content = content;
        this.deliver_id = deliver_id;
        this.image_url = image_url;
        this.mobile = mobile;
        this.note = note;
        this.pickup_code = pickup_code;
        this.publish_time = publish_time;
        this.status = status;
        this.update_time = update_time;
        this.watch_count = watch_count;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAuthor_avatar_url() {
        return author_avatar_url;
    }

    public void setAuthor_avatar_url(String author_avatar_url) {
        this.author_avatar_url = author_avatar_url;
    }

    public String getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(String author_id) {
        this.author_id = author_id;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getAuthor_parcel_name() {
        return author_parcel_name;
    }

    public void setAuthor_parcel_name(String author_parcel_name) {
        this.author_parcel_name = author_parcel_name;
    }

    public String getBlockNum() {
        return blockNum;
    }

    public void setBlockNum(String blockNum) {
        this.blockNum = blockNum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDeliver_id() {
        return deliver_id;
    }

    public void setDeliver_id(String deliver_id) {
        this.deliver_id = deliver_id;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPickup_code() {
        return pickup_code;
    }

    public void setPickup_code(String pickup_code) {
        this.pickup_code = pickup_code;
    }

    public Date getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(Date publish_time) {
        this.publish_time = publish_time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public int getWatch_count() {
        return watch_count;
    }

    public void setWatch_count(int watch_count) {
        this.watch_count = watch_count;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id='" + id + '\'' +
                ", address='" + address + '\'' +
                ", author_avatar_url='" + author_avatar_url + '\'' +
                ", author_id='" + author_id + '\'' +
                ", author_name='" + author_name + '\'' +
                ", author_parcel_name='" + author_parcel_name + '\'' +
                ", blockNum='" + blockNum + '\'' +
                ", content='" + content + '\'' +
                ", deliver_id='" + deliver_id + '\'' +
                ", image_url='" + image_url + '\'' +
                ", mobile='" + mobile + '\'' +
                ", note='" + note + '\'' +
                ", pickup_code='" + pickup_code + '\'' +
                ", publish_time='" + publish_time + '\'' +
                ", status=" + status +
                ", update_time='" + update_time + '\'' +
                ", watch_count=" + watch_count +
                '}';
    }
}
