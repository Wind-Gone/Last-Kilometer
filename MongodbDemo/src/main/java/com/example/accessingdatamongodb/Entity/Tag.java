package com.example.accessingdatamongodb.Entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "标签实体类")
public class Tag {
    /* 1是大件 2是中件 3是大件 */
    @ApiModelProperty(value = "快递大小")
    private int parcelSize;

    /*  1 2 3 4 ... 区分各个时间段 */
    @ApiModelProperty(value = "期望时间段")
    private int timePeriod;

    /* 1 2 3 4 ... 区分各个区域 */
    @ApiModelProperty(value = "期望取快递的区域")
    private int area;

    /* 对方的的信誉分  */
    @ApiModelProperty(value = "期望对方的信誉分")
    private double expectedScore;

    public Tag(int parcelSize, int timePeriod, int area, double expectedScore) {
        this.parcelSize = parcelSize;
        this.timePeriod = timePeriod;
        this.area = area;
        this.expectedScore = expectedScore;
    }

    public int getParcelSize() {
        return parcelSize;
    }

    public void setParcelSize(int parcelSize) {
        this.parcelSize = parcelSize;
    }

    public int getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(int timePeriod) {
        this.timePeriod = timePeriod;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public double getExpectedScore() {
        return expectedScore;
    }

    public void setExpectedScore(double expectedScore) {
        this.expectedScore = expectedScore;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "parcelSize=" + parcelSize +
                ", timePeriod=" + timePeriod +
                ", area=" + area +
                ", expectedScore=" + expectedScore +
                '}';
    }
}
