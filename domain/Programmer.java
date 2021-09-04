package com.alexzit.project03.domain;

import com.alexzit.project03.service.Status;

/**
 * @author Alex
 * @create 2021-09-02 21:38
 */
public class Programmer extends Employee
{
    private int memberid;
    private Status status = Status.FREE;
    private Equipment equipment;

    public Programmer()
    {
    }

    public Programmer(int id, String name, int age, double salary)
    {
        super(id, name, age, salary);
    }

    public Programmer(int id, String name, int age, double salary, Equipment equipment)
    {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    public int getMemberid()
    {
        return memberid;
    }

    public void setMemberid(int memberid)
    {
        this.memberid = memberid;
    }

    public Status getStatus()
    {
        return status;
    }

    public void setStatus(Status status)
    {
        this.status = status;
    }

    public Equipment getEquipment()
    {
        return equipment;
    }

    public void setEquipment(Equipment equipment)
    {
        this.equipment = equipment;
    }

    @Override
    public String toString()
    {
        return super.toString() + "\t\t程序员\t" + status + "\t\t\t\t\t" + equipment.getDescription();
    }

    public String getBaseDetails()
    {
        return memberid + '/' + getId() + '\t' + getName() + "\t" + getAge() + "\t" + getSalary();
    }

    public String getDetailsForTeam()
    {
        return getBaseDetails() + "\t" + "程序员";
    }
}
