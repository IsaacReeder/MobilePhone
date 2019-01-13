package com.Isaac;

import java.util.ArrayList;

public class MobilePhone {

    private String myNumber;                    // create an option to store a phone number
    private ArrayList<Contact> myContacts;       // this accepts contacts instead of String like in previous projects
////

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();    // we need to initialize our ArrayList, normally you do that in the constructor. in this case were going to initialize it with an empty list
    }
////

    public boolean addNewContact(Contact contact) {  // true means it was not previously on file, false means it was. were not using a String and phone number here
        if(findContact(contact.getName()) >=0) {     // we are actually putting in a contact record, or contact object which has been created outside of this method
            System.out.println("Contact is already on file");    // line 16 tests to see whether the contact object is already on file
            return false;
        }

        myContacts.add(contact);    // if the contact is not already on file then this will add it to myContacts
        return true;
    }
////

    public boolean updateContact(Contact oldContact, Contact newContact) {    // this is fairly simple
        int foundPosition = findContact(oldContact);                          // this searches for and returns the position of the contact || -1 if it is not found and assigns it to foundPosition
        if(foundPosition <0) {                                                // if the integer returned is less than 0, it will sout and return false
            System.out.println(oldContact.getName()+", was not found.");
            return false;
        } else if (findContact(newContact.getName()) != -1){
            System.out.println("Contact with name " + newContact.getName() +
                    " already exists. Update was not successful.");
            return false;
        }

        this.myContacts.set(foundPosition, newContact);    //  this will replace the old contact with the new contact. and return true below
        System.out.println(oldContact.getName() + ", was replaced with " + newContact.getName());
        return true;
    }
////

    public boolean removeContact(Contact contact) {
        int foundPosition = findContact(contact);
        if (foundPosition < 0) {
            System.out.println(contact.getName() + ", was not found.");    // if not found it returns -1
            return false;
        }
        this.myContacts.remove(foundPosition);                      // if found, it is removed
        System.out.println(contact.getName() + ", was deleted");     // sout's a message
        return true;                                                  // and returns true
    }
////

    private int findContact(Contact contact) {
        return this.myContacts.indexOf(contact);    // so that's going to return an integer showing us what the element position is in the array for that particular object
    }                                               // the number it will return will be 0 or greater if it exists in the ArrayList, and a number less than zero if it doesn't exist
////

    private int findContact(String contactName) {    // loop through all records, extract the name out, compare to the name that's been passed and return the index position if its actually on file
        for(int i=0; i<this.myContacts.size(); i++) {
            Contact contact = this.myContacts.get(i);    // creating a new contact object thats basically the contact object thats in the array list
            if(contact.getName().equals(contactName)) {    // if the contact is found return its position
                return i;
            }
        }
        return -1;
    }
////

    public String queryContact(Contact contact) {    // this method checks to see if the contact is on file, grab the position it resides at and then return the name at that position
        if(findContact(contact) >=0 ) {
            return contact.getName();
        }
        return null;
    }

////

    public Contact queryContact(String name) {
        int position = findContact(name);
        if(position >=0) {
            return this.myContacts.get(position);
        }

        return null;
    }


    public void printContacts() {
        System.out.println("Contact List");
        for(int i=0; i<this.myContacts.size(); i++) {
            System.out.println((i+1) + "." +
                    this.myContacts.get(i).getName() + " -> " +
                    this.myContacts.get(i).getPhoneNumber());

        }
    }
}
