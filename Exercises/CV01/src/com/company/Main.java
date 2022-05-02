package com.company;

import java.util.Scanner;

public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";


    public static void main(String[] args) {

        System.out.printf("Type a number: ");
        boolean isPrime = true;

        var sc = new Scanner(System.in);
        boolean isNumber = sc.hasNextInt();

        if (isNumber){

            int number = sc.nextInt();
            System.out.printf("User input is: %d\n", number);

            for (int i=2; i<number; i++){
                if (number%i == 0){

                    System.out.println("The number is divisible by " + i);
                    isPrime = false;
                }

            }
            if (!isPrime){

                System.out.println("Number " + number + " is prime number: " + ANSI_RED + isPrime);

            }else {

                System.out.println("Number " + number + " is prime number: "+ ANSI_GREEN + isPrime);

            }
        }

    }
}
