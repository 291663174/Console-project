package com.wuhen.domain;

import com.wuhen.service.Status;

/**
 * @Author Wuhen
 * @Description
 * @Date 2020/9/8
 **/
public class Programmer extends Employee{
    /**
     * 开发团队中的id
     **/
    private int memberId;
    //默认FREE
    private Status status = Status.FREE;
    private Equipment equipment;

    public Programmer() {
        super();
    }

    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.status = status;
        this.equipment = equipment;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return getDetails() + "\t\t程序员\t\t" + status + "\t\t\t\t\t\t\t\t" + equipment.getDescription();
    }

    public String getTeamBaseDetails(){
        return memberId + "/" + getId() + "\t\t\t" +getName() + "\t\t" + getAge() + "\t\t"
                +getSalary() ;
    }

    public String getDetailsForTeam(){
        return  getTeamBaseDetails() + "\t\t程序员";
    }
}
