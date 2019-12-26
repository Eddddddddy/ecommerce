package com.eddy.ecommerce.bean;

public class Goods {
    private String g_name;
    private String g_description;
    private int g_price;
    private int g_inventory;
    private String g_more;
    private String g_detail;
    private int g_state;

    public int getG_state() {
        return g_state;
    }

    public void setG_state(int g_state) {
        this.g_state = g_state;
    }

    public String getG_more() {
        return g_more;
    }

    public void setG_more(String g_more) {
        this.g_more = g_more;
    }

    public String getG_detail() {
        return g_detail;
    }

    public void setG_detail(String g_detail) {
        this.g_detail = g_detail;
    }

    public String getG_name() {
        return g_name;
    }

    public void setG_name(String g_name) {
        this.g_name = g_name;
    }

    public String getG_description() {
        return g_description;
    }

    public void setG_description(String g_description) {
        this.g_description = g_description;
    }

    public int getG_price() {
        return g_price;
    }

    public void setG_price(int g_price) {
        this.g_price = g_price;
    }

    public int getG_inventory() {
        return g_inventory;
    }

    public void setG_inventory(int g_inventory) {
        this.g_inventory = g_inventory;
    }
}
