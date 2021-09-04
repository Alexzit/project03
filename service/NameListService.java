package com.alexzit.project03.service;

import com.alexzit.project03.domain.*;
import static com.alexzit.project03.service.Data.*;

/**
 * 负责将Date中的数据封装到Employee[]数组中,并提供相关操作Employee[]的方法。
 *
 * @author Alex
 * @create 2021-09-02 21:59
 */
public class NameListService
{
    private Employee[] employees;

    /**
     * 给employees及数组元素进行初始化
     */
    public NameListService()
    {
        employees = new Employee[EMPLOYEES.length];
        for(int i = 0; i < employees.length; i++)
        {
            int type = Integer.parseInt(EMPLOYEES[i][0]);
            //获取Employee4个基本信息
            int id = Integer.parseInt(EMPLOYEES[i][1]);
            String name = EMPLOYEES[i][2];
            int age = Integer.parseInt(EMPLOYEES[i][3]);
            double salary = Double.parseDouble(EMPLOYEES[i][4]);
            Equipment equipment;
            double bonus;
            int stock;
            switch(type)
            {
                case EMPLOYEE:
                    employees[i] = new Employee(id, name, age, salary);
                    break;
                case PROGRAMMER:
                    equipment = createEquipment(i);
                    employees[i] = new Programmer(id, name, age, salary, equipment);
                    break;
                case DESIGNER:
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    employees[i] = new Designer(id, name, age, salary, equipment, bonus);
                    break;
                case ARCHITECT:
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    stock = Integer.parseInt(EMPLOYEES[i][6]);
                    employees[i] = new Architect(id, name, age, salary, equipment, bonus, stock);
            }
        }
    }

    /**
     * 获取指定位置上的员工设备
     *
     * @param i
     * @return
     */
    private Equipment createEquipment(int i)
    {
        int type = Integer.parseInt(EQUIPMENTS[i][0]);
        String model = EQUIPMENTS[i][1];
        switch(type)
        {
            case PC:
                return new PC(model, EQUIPMENTS[i][2]);
            case NOTEBOOK:
                double price = Double.parseDouble(EQUIPMENTS[i][2]);
                return new NoteBook(model, price);
            case PRINTER:
                return new Printer(model, EQUIPMENTS[i][2]);
        }
        return null;
    }

    public Employee[] getAllEmployees()
    {
        return employees;
    }

    public Employee getEmployees(int id) throws TeamException
    {
        for(int i = 0; i < employees.length; i++)
        {
            if(employees[i].getId() == id)
            {
                return employees[i];
            }
        }

        throw new TeamException("找不到指定员工！");
    }
}
