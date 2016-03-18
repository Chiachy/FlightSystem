package com.shanshan.flightmanager;

/**
 * 使用数据库前的测试数据
 * */
public class testData{
    private String whereFrom, whereTo;
    private String timeBegin, timeEnd;
    private String transCity;

    public testData(String whereFrom, String whereTo, String timeBegin, String timeEnd, String transCity){
        this.whereFrom = whereFrom;
        this.whereTo = whereTo;
        this.timeBegin = timeBegin;
        this.timeEnd = timeEnd;
        this.transCity = transCity;
    }

    public String getWhereFrom(){
        return whereFrom;
    }

    public String getWhereTo(){
        return whereTo;
    }

    public String getTimeBegin(){
        return timeBegin;
    }

    public String getTimeEnd(){
        return timeEnd;
    }

    public String getTransCity(){
        return transCity;
    }
}
