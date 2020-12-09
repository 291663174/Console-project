package com.wuhen.service;

import com.wuhen.domain.Architect;
import com.wuhen.domain.Designer;
import com.wuhen.domain.Employee;
import com.wuhen.domain.Programmer;

/**
 * @Author Wuhen
 * @Description 关于开发团队成员的管理，添加，删除等。
 * @Date 2020/9/14
 **/
public class TeamService {

    /**
     * 给memberId赋值使用
     **/
    private static int counter = 1;

    /**
     * 限制开发团队的人数
     **/
    private final int MAX_MEMBER = 5;

    /**
     * 保存开发团队成员
     **/
    private Programmer[] team = new Programmer[MAX_MEMBER];

    /**
     * 记录开发团队中实际的人数
     **/
    private int total;

    public TeamService() {
        super();
    }

    /**
     * 获取开发团队中的所有成员
     **/
    public Programmer[] getTeam(){
        Programmer[] team = new Programmer[total];
        for (int i = 0; i<team.length; i++){
            team[i] = this.team[i];
        }
        return team;
    }

    public void addMember(Employee employee) throws TeamException {
        /**
         * 成员已满，无法添加
         **/
        if (total >= MAX_MEMBER){
            throw new TeamException("成员已满，无法添加！");
        }

         /**
         *  该成员不是开发人员，无法添加
         **/
         if( !(employee instanceof Programmer) ){
             throw new TeamException("该成员不是开发人员，无法添加！");
         }

        /**
         *  该员工已在本开发团队中，无法添加
         **/
        if ( isExist(employee) ){
            throw new TeamException("该员工已在本开发团队中!");
        }

        /**
         *  该员工已是某团队成员
         *  该成员正在休假，无法添加
         *  一定不会出现ClassCastException(强制转换类型异常)
         **/
        Programmer programmer = (Programmer) employee;
        if ("BUSY".equals(programmer.getStatus().getNAME())){
            throw new TeamException("该员工已是某团队成员");
        }

        /**
         *  忽略大小写再和后面作判断
         **/
        else if ("VOCATION".equalsIgnoreCase(programmer.getStatus().getNAME())){
            throw new TeamException("该员工正在休假，无法添加");
        }

        /**
         *  团队中至多只能有一名架构师
         *  团队中至多只能有两名设计师
         *  团队中至多只能有三名程序员
         *  获取team已有成员中架构师，设计师，程序员的人数
         **/
        int numOfArch = 0, numOfDes = 0, numOfPro = 0;
        for (int i = 0; i<total;i++){
            if (team[i] instanceof Architect){
                numOfArch++;
            }else if (team[i] instanceof Designer){
                numOfDes++;
            }else if (team[i] instanceof Programmer){
                numOfPro++;
            }
        }
        if (programmer instanceof Architect){
            if (numOfArch >= 1){
                throw new TeamException("团队中至多只能有一名架构师");
            }
        }else if (programmer instanceof Designer){
            if (numOfDes >= 2){
                throw new TeamException("团队中至多只能有两名设计师");
            }
        }else if (programmer instanceof Programmer){
            if (numOfPro >= 3){
                throw new TeamException("团队中至多只能有三名程序员");
            }
        }

        /**
         *  将programmer添加到现有的team中
         **/
        team[total++] = programmer;
        /**
         *  programmer的属性赋值
         **/
        programmer.setStatus(Status.BUSY);
        programmer.setMemberId(counter++);

    }

    /**
     * 判断指定的员工是否已经存在于现有的开发团队之中
     **/
    private boolean isExist(Employee employee) {
        for (int i = 0; i < total ;i++){
            if (team[i].getId() == employee.getId()){
                return true;
            }
        }
        return false;
    }

    public void removeMember(int memberId) throws TeamException {
        int i = 0;
        for ( ; i < total;i++){
            if (team[i].getMemberId() == memberId){
                team[i].setStatus(Status.FREE);
                break;
            }
            //后一个元素覆盖到前一个元素，实现删除操作
            for (int j = i+1; j < total; j++){
                team[j - 1] = team[j];
            }
            //写法一：
            //team[total - 1] = null;
            //total--;
            //或  写法二：
            team[--total] = null;

            //为找到指定memberId的情况
            if (i == total){
                throw new TeamException("找不到指定memberId的员工，删除失败！");
            }
        }
    }
}
