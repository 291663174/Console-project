package com.wuhen.management.service;

import com.wuhen.management.bean.Customer;

/**
 * @author Wuhen
 * @Description CustomerList为Customer对象的管理模块，内部用数组管理一组Customer对象，并提供相应的
 *     添加、修改、删除和遍历方法。供CustomerView调用
 * @date 2020/8/31
 **/
public class CustomerList {
    /**
     * customers是用来保存客户对象的数组
     **/
    private Customer[] customers;
    /**
     * 记录已保存客户对象的数量,默认为0
     **/
    private int total;

    /**
     * 用来初始化customer数组的构造器
     * totalCustomer指定数组的长度
     **/
    public CustomerList(int totalCustomer){
        customers = new Customer[totalCustomer];
    }

    /**
     * 将指定的客户添加到数组中
     * return true 添加成功，false添加失败
     **/
    public boolean addCustomer(Customer customer){
        if (total >= customers.length){
            return false;
        }
        //customers[total] = customer;
        //total++;
        //或
        customers[total++] = customer;
        return true;
    }

    /**
     * return true 修改成功，false修改失败
     **/
    public boolean replaceCustomer(int index,Customer cust){
        if (index < 0 || index >= total){
            return false;
        }
        customers[index] = cust;
        return true;
    }

    /**
     * 删除指定索引位置上的客户
     * return true 删除成功，false修改失败
     **/
    public boolean deleteCustomer(int index){
        if (index < 0 || index >= total){
            return false;
        }
        for (int i = 0 ; i < total - 1; i++){
            customers[i] = customers[i+1];
        }
        //最后有数据的元素需要置空
        //customers[total-1] = null;
        //total--;
        //或
        customers[--total] = null;
        return true;
    }

    /**
     * 获取所有客户信息
     * return true 查找成功，false查找失败
     **/
    public Customer[] getAllCustomer(){
        Customer[] custs = new Customer[total];
        for (int i = 0; i < total;i++){
            custs[i] = customers[i];
        }
        return custs;
    }

    /**
     * 获取指定索引位置上的客户
     * return true 查找元素成功，null查找失败
     **/
    public Customer getCustomer(int index){
        if (index < 0 || index >= total){
            return null;
        }
        return customers[index];
    }

    /**
     * 获取存储的客户数量
     **/
    public int getTotal(){
        return total;
    }
}
