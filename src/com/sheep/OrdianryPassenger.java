package com.sheep;

import java.util.Scanner;

public class OrdianryPassenger extends Customer {



    public OrdianryPassenger(String Oname,float Odiscount) {
        customername = Oname;
        discount = Odiscount;

    }

    public OrdianryPassenger() {//run order
        customername = this.getName();
        discount = this.getDiscount();
    }


    public void display() {
        System.out.print("Passenger name = "+customername+": Discount applied will be "+discount+"\n");
    }


    public String getName()
    {
        Scanner kboard = new Scanner(System.in);
        String name;
        System.out.println("Please enter the full name of the customer");
        name = kboard.nextLine();

        return (name);
    }

    public float getDiscount() {
        int Choice;
        Scanner kboard = new Scanner(System.in);
        System.out.println("Is the customer eligible for the 5% discount 1.Yes 2.No ");
        Choice = kboard.nextInt();
        if (Choice == 1) {
            System.out.println("discount applied");
            return 0.05f;
        } else {
            System.out.println("discount will not be applied");
            return 0.0f;
        }
    }

    public String returnName()
    {
        return(customername);
    }

    public float returndiscount()
    {
        return(discount);
    }

    @Override
    public String returnIsland() {
        return null;
    }

    @Override
    public String returnCompany() {
        return null;
    }


}
