package com.shanshan.flightmanager;

/**
 * Created by shanshan on 2016/3/15.
 */
public class FlightDatas {
    private String companyId ;
    private String id ;
    private String whereFrom ;
    private String whereTo ;
    private String timeBegin ;
    private String timeEnd ;
    private String transCity ;
    private String day ;
    private String isForigen;

    public FlightDatas() {}

    public FlightDatas(String companyId, String id ,String whereFrom, String whereTo,
                       String timeBegin, String timeEnd, String transCity,String day ){
        this.companyId = companyId;
        this.id = id;
        this.whereFrom = whereFrom;
        this.whereTo = whereTo;
        this.timeBegin = timeBegin;
        this.timeEnd = timeEnd;
        this.transCity = transCity;
        this.day = day;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWhereFrom() {
        return whereFrom;
    }

    public void setWhereFrom(String whereFrom) {
        this.whereFrom = whereFrom;
    }

    public String getWhereTo() {
        return whereTo;
    }

    public void setWhereTo(String whereTo) {
        this.whereTo = whereTo;
    }

    public String getTimeBegin() {
        return timeBegin;
    }

    public void setTimeBegin(String timeBegin) {
        this.timeBegin = timeBegin;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getTransCity() {
        return transCity;
    }

    public void setTransCity(String transCity) {
        this.transCity = transCity;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getIsForigen() {
        return isForigen;
    }

    public void setIsForigen(String isForigen) {
        this.isForigen = isForigen;
    }
}
