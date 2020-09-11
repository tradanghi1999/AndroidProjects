package vn.edu.uel.nghiatd17411.model;

import java.io.Serializable;

public class ShippingCenter implements Serializable {
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ShippingCenter(int id, String name, int hinh, String phone, String address) {
        this.id = id;
        this.name = name;
        this.hinh = hinh;
        this.phone = phone;
        this.address = address;
    }

    String name;
    int hinh;
    String phone;
    String address;
}
