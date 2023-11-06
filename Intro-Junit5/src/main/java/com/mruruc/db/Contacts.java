package com.mruruc.db;

import com.mruruc.entity.Contact;

import java.util.*;

public class Contacts {
    private List<Contact> listOfContact;

    public Contacts(){
        this.listOfContact=new ArrayList<>();
    }

    public void addNewContact(Contact contact){
        listOfContact.add(contact);
    }


    public List<Contact> getListOfContact() {
        return listOfContact;
    }

    public boolean removeContact(String name){
        for (Contact c: listOfContact) {
            if(c.getFullName().equals(name)){
                listOfContact.remove(c);
                return true;
            }
        }
        return false;
    }
}
