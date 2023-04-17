package ict.bean;

import java.io.Serializable;

public class CustomerBean implements Serializable {
    private String custId;
    private String name;
    private String tel;
    private int age;

    public CustomerBean() {}

    public CustomerBean(String custId, String name, String tel, int age) {
        this.custId = custId;
        this.name = name;
        this.tel = tel;
        this.age = age;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "ID: " + custId + "\n" +
                "Name: " + name + "\n" +
                "Tel: " + tel + "\n" +
                "Age: " + age;
    }
}
