package com.alexzit.project03.domain;

/**
 * @author Alex
 * @create 2021-09-02 21:21
 */
public class NoteBook implements Equipment
{
    private String model;//机器型号
    private doubel price;//价格

    public NoteBook()
    {
    }

    public NoteBook(String model, doubel price)
    {
        this.model = model;
        this.price = price;
    }


    @Override
    public String getDescription()
    {
        return model + '(' + price + ')';
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public doubel getPrice()
    {
        return price;
    }

    public void setPrice(doubel price)
    {
        this.price = price;
    }
}
