package com.wuhen.domain;

import com.wuhen.service.Status;

/**
 * @Author Wuhen
 * @Description
 * @Date 2020/9/10
 **/
public class Architect extends Designer{
    //股票
    private int stock;

    public Architect() {
        super();
    }

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return getDetails() + "\t\t架构师\t\t" + getStatus() + "\t\t" + getBonus() + "\t\t" + stock
                + "\t\t" + getEquipment().getDescription();
    }

    @Override
    public String getDetailsForTeam(){
        return getTeamBaseDetails()
                + "\t\t架构师" + "\t\t"  + getBonus() + "\t\t" + getStock();
    }
}
