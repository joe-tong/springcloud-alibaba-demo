package com.tpp.common.bean;

/**
 * @Author: Joe
 * @Description:
 * @Date 2020/3/31 17:22
 */

public class ProductInfo {
    private String id;
    private String name;
    private int port;

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
