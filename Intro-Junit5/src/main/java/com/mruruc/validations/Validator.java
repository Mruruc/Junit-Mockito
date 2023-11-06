package com.mruruc.validations;

public interface Validator {
    boolean isBlank(String instance);
    int lengthWithoutSpaces(String instance);
   default boolean validateAll(String instance,int length,String code){return false;}
    default boolean validateAll(String instance){return false;}
    default boolean countryCodeValidation(String phone,String countryCode){
        return false;
    }
}
