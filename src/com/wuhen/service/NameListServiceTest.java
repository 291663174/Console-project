package com.wuhen.service;

import com.wuhen.domain.Employee;
import org.junit.Test;

/**
 * @Author Wuhen
 * @Description
 * @Date 2020/9/13
 **/
public class NameListServiceTest {

    @Test
    public void testGetAllEmployees(){
        NameListService service = new NameListService();
        Employee[] employees = service.getAllEmployees();
        for (int i = 0; i<employees.length;i++){
            System.out.println(employees[i]);
        }
    }

    @Test
    public void testGetEmployee(){
        NameListService service = new NameListService();
        int id = 1;
        id = 9;
        try {
            Employee employee = service.getEmployee(id);
            System.out.println(employee);
        } catch (TeamException e) {
            e.printStackTrace();
        }
    }

}
