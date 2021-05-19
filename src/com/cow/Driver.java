package com.cow;

import com.farm.Flight;

import java.util.Scanner;

public class Driver {

    public static void main(String[] args)
    {
        Scanner kboard = new Scanner(System.in);

        int choice = 0;

        Flight c1 = new Flight("A");
        Flight c2 = new Flight("B");

        do {
            System.out.println("Flight menu");
            System.out.println("1. Flight A, 2. Flight B, 3. Exit ");
            choice=kboard.nextInt();
            switch (choice)
            {
                case 1:
                    c1.menu();
                    break;

                case 2:
                    c2.menu();
                    break;
            }
        }while (choice!=3);

    }


}

