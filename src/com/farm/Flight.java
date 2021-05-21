package com.farm;

import com.cow.LKSQLConnection;
import com.sheep.Customer;
import com.sheep.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Flight {

    private final int nosSeats = 8;
    private String planenos;
    private Seat seats[] = new Seat[nosSeats];
    private boolean availibility=false;


    public Flight(String nos) {

        planenos = nos;

        Seat S1 = new Seat(1);
        Seat S2 = new Seat(2);
        Seat S3 = new Seat(3);
        Seat S4 = new Seat(4);
        Seat S5 = new Seat(5);
        Seat S6 = new Seat(6);
        Seat S7 = new Seat(7);
        Seat S8 = new Seat(8);

        seats[0] = S1;
        seats[1] = S2;
        seats[2] = S3;
        seats[3] = S4;
        seats[4] = S5;
        seats[5] = S6;
        seats[6] = S7;
        seats[7] = S8;

    }



    public void displayFlight() {
        System.out.print("Details for Flight " + planenos+"\n");
        for (int i = 0; i < 8; i++) {
            seats[i].displayseat();
        }
    }

    public void bookseat()
    {
        int seatnos;
        Scanner kboard = new Scanner(System.in);
        System.out.println("Please enter seat number (1-"+nosSeats+")");
        seatnos=kboard.nextInt();
        seats[seatnos-1].bookSeat();
    }

    public void reserveseat()
    {
        int seatnos;
        Scanner kboard = new Scanner(System.in);
        System.out.println("Please enter seat number (1-"+nosSeats+")");
        seatnos=kboard.nextInt();
        seats[seatnos-1].reserveSeat();
    }

    public void cancelseat() {
        int seatnos;
        Scanner kboard = new Scanner(System.in);
        System.out.println("Please enter seat number (1-" + nosSeats + ")");
        seatnos = kboard.nextInt();
        seats[seatnos - 1].cancelSeat();
        System.out.println("Seat Cancelled");
    }

    public void deleteBookings() {
        ResultSet rs = null;
        Connection connection = null;
        Statement statement = null;
        String query = "";
        query = "delete from realplane where planenos = '" + planenos + "'";
        try {
            connection = LKSQLConnection.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("File has been cleared");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveFile()
    {
        ResultSet rs = null;
        Connection connection = null;
        Statement statement = null;
        String query="";

        this.deleteBookings();

        for (int x=0;x<nosSeats;x++)
        {
            if (seats[x].returnStatus()==0)
            {
                query = "insert into realplane(planenos,seatnos,status) values ('"+planenos+"',"+seats[x].returnSeatnos()+","+seats[x].returnStatus()+")";
            }//end if
            else
            {
                if (seats[x].returnType()==1) //transfers info if 2nd class or 1st class
                {
                    query = "insert into realplane(planenos,seatnos,status,availibility,passengertype,passengername,discount) values ('"+planenos+"',"+seats[x].returnSeatnos()+","+seats[x].returnStatus()+","+seats[x].returnAvalibility()+","+1+",'"+seats[x].returnName()+"','"+seats[x].returndiscount()+"')";
                }
                else if (seats[x].returnType()==2)
                {
                    query = "insert into realplane(planenos,seatnos,status,availibility,passengertype,passengername,passengercompany,discount) values ('"+planenos+"',"+seats[x].returnSeatnos()+","+seats[x].returnStatus()+","+seats[x].returnAvalibility()+","+2+",'"+seats[x].returnName()+"','"+seats[x].returnComapny()+"','"+seats[x].returndiscount()+"')";
                }
                else
                {
                    query = "insert into realplane(planenos,seatnos,status,availibility,passengertype,passengername,passengerisland,discount) values ('"+planenos+"',"+seats[x].returnSeatnos()+","+seats[x].returnStatus()+","+seats[x].returnAvalibility()+","+3+",'"+seats[x].returnName()+"','"+seats[x].returnIsland()+"','"+seats[x].returndiscount()+"')";
                }
            }
            try {
                connection = LKSQLConnection.getConnection();
                statement = connection.createStatement();
                statement.executeUpdate(query);
                System.out.println("Added seat"+seats[x].returnSeatnos());
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }//end for
    }

    public void retrieveFile()
    {
        ResultSet rs = null;
        Connection connection = null;
        Statement statement = null;
        String query="";
        int loopcounter = 0;

        query = "select * from realplane where planenos = '"+planenos+"'";

        try {
            connection = LKSQLConnection.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

            while (rs.next())
            {
                if (rs.getInt("status")==0)
                {
                   //System.out.println("test0"); to check if was entering same with the rest below
                }
                else
                {
                    if (rs.getInt("passengertype")==1)
                    {
                        //System.out.println("test1");
                        Customer ordianryPassenger = new OrdianryPassenger(rs.getString("passengername"),rs.getFloat("discount"));
                        seats[rs.getInt("seatnos")-1].setOccupier(ordianryPassenger);
                        seats[rs.getInt("seatnos")-1].setType(1);
                        seats[rs.getInt("seatnos")-1].setStatus();
                    }
                    if (rs.getInt("passengertype")==2)
                    {
                        //System.out.println("test2");
                        Customer businessPassenger = new BusinessPassenger(rs.getString("passengername"),rs.getString("passengercompany"),rs.getFloat("discount"));
                        seats[rs.getInt("seatnos")-1].setOccupier(businessPassenger);
                        seats[rs.getInt("seatnos")-1].setType(2);
                        seats[rs.getInt("seatnos")-1].setStatus();
                    }
                    if (rs.getInt("passengertype")==3)
                    {
                        //System.out.println("test3");
                        Customer islandPassenger = new IslandPassenger(rs.getString("passengername"),rs.getString("passengerisland"),rs.getFloat("discount"));
                        seats[rs.getInt("seatnos")-1].setOccupier(islandPassenger);
                        seats[rs.getInt("seatnos")-1].setType(3);
                        seats[rs.getInt("seatnos")-1].setStatus();
                    }
                }
            }
            System.out.println("File Retrieved");
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }



    public void bookingmenu()
    {
        int choice=0;
        Scanner kboard = new Scanner(System.in);
        this.retrieveFile();
        System.out.println("\n1. Reserve seat, 2. Book Seat, 3. Cancel seat, 4. Return to Main menu");
        choice = kboard.nextInt();
        while (choice != 4)
        {
            switch(choice)
            {
                case 1: this.reserveseat();     break;
                case 2: this.bookseat(); 		break;
                case 3: this.cancelseat();		break;

            }
            System.out.println("\n1. Reserve seat, 2. Book Seat, 3. Cancel seat, 4. Return to Main menu");
            choice = kboard.nextInt();
        }
    } // end method

    public void mainmenu()
    {
        int choice=0;
        Scanner kboard = new Scanner(System.in);
        this.retrieveFile();
        System.out.println("\n1. Flight Admin, 2. Display Flight details, 3. Booking menu, 4. Return to Flight choice");
        choice = kboard.nextInt();
        while (choice !=4)
        {
            switch(choice)
            {
                //case 1: this.FlightAdmin();   break;
                case 2: this.displayFlight();	break;
                case 3: this.bookingmenu();     break;
            }
            System.out.println("\n1. Flight Admin, 2. Display Flight details, 3. Booking menu, 4. Return to Flight choice");
            choice = kboard.nextInt();
        }
        this.saveFile();
    } // end method


}
