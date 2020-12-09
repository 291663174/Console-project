package com.wuhen.service;

import javax.print.attribute.standard.PrinterURI;

/**
 * @Author Wuhen
 * @Description 表示员工的3种状态
 * @Date 2020/9/8
 **/
public class Status {

    private final String NAME;
    private Status(String name){
        this.NAME = name;
    }

    public static final Status FREE = new Status("FREE");
    public static final Status BUSY = new Status("BUSY");
    public static final Status VOCATION = new Status("VOCATION");

    public String getNAME() {
        return NAME;
    }

    @Override
    public String toString() {
        return NAME;
    }
}
