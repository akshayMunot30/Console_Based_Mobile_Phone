import java.util.Scanner;

public class Calculator {
    private static Scanner scanner = new Scanner(System.in);    //creating Scanner class instance to take input
    private double num1;
    private double num2;

    // Function to take 2 numbers as input
    public void input() {
        System.out.println("Enter 1st number: ");
        this.num1 = scanner.nextDouble();
        System.out.println("Enter 2nd number: ");
        this.num2 = scanner.nextDouble();
    }

    // Function to add
    public void Add() {
        input();
        System.out.print("The result is: " + (num1 + num2));
    }

    // Function to subtract
    public void Sub() {
        input();
        System.out.print("The result is: " + (num1 - num2));
    }

    // Function to multiply
    public void Multiply() {
        input();
        System.out.print("The result is: " + (num1 * num2));
    }

    // Function to divide
    public void Divide() {
        input();
        System.out.print("The result is: " + (num1 / num2));
    }

    // Function to get the remainder of a division
    public void Rem() {
        input();
        System.out.print("The result is: " + (num1 % num2));
    }
}



