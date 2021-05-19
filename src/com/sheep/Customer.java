package com.sheep;

public abstract class Customer
{

    protected String customername;
    protected float discount;
    public float price;


    abstract public void display();

    abstract public String getName();
    abstract public String returnName();

    abstract public float getDiscount();
    abstract public float returndiscount();




    public abstract String returnIsland();
    public abstract String returnCompany();
}
