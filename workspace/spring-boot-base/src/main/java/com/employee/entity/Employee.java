package com.employee.entity;

import java.util.List;

/**
 * Created by rsma on 04/08/2017.
 */
public class Employee {

    private String id;
    private String name;
    private String email;
    List<Address> addressList;

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj.getClass() == this.getClass()){
            if(((Employee)obj).getId().equals(this.getId())){
                if(((Employee)obj).getName().equals(this.getName())){
                    if(((Employee)obj).getEmail().equals(this.getEmail())){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean myEquals(Object obj) {
        if(obj.getClass() == this.getClass()){
            if((((Employee)obj).getId() == null) ||((Employee)obj).getId().equals(this.getId())){
                if((((Employee)obj).getName() == null) ||((Employee)obj).getName().equals(this.getName())){
                    if((((Employee)obj).getEmail() == null) ||((Employee)obj).getEmail().equals(this.getEmail())){
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
