package com.shanshan.flightmanager;

/**
 * Created by Shakugan on 16/4/3.
 */
public class OrderDatas {

    private int id;
    private String userId;
    private String flight_number;
    private int price;

    public OrderDatas() {

    }

    public OrderDatas(String userId,String flight_number,int price) {
        this.userId = userId;
        this.flight_number = flight_number;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFlight_number() {
        return flight_number;
    }

    public void setFlight_number(String flight_number) {
        this.flight_number = flight_number;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
