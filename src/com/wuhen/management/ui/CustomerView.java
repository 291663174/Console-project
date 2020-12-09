package com.wuhen.management.ui;

import com.wuhen.management.bean.Customer;
import com.wuhen.management.service.CustomerList;
import com.wuhen.management.util.CmUtility;

/**
 * @Author Wuhen
 * @Description CustomerView为主模块，负责菜单的显示和处理用户操作
 * @Date 2020/8/31
 **/
public class CustomerView {
    CustomerList customerList = new CustomerList(10);

    public CustomerView() {
        Customer customer = new Customer("张三", '男', 19, "13625232653", "zs@gmail.com");
        customerList.addCustomer(customer);
    }

    /**
     * 显示《客户信息管理软件》界面的方法
     **/
    public void enterMainMenu() {

        boolean isFlag = true;
        while (isFlag) {
            System.out.println("\n---------客户信息管理软件---------");
            System.out.println("\t\t  1 添 加 客 户");
            System.out.println("\t\t  2 修 改 客 户");
            System.out.println("\t\t  3 删 除 客 户");
            System.out.println("\t\t  4 客 户 列 表");
            System.out.println("\t\t  5 退    出 ");
            System.out.print("  请选择（1-5）:");

            char menu = CmUtility.readMenuSelection();
            switch (menu) {
                case '1':
                    addNewCustonmer();
                    break;
                case '2':
                    modifyCustonmer();
                    break;
                case '3':
                    deleteCustonmer();
                    break;
                case '4':
                    listAllCustonmer();
                    break;
                case '5':
                    System.out.print("确认是否退出（Y/N）");
                    char isExit = CmUtility.readConfirmSelection();
                    if (isExit == 'Y') {
                        isFlag = false;
                    }
                    //break;
                default:
                    break;
            }
        }
    }

    /**
     * 添加客户的操作
     **/
    private void addNewCustonmer() {
        System.out.println("------------添加客户------------");
        System.out.print("姓名:");
        String name = CmUtility.readString(10);
        System.out.print("性别：");
        char gender = CmUtility.readChar();
        System.out.print("年龄：");
        int age = CmUtility.readInt();
        System.out.print("电话：");
        String phone = CmUtility.readString(13);
        System.out.print("邮箱：");
        String email = CmUtility.readString(30);

        //将上述对象封装到对象中
        Customer customer = new Customer(name, gender, age, phone, email);
        boolean isSuccess = customerList.addCustomer(customer);
        if (isSuccess) {
            System.out.println("------------------添加完成------------------");
        } else {
            System.out.println("------------客户人数已满，添加失败------------");
        }
    }

    /**
     * 修改客户的操作
     **/
    private void modifyCustonmer() {
        System.out.println("------------------修改客户------------------");
        Customer cust;
        int number;
        for (; ; ) {
            System.out.print("请选择待修改的客户编号（-1）：");
            number = CmUtility.readInt();
            if (number == -1) {
                return;
            }
            cust = customerList.getCustomer(number - 1);
            if (cust == null) {
                System.out.println("无法找到指定的客户！");
            } else {//找到了相应编号的客户
                break;
            }
        }
        //修改客户信息
        System.out.print("姓名(" + cust.getName() + ")");
        String name = CmUtility.readString(10, cust.getName());
        System.out.print("性别(" + cust.getGender() + ")");
        char gender = CmUtility.readChar(cust.getGender());
        System.out.print("年龄(" + cust.getAge() + ")");
        int age = CmUtility.readInt(cust.getAge());
        System.out.print("电话(" + cust.getPhonenumber() + ")");
        String phonenumber = CmUtility.readString(13, cust.getPhonenumber());
        System.out.print("邮箱(" + cust.getEmail() + ")");
        String email = CmUtility.readString(30, cust.getEmail());
        Customer newCust = new Customer(name, gender, age, phonenumber, email);
        boolean isReplaced = customerList.replaceCustomer(number - 1, newCust);
        if (isReplaced) {
            System.out.println("------------------修改成功------------------");
        } else {
            System.out.println("------------------修改失败------------------");
        }
    }

    /**
     * 删除客户的操作
     **/
    private void deleteCustonmer() {
        System.out.println("------------------删除客户------------------");
        int number;
        //不知要循环多少次
        for (; ; ) {
            System.out.print("请选择待删除的客户编号（-1退出）：");
            number = CmUtility.readInt();
            if (number == -1) {
                return;
            }
            Customer customer = customerList.getCustomer(number - 1);
            if (customer == null) {
                System.out.println("无法找到指定客户！");
            } else {
                break;
            }
        }
        //找到了指定客户
        System.out.print("是否确认要删除（Y/N）:");
        char isDelete = CmUtility.readConfirmSelection();
        if (isDelete == 'Y') {
            boolean isDeleted = customerList.deleteCustomer(number - 1);
            if (isDeleted) {
                System.out.println("------------------删除完成------------------");
            } else {
                System.out.println("------------------删除失败------------------");
            }
        } else {
            return;
        }
    }

    /**
     * 显示客户列表的操作
     **/
    private void listAllCustonmer() {
        System.out.println("------------客户列表------------");

        int total = customerList.getTotal();
        if (total == 0) {
            System.out.println("没有客户记录！");
        } else {
            System.out.println("编号\t姓名\t性别\t年龄\t电话\t\t\t邮箱");
            Customer[] custs = customerList.getAllCustomer();
            for (int i = 0; i < custs.length; i++) {
                Customer cust = custs[i];
                System.out.println((i + 1) + "\t\t" + cust.getName()
                        + "\t" + cust.getGender() + "\t\t" + cust.getAge()
                        + "\t\t" + cust.getPhonenumber() + "\t\t4" + cust.getEmail());
            }
        }

        System.out.println("----------客户列表显示完全----------");
    }

    public static void main(String[] args) {
        CustomerView customerView = new CustomerView();
        customerView.enterMainMenu();
    }
}