package com.tpp.common.bean;

/**
 * @Author: Joe
 * @Description:
 * @Date 2020/4/1 16:38
 */
public class StockInfo {
    private int num;
    private String category;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "StockInfo{" +
                "num=" + num +
                ", category='" + category + '\'' +
                '}';
    }
}
