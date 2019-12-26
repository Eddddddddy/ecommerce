package com.eddy.ecommerce.bean;

public class Buy {
    private String b_email;
    private String b_name;
    private int b_state;

    public int getB_state() {
        return b_state;
    }

    public void setB_state(int b_state) {
        this.b_state = b_state;
    }

    public String getB_email() {
        return b_email;
    }

    public void setB_email(String b_email) {
        this.b_email = b_email;
    }

    public String getB_name() {
        return b_name;
    }

    public void setB_name(String b_name) {
        this.b_name = b_name;
    }
}
