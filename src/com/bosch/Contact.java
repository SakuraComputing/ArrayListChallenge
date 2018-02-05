package com.bosch;

public class Contact {

    private String name;
    private String telephoneNumber;

    public Contact(String name, String telephoneNumber) {
        this.name = name;
        this.telephoneNumber = telephoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public static Contact createContact(String name, String telephoneNumber) {
        return new Contact(name, telephoneNumber);
    }



}
