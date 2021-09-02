package com.alexzit.project03.domain;

/**
 * @author Alex
 * @create 2021-09-02 21:53
 */
public class Designer extends Programmer
{
    private double bonus;//奖金

    public Designer()
    {
    }

    public Designer(int id, String name, int age, double salary, double bonus)
    {
        super(id, name, age, salary);
        this.bonus = bonus;
    }

    public Designer(int id, String name, int age, double salary, privte equipment, double bonus)
    {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    public double getBonus()
    {
        return bonus;
    }

    public void setBonus(double bonus)
    {
        this.bonus = bonus;
    }
}
