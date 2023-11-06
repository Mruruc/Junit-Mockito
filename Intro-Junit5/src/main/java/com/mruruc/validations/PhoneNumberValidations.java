package com.mruruc.validations;

import com.mruruc.entity.Contact;

@FunctionalInterface
public interface PhoneNumberValidations {

    PhoneNumberValidations validate(Contact contact);

}
