package com.alexzit.project03.domain;

/**
 * @author Alex
 * @create 2021-09-02 21:17
 */
public class PC implements Equipment
{
    private String model;//机器型号
    private String diaplay;//显示器名称

    public PC()
    {
    }

    public PC(String model, String diaplay)
    {
        this.model = model;
        this.diaplay = diaplay;
    }

    @Override
    public String getDescription()
    {
        return model + '(' + diaplay + ')';
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public String getDiaplay()
    {
        return diaplay;
    }

    public void setDiaplay(String diaplay)
    {
        this.diaplay = diaplay;
    }
}
