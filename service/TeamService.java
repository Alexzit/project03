package com.alexzit.project03.service;

import com.alexzit.project03.domain.Architect;
import com.alexzit.project03.domain.Designer;
import com.alexzit.project03.domain.Employee;
import com.alexzit.project03.domain.Programmer;

/**
 * 关于团队成员的管理：添加、删除等。
 *
 * @author Alex
 * @create 2021-09-03 22:42
 */
public class TeamService
{
    private static int counter = 1;//给memberId幅值使用
    private int MAX_MEMBER = 5;//限制开发团队的人数
    private Programmer[] team = new Programmer[MAX_MEMBER];//保存开发团队成员
    private int total;//记录开发团队实际的人数

    public TeamService()
    {

    }

    public Programmer[] getTeam()
    {
        Programmer[] team = new Programmer[total];
        for(int i = 0; i < team.length; i++)
        {
            team[i] = this.team[i];
        }
        return team;
    }

    public void addMember(Employee e) throws TeamException
    {
        if(total >= MAX_MEMBER)
        {
            throw new TeamException("成员已满，无法添加");
        }
        if(!(e instanceof Programmer))
        {
            throw new TeamException("该成员不是开发人员，无法添加");
        }
        if(isExist(e))
        {
            throw new TeamException("该成员已在本开发团队中");
        }
        Programmer p = (Programmer) e;//一定不会出现类型转换异常
        if("BUSY".equals(p.getStatus().getNAME()))
        {
            throw new TeamException("该成员已在开发团队中");
        }
        else if("VOCATION".equals(p.getStatus().getNAME()))
        {
            throw new TeamException("该成员正在休假，无法添加");
        }
        int numOfArch = 0, numOfDes = 0, nuOfPro = 0;
        for(int i = 0; i < total; i++)
        {
            if(team[i] instanceof Architect)
            {
                numOfArch++;
            }
            else if(team[i] instanceof Designer)
            {
                numOfDes++;
            }
            else
            {
                nuOfPro++;
            }
        }
        if(p instanceof Architect)
        {
            if(numOfArch >= 1)
            {
                throw new TeamException("团队中至多只能有一名架构师");
            }
            else if(p instanceof Designer)
            {
                if(numOfDes >= 2)
                {
                    throw new TeamException("团队中至多只能有两名设计师");
                }
            }
            else
            {
                if(nuOfPro >= 3)
                {
                    throw new TeamException("团队中至多只能有三名程序员");
                }
            }

        }
        team[total++] = p;
        p.setStatus(Status.BUSY);
        p.setMemberid(counter++);
    }

    /**
     * 判断指定的员工是否已经存在于现有的开发团队中
     *
     * @param e
     * @return
     */
    private boolean isExist(Employee e)
    {
        for(int i = 0; i < total; i++)
        {
            if(team[i].getId() == e.getId())
            {
                return true;
            }
        }
        return false;
    }

    /**
     * 从团队中删除成员
     *
     * @param memberID
     */
    public void removeMember(int memberID) throws TeamException
    {
        int i = 0;
        for(; i < total; i++)
        {
            if(team[i].getMemberid() == memberID)
            {
                team[i].setStatus(Status.FREE);
                break;
            }
        }
        if(i == total)
        {
            throw new TeamException("找不到指定memberId的员工，删除失败");
        }
        for(int j = i + 1; j < total; j++)
        {
            team[j - 1] = team[i];
        }
        team[--total] = null;


    }
}
