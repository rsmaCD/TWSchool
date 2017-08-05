package com.employee.entity;

/**
 * Created by rsma on 04/08/2017.
 */
public class Address {

    //地址唯一标识
    private String addressName;
    private String lineOne;
    private String lineTwo;
    private String city;

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getCity() {
        return city;
    }

    public String getLineOne() {
        return lineOne;
    }

    public String getLineTwo() {
        return lineTwo;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setLineOne(String lineOne) {
        this.lineOne = lineOne;
    }

    public void setLineTwo(String lineTwo) {
        this.lineTwo = lineTwo;
    }
}
