package com.bosch;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("07921 896543");

    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        printActions();
        while(!quit) {
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    printActions();
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    quit = true;
                    break;
            }
        }
    }

    public static void printActions() {
        System.out.println("\nPress");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print the list of contacts.");
        System.out.println("\t 2 - To add a contact.");
        System.out.println("\t 3 - To update an existing contact.");
        System.out.println("\t 4 - To remove a contact.");
        System.out.println("\t 5 - To search for a contact.");
        System.out.println("\t 6 - To quit the application.");
    }

    private static void addNewContact() {
        System.out.println("Enter new contact name: ");
        String name = scanner.nextLine();
        System.out.println("Enter telephone number: ");
        String phone = scanner.nextLine();
        Contact newContact = Contact.createContact(name, phone);
        if(mobilePhone.addContact(newContact)) {
            System.out.println("New contact added: name = " + name + " ,phone = " + phone);
        } else {
            System.out.println("Cannot add " + name + " already on file");
        }
    }

    private static void updateContact() {
        System.out.println("Enter exisitng contact name: ");
        String name = scanner.nextLine();
        Contact exisitngContact = mobilePhone.queryContact(name);
        if(exisitngContact == null) {
            System.out.println("Contact not found.");
            return;
        }
        System.out.println("Enter new contact name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter new contact phone number: ");
        String newNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(newName, newNumber);
        if(mobilePhone.updateContact(exisitngContact, newContact)) {
            System.out.println("Successfully updated record");
        } else {
            System.out.println("Error updating the record.");
        }

    }

    private static void removeContact() {
        System.out.println("Enter exisitng contact name: ");
        String name = scanner.nextLine();
        Contact exisitngContact = mobilePhone.queryContact(name);
        if(exisitngContact == null) {
            System.out.println("Contact not found.");
            return;
        }
        if(mobilePhone.removeContact(exisitngContact)) {
            System.out.println("Successfully deleted");
        } else {
            System.out.println("error deleting contact");
        };
    }

    private static void queryContact() {
        System.out.println("Enter exisitng contact name: ");
        String name = scanner.nextLine();
        Contact existingContact = mobilePhone.queryContact(name);
        if(existingContact == null) {
            System.out.println("Contact not found.");
            return;
        }

        System.out.println("Name: " + existingContact.getName() + " phone number is " + existingContact.getTelephoneNumber());

    }

}
