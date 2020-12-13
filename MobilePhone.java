/*
******************************************************************************************
                    Console Based Mobile Phone
                      Akshay Munot SEITB207
******************************************************************************************
*/

import java.util.Scanner;

public class MobilePhone {
    private static Scanner scanner = new Scanner(System.in);    //creating Scanner class instance to take input
    private static ContactList contactList = new ContactList("9146901939");    //Store contacts in an arrayList
    private static Calculator numbers = new Calculator();    //Instance for calculator class
    private static TicTacToe Toe = new TicTacToe();    //Instance for TicTacToe class

    public static void main(String[] args) {

        boolean quit = false;   //Switch to turn phone on/off
        boolean closeCalculator = false;    //Open/close Calculator App
        boolean closeContact = false;    //Open/close Contact App
        startPhone();
        printActions();
        while(!quit) {
            System.out.println("\nEnter action: (4 to show available actions)");
            int action = scanner.nextInt();    //take input for action to be taken
            scanner.nextLine();


            switch (action) {
                case 0:    //shutting down the phone, hence terminating program
                    System.out.println("\nShutting down...");
                    quit = true;
                    break;

                case 1:    //case to use contact app
                    System.out.println("\nOpening Contacts App.....");
                    printContactActions();
                    while(!closeContact) {
                        System.out.println("\nEnter action: (6 to show available actions)");
                        int operation = scanner.nextInt();    //take input as to what action to be taken
                        scanner.nextLine();


                        switch (operation) {
                            case 0:    //case to closing the contact app, hence terminating case 1
                                System.out.println("\nClosing Contacts App...");
                                closeContact = true;
                                break;
                            case 1:    //case to print list of all the contacts available
                                contactList.printContacts();
                                break;

                            case 2:    // add new contact
                                addNewContact();
                                break;

                            case 3:    //update an existing contact
                                updateContact();
                                break;

                            case 4:    //deleting a contact
                                removeContact();
                                break;

                            case 5:    //checking if contact is present in the list
                                queryContact();
                                break;

                            case 6:    // printing all the actions that can be taken
                                printContactActions();
                                break;
                        }

                    }
                    break;
                case 2:    //case to use calculator app
                    System.out.println("\nOpening Calculator App.....");
                    printCalculatorActions();
                    while(!closeCalculator) {
                        System.out.println("\nEnter action: (6 to show available actions)");
                        int operation = scanner.nextInt();    //take input as to which operation to be performed
                        scanner.nextLine();

                        switch (operation) {
                            case 0:    // case to close calculator app, hence terminating the case 2
                                System.out.println("\nClosing Calculator App...");
                                closeCalculator = true;
                                break;
                            case 1:    // performing addition operation
                                numbers.Add();
                                break;

                            case 2:    // performing subtraction operation
                                numbers.Sub();
                                break;

                            case 3:    // performing multiplication operation
                                numbers.Multiply();
                                break;

                            case 4:    // performing division operation
                                numbers.Divide();
                                break;

                            case 5:    // performing remainder operation
                                numbers.Rem();
                                break;

                            case 6:    // printing all the actions that can be taken
                                printCalculatorActions();
                                break;
                        }

                    }
                    break;
                case 3:    //case to use tic tac toe app;
                    System.out.println("\nOpening Tic Tac Toe Game.....");
                    String ch;
                    do{
                        Toe.newBoard();    //initializing a game by creating new board
                        Toe.play();    //starting the game
                        System.out.println ("Would you like to play again? (Enter 'yes'/'no') ");
                        Scanner in =new Scanner(System.in);    //deciding whether to continue playing
                        ch=in.nextLine();
                        System.out.println("Input is  "+ch);    //displaying what the decision was
                    }while (ch.equals("yes"));
                case 4:    //printing all the actions that can be taken
                    printActions();
                    break;
            }

        }

    }

    //private methods to hide internal operations

    private static void addNewContact() {
        System.out.println("Enter new contact name: ");
        String name = scanner.nextLine();
        System.out.println("Enter phone number: ");
        String phone = scanner.nextLine();
        Contact newContact = Contact.createContact(name, phone);
        if(contactList.addNewContact(newContact)) {
            System.out.println("New contact added: name = " + name + ", phone = "+ phone);
        } else {
            System.out.println("Cannot add, " + name + " already on file");
        }
    }

    private static void updateContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContactRecord = contactList.queryContact(name);
        if(existingContactRecord == null) {
            System.out.println("Contact not found.");
            return;
        }

        System.out.print("Enter new contact name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter new contact phone number: ");
        String newNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(newName, newNumber);
        if(contactList.updateContact(existingContactRecord, newContact)) {
            System.out.println("Successfully updated record");
        } else {
            System.out.println("Error updating record.");
        }
    }

    private static void removeContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContactRecord = contactList.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found.");
            return;
        }

        if(contactList.removeContact(existingContactRecord)) {
            System.out.println("Successfully deleted");
        } else {
            System.out.println("Error deleting contact");
        }
    }

    private static void queryContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContactRecord = contactList.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found.");
            return;
        }

        System.out.println("Name: " + existingContactRecord.getName() + " phone number is " + existingContactRecord.getPhoneNumber());
    }

    private static void startPhone() {
        System.out.println("Starting phone...");
    }

    private static void printActions() {
        System.out.println("\nAvailable actions:\npress");
        System.out.println( "0  - to shutdown\n" +
                "1  - to open Contacts App\n" +
                "2  - to open Calculator App\n" +
                "3  - to open Tic Tac Toe Game\n");
    }

    private static void printCalculatorActions() {
        System.out.println("\nAvailable actions:\npress");
        System.out.println("1. Add\t2. Subtract\t3. Multiplication\t4. Divide\t5. Remainder\t6. Print Operations");
    }

    private static void printContactActions() {
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0  - to close Contacts App\n" +
                "1  - to print contacts\n" +
                "2  - to add a new contact\n" +
                "3  - to update existing an existing contact\n" +
                "4  - to remove an existing contact\n" +
                "5  - query if an existing contact exists\n" +
                "6  - to print a list of available actions.");
        System.out.println("Choose your action: ");
    }
}