package com.alexzit.project03.domain;

/**
 * @author Alex
 * @create 2021-09-02 21:56
 */
public class Architect extends Designer
{
    private int stock;//股票

    public Architect()
    {
    }

    public Architect(int id, String name, int age, double salary, double bonus, int stock)
    {
        super(id, name, age, salary, bonus);
        this.stock = stock;
    }

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock)
    {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    public int getStock()
    {
        return stock;
    }

    public void setStock(int stock)
    {
        this.stock = stock;
    }

    public String toString()
    {
        return super.getDetails() + "\t\t架构师\t" + getStatus() + "\t" + getBonus() + "\t" + stock + "\t" + getEquipment().getDescription();
    }

    public String getDetailsForTeam()
    {
        return getBaseDetails() + "\t" + "架构师" + "\t" + getBonus() + "\t" + stock;
    }
}
