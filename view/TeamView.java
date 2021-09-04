package com.alexzit.project03.view;

import com.alexzit.project03.domain.Employee;
import com.alexzit.project03.domain.Programmer;
import com.alexzit.project03.service.NameListService;
import com.alexzit.project03.service.TeamException;
import com.alexzit.project03.service.TeamService;

/**
 * @author Alex
 * @create 2021-09-04 21:31
 */
public class TeamView
{
    private NameListService listSvc = new NameListService();
    private TeamService teamSvc = new TeamService();

    public void enterMainMenu()
    {
        boolean loopFlag = true;
        char menu = 0;
        while(loopFlag)
        {
            if(menu != '1')
            {
                listAllEmployees();
            }
            System.out.println("1-团队列表 2-添加团队成员 3-删除团队成员 4-退出 请选择（1-4）：");
            menu = TSUtility.readMenuSelection();
            switch(menu)
            {
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
                    System.out.println("是否要退出（Y/N）:");
                    char isExit = TSUtility.readConfirmSelection();
                    if(isExit == 'Y')
                    {
                        loopFlag = false;
                    }
                    break;
            }
        }

    }

    private void listAllEmployees()
    {
        System.out.println("---------------------开发团队调度软件---------------------");
        Employee[] employees = listSvc.getAllEmployees();
        System.out.println("ID\t\t姓名\t\t\t年龄\t\t工资\t\t\t职位\t\t状态\t\t奖金\t\t股票\t\t领用设备");
        for(int i = 0; i < employees.length; i++)
        {
            System.out.println(employees[i]);
        }
        System.out.println("-------------------------------------------------------");

    }

    private void getTeam()
    {
        System.out.println("---------------------开发团队成员列表---------------------\n");
        Programmer[] team = teamSvc.getTeam();
        if(team == null || team.length == 0)
        {
            System.out.println("开发团队目前没有成员！");
        }
        else
        {
            System.out.println("ID\t\t姓名\t\t\t年龄\t\t工资\t\t\t职位\t\t状态\t\t奖金\t\t股票\t\t领用设备");
            for(int i = 0; i < team.length; i++)
            {
                System.out.println(team[i].getDetailsForTeam());
            }
        }
        System.out.println("-------------------------------------------------------");

    }

    private void addMember()
    {
        System.out.println("---------------------添加成员---------------------\n");
        System.out.println("请输入添加的员工ID：");
        int id = TSUtility.readInt();
        Employee employees = null;
        try
        {
            employees = listSvc.getEmployees(id);
            teamSvc.addMember(employees);
            System.out.println("添加成功！");
            TSUtility.readReturn();
        } catch(TeamException e)
        {
            System.out.println("添加失败，原因：" + e.getMessage());
        }
    }

    private void deleteMember()
    {
        System.out.println("---------------------删除成员---------------------\n");
        System.out.println("请输入删除的员工ID：");
        int id = TSUtility.readInt();
        System.out.println("请输入是否删除（Y/N）");
        char isDelete = TSUtility.readConfirmSelection();
        if(isDelete == 'N')
        {
            return;
        }
        try
        {
            teamSvc.removeMember(id);
        } catch(TeamException e)
        {
            System.out.println("删除失败，原因：" + e.getMessage());
        }
    }

    public static void main(String[] args)
    {
        TeamView view = new TeamView();
        view.enterMainMenu();

    }
}