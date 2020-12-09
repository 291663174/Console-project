package com.wuhen.view;

import com.wuhen.domain.Employee;
import com.wuhen.domain.Programmer;
import com.wuhen.service.NameListService;
import com.wuhen.service.TeamException;
import com.wuhen.service.TeamService;

/**
 * @author Wuhen
 * @Description
 * @date 2020-09-14 15:44
 **/
public class TeamView {

    private NameListService nameListService = new NameListService();
    private TeamService teamService = new TeamService();

    public void enterMainMenu() {

        boolean loopFlag = true;
        char menu = 0;

        while (loopFlag) {
            if (menu != '1') {
                listAllEmployee();
            }
            System.out.print("1-团队列表  2-添加团队成员  3-删除团队成员  4-退出  请选择（1-4）：");
            menu = TSUtility.readMenuSelection();
            switch (menu) {
                case '1':
                    getTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
                    System.out.println("确认是否退出(Y/N):");
                    char isExit = TSUtility.readConfirmSelection();
                    if (isExit == 'Y'){
                        loopFlag = false;
                    }
                    break;
                default:
            }
        }
    }

    /**
     * 显示所有的员工信息
     **/
    private void listAllEmployee() {
        System.out.println("-----------------开发团队调度软件-----------------");
        Employee[] employees = nameListService.getAllEmployees();
        if (employees == null || employees.length == 0){
            System.out.println("公司中没有任何员工信息 ");
        }else{
            System.out.println("ID\t\t姓名\t\t年龄\t工资\t\t职位\t\t状态\t\t奖金\t\t股票\t\t领用设备");
            for (int i = 0; i < employees.length;i++){
                System.out.println(employees[i]);
            }
        }
    }

    private void getTeam() {
        System.out.print("-----------------团队成员列表-----------------\n");

        Programmer[] team = teamService.getTeam();
        if (team == null || team.length == 0){
            System.out.println("开发团队目前没有成员！");
        }else {
            System.out.print("TID/ID\t\t姓名\t\t年龄\t工资\t\t职位\t\t奖金\t\t股票\n");
            for (int i = 0; i<team.length;i++){
                System.out.println(team[i].getDetailsForTeam());
            }
        }
        System.out.println("----------------------------------------------");

    }

    private void addMember(){
        System.out.print("--------------------添加成员-------------------\n");
        System.out.print("请输入要添加的员工ID：");
        int id = TSUtility.readInt();
        Employee emp = null;
        try {
            emp = nameListService.getEmployee(id);
            teamService.addMember(emp);
            System.out.println("添加成功");
        } catch (TeamException e) {
            System.out.println("添加失败，原因：" + e.getMessage());
        }
        //按回车键继续
        TSUtility.readReturn();
    }

    private void deleteMember() {
        //System.out.println("删除团队成员");
        System.out.print("--------------------删除成员-------------------\n");
        System.out.print("请输入要删除员工的TID:");
        int memberId = TSUtility.readInt();
        System.out.print("确认是否删除（Y/N）");
        char isDelete = TSUtility.readConfirmSelection();
        if (isDelete == 'N'){
            return;
        }
        try {
            teamService.removeMember(memberId);
            System.out.println("删除成功");
        } catch (TeamException e) {
            System.out.println("删除失败，原因：" + e.getMessage());;
        }
        //按回车键继续
        TSUtility.readReturn();
    }

    public static void main(String[] args) {
        TeamView teamView = new TeamView();
        teamView.enterMainMenu();
    }
}
