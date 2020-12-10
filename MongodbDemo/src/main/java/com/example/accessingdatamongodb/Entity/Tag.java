package com.example.accessingdatamongodb.Entity;

public class Tag {
    /* 1是大件 2是中件 3是大件 */
    private int parcelSize;

    /*  1 2 3 4 ... 区分各个时间段 */
    private int timePeriod;

    /* 1 2 3 4 ... 区分各个区域 */
    private int area;

    /* 对方的的信誉分  */
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
