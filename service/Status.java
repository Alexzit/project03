package com.alexzit.project03.service;

/**
 * 员工状态
 * @author Alex
 * @create 2021-09-02 21:43
 */
public class Status
{
    private final String NAME;
    private Status(String name)
    {
        this.NAME = name;
    }

    public static final Status FREE = new Status("FREE");
    public static final Status BUSY = new Status("BUSY");
    public static final Status VOCATION = new Status("VOCATION");

    public String getNAME()
    {
        return NAME;
    }

    @Override
    public String toString()
    {
        return NAME;
    }
}
