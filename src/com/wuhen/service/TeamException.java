package com.wuhen.service;

/**
 * @Author Wuhen
 * @Description 自定义异常类
 * @Date 2020/9/13
 **/
public class TeamException extends Exception{
    static final long serialVersionUID = -3387516993124229948L;
    public TeamException(){
        super();
    }
    public TeamException(String msg){
        super(msg);
    }
}