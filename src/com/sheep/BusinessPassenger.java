package com.sheep;

import java.util.Scanner;

public class BusinessPassenger extends Customer {

    public String company;


    public BusinessPassenger(String Iname, String Bcompany,float Bdiscount) {
        customername = Iname;
        company = Bcompany;
        discount = Bdiscount;

    }

    public BusinessPassenger() {//run order
        customername = this.getName();
        company = this.getCompany();
        discount = this.getDiscount();

    }



    public void display() {
        System.out.print("Passenger name = "+customername+"\nCompany name = "+company+" : Discount applied will be "+discount+"\n");
    }

    public String getName()
    {
        Scanner kboard = new Scanner(System.in);
        String name;
        System.out.println("Please enter the full name of the customer");
        name = kboard.nextLine();
        return (name);
    }

    public String getCompany() {
        Scanner kboard = new Scanner(System.in);
        String Bcompany;
        System.out.println("Please enter company that "+customername+" is associated with.");
        Bcompany = kboard.nextLine();
        return Bcompany;
    }


    public String returnName()
    {
        return(customername);
    }


    @Override
    public float getDiscount() {
        return 0.25f;

    }


    @Override
    public float returndiscount() {
        return discount;
    }

    @Override
    public String returnIsland() {
        return null;
    }

    @Override
    public String returnCompany() {
        return company;
    }


}
