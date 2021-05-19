package com.sheep;


import java.util.Scanner;

public class IslandPassenger extends Customer {

    public String island;
  ;

    public IslandPassenger(String Iname, String Ilsland,float Idiscount) {
        customername = Iname;
        island= Ilsland;
        discount = Idiscount;


    }

    public IslandPassenger() {//run order
        customername = this.getName();
        island = this.getIsland();
        discount = this.getDiscount();
    }



    public void display() {
        System.out.print("Passenger name = "+customername+"\nThe resident island is "+island+" : Discount applied will be "+discount+"\n");
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
        return 0.1f;
    }

    public String getIsland() {
        Scanner kboard = new Scanner(System.in);
        String Ilsland;
        System.out.println("Please enter Island residence");
        Ilsland = kboard.nextLine();
        return Ilsland;
    }

    public String returnIsland()
    {
        return island;
    }

    @Override
    public String returnCompany() {
        return null;
    }

    public String returnName()
    {
        return(customername);
    }

    public float returndiscount() {
        return discount;
    }


}
