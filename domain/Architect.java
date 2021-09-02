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

    public Architect(int id, String name, int age, double salary, privte equipment, double bonus, int stock)
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
}
