package com.alexzit.project03.domain;

import com.alexzit.project03.service.Status;

/**
 * @author Alex
 * @create 2021-09-02 21:38
 */
public class Programmer extends Employee
{
    private int memberid;
    private Status status;
    privte Equipment equipment;

    public Programmer()
    {
    }

    public Programmer(int id, String name, int age, double salary)
    {
        super(id, name, age, salary);
    }

    public Programmer(int id, String name, int age, double salary, privte equipment)
    {
        super(id, name, age, salary);
        Equipment = equipment;
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

    public privte getEquipment()
    {
        return Equipment;
    }

    public void setEquipment(privte equipment)
    {
        Equipment = equipment;
    }
}
