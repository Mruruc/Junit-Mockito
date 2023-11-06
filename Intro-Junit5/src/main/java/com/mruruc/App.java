package com.mruruc;


import com.mruruc.entity.Contact;
import com.mruruc.services.ContactManager;
import com.mruruc.validations.PhoneValidations;
import com.mruruc.validations.Validator;

import java.util.List;

public class App {
    public static void main(String[] args) {
      String test="okkl ";

//        for (int i = 0; i < test.length(); i++) {
//            if(Character.isWhitespace(test.charAt(i))){
//                System.out.println( "yes at"+ i);
//                return;
//            }
//        }

//        boolean whitespace = Character.isWhitespace(' ');
//
//        System.out.println(whitespace);
//
//        System.out.println("Test");

//        String test2="Hello \n I am Omer     \t  How are you   \n ";
//
//        System.out.println(test2);
//        System.out.println(test2.length());
//        System.out.println(test2.replaceAll("\\s","").length());

    //   Validator validator=new PhoneValidations();

//        Contact contact=new Contact("John Doe","+48 752785355");
//        System.out.println( validator.isBlank(contact.getFullName()));
//        System.out.println(validator.lengthWithoutSpaces(contact.getPhone()));
//        System.out.println("=============");
//        System.out.println(validator.countryCodeValidation(contact.getPhone(),"+4   6  "));

        Contact contact=new Contact("John Doe","+48725423125");
        Contact contact2=new Contact("Jane Doe","+48725423125");
        Contact contact3=new Contact("Bob Aley","+48725423125");

        ContactManager contactManager=new ContactManager();

        contactManager.addContact(contact);
        contactManager.addContact(contact2);
        contactManager.addContact(contact3);

        List<Contact> contacts = contactManager.getContacts();

        for(Contact c: contacts){
            System.out.println(c);
        }
        System.out.println("=========================");
        contactManager.removeContact(contact2);
     //   contactManager.removeContact("Bob Aley");

        for(Contact c: contacts){
            System.out.println(c);
        }

    }
}
