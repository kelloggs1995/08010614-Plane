package com.farm;


import com.sheep.BusinessPassenger;
import com.sheep.*;


import java.util.Scanner;

public class Seat {


    private int seatnos;
    private Customer occupier;
    private int status;
    private int type;//might not neea
    private float cost;
    private float price;
    private float takings;

    private boolean availibility=false;//test


    public Seat(int seatnos)
    {
        this.seatnos = seatnos;
        status=0;
        type=0;
        cost=100;
        price=0;
        takings=0;

        availibility=false;//test
    }

    public Seat() {
        this.bookSeat();
    }

    public void displayseat()
    {

        if (status==0)
        {

            System.out.println("\nSeat:"+seatnos+" = Empty");
        }
        else if (status==1)
        {
            price = cost - (cost * occupier.returndiscount());
            System.out.println("\nSeat:"+seatnos+" = Reserved ");
            occupier.display();
        }
        else
        {
            price = cost - (cost * occupier.returndiscount());
            System.out.println("\nSeat:"+seatnos+" Price of seat = "+price+" = Booked");
            occupier.display();

        }
    }

    public void bookSeat()
    {
        int passengerType=0;
        Scanner kboard = new Scanner(System.in);
        if (status==2)
        {
            System.out.println("Seat taken");
        }
        else if(status==0)
        {
            status=2;
            System.out.println("1. Ordianry Passenger, 2. Business Passenger, 3. Island Passenger");
            passengerType = kboard.nextInt();
            if (passengerType==1)
            {
                Customer ordianryPassenger = new OrdianryPassenger();
                occupier = ordianryPassenger;
                price = cost - (cost * occupier.returndiscount());
                type=1;
                availibility=true;
                displayseat();
            }
            if (passengerType==2)
            {
                Customer businessPassenger = new com.sheep.BusinessPassenger();
                occupier = businessPassenger;
                price = cost - (cost * occupier.returndiscount());
                type=2;
                availibility=true;
                displayseat();
            }
            if (passengerType==3)
            {
                Customer islandPassenger = new IslandPassenger();
                occupier = islandPassenger;
                price = cost - (cost * occupier.returndiscount());
                type=3;
                availibility=true;
                displayseat();
            }
        }
        else
        {
            System.out.print(" Please enter Name to check against database ");
            String name = kboard.nextLine();
            if(name==occupier.returnName())
            { System.out.println("Correct"); }
            else
            { System.out.println("Failed"); }
            status = 2;
           // price = cost-(cost*occupier.returndiscount());
        }
    }

    public void reserveSeat() {

        int passengerType=0;
        Scanner kboard = new Scanner(System.in);
        if (status != 0)//if not equal to zero unavailable if it is enter customers
        {
            System.out.println(" seat unavailable");//need to find fix why printing
        }
        else
        {
            status = 1;
            System.out.println("1. Ordianry Passenger, 2. Business Passenger, 3. Island Passenger");
            passengerType = kboard.nextInt();
            if (passengerType == 1) {

                Customer ordianryPassenger = new OrdianryPassenger();
                occupier = ordianryPassenger;
                displayseat();
            }
            if (passengerType == 2) {
                Customer businessPassenger = new BusinessPassenger();
                occupier = businessPassenger;
                displayseat();
            }
            if (passengerType == 3) {
                Customer islandPassenger = new IslandPassenger();
                occupier = islandPassenger;
                displayseat();
            }
        }
    }

    public void cancelSeat()
    {
        occupier = null;
        status = 0;
        price =0;
    }

    public float getTakings(){
        return takings;
    }




    /////////////RETURNS/////////////
    public String returnName()
    {
        return(occupier.returnName());
    }
    public String returnComapny(){
        return occupier.returnCompany();
    }
    public String returnIsland(){
        return occupier.returnIsland();
    }
    public int returnStatus()
    {
        return(status);
    }
    public int returnSeatnos()
    {
        return(seatnos);
    }
    public float returndiscount()
    {
        return(occupier.returndiscount());
    }
    public int returnType()
    {
        return(type);
    }
    public boolean returnAvalibility()
    {
        return availibility;
    }
    public float returnPrice(){
        return price;
    }
    /////////////////////////////////

    /////////////SETTERS/////////////
    public void setOccupier(Customer x)
    {
        occupier = x;
    }
    public void setStatus()
    {
        status = 2;
    }//might need to take out
    public void setType(int types)
    {
        type = types;
    }
    public void setAvalibility()
    {
        availibility = false;
    }
    /////////////////////////////////
}
