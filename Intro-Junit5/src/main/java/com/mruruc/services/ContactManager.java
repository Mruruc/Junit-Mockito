package com.mruruc.services;

import com.mruruc.db.Contacts;
import com.mruruc.entity.Contact;
import com.mruruc.validations.NameValidations;
import com.mruruc.validations.PhoneValidations;
import com.mruruc.validations.Validator;

import java.util.List;

public class ContactManager {
    private Validator validator;
    private Validator validator2;
    private Contacts contacts;


    public ContactManager(){
        validator=new PhoneValidations();
        validator2=new NameValidations();
        contacts=new Contacts();
    }


    public boolean addContact(Contact contact){
        //Validate Contact:
        if(validator.validateAll(contact.getPhone(),12,"+48")
                && validator2.validateAll(contact.getFullName())){
            contacts.addNewContact(contact);
            return true;
        }
        throw new RuntimeException("Invalid Input");
    }

    public boolean removeContact(Contact contact){
        if(contact == null){
            return false;
        }
        return contacts.removeContact(contact.getFullName());
    }
    public boolean removeContact(String name)  {
        if(name ==null ||name.trim().isEmpty()){
            return false;
        }
         boolean result=contacts.removeContact(name);
        if(result){
            return true;
        }
        else{
            throw new RuntimeException("Not Found");
        }
    }
    public List<Contact> getContacts(){
        return contacts.getListOfContact();
    }

}
