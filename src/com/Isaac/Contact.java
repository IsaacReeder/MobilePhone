package com.Isaac;

public class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {    // anytime you are using a contact record you don't use setters
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {                    // but we do use a constructor and getters so we can print out that info
        return phoneNumber;
    }

    public static Contact createContact(String name, String phoneNumber) {  // we need a public static method so that we can create a contact record
        return new Contact(name, phoneNumber);                              // and this will be very useful when we are accessing the functions that are built into mobile phone
    }                                                                       // instead of having to pass the parameter for the name and phone number,
}                                                                           // we can create a contact record with creating a seperate object.
