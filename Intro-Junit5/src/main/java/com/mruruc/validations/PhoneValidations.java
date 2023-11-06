package com.mruruc.validations;

import com.mruruc.exceptions.PhoneNumberValidationsExceptions;

public class PhoneValidations implements Validator{


   public PhoneValidations() {}

    @Override
    public boolean isBlank(String phone) {
        if(phone == null){
            return true;
        }

        for(int i=0; i< phone.length(); i++){
            if(!Character.isWhitespace(phone.charAt(i))){
                return false;
            }
        }
        return true;
    }


    @Override
    public int lengthWithoutSpaces(String phone){
        if(phone.equals(null)){
            return 0;
        }
        phone=phone.replaceAll("\\s","");
        return phone.length();
    }

    @Override
    public boolean countryCodeValidation(String phone,String countryCode){
        if(phone==null || countryCode ==null){
            return false;
        }

        phone=phone.replaceAll("\\s","");
        countryCode=countryCode.replaceAll("\\s","");

        if(phone.length() < countryCode.length()){
            return false;
        }

        String phonePrefix=phone.substring(0,countryCode.length());

        return phonePrefix.equals(countryCode);
    }

    @Override
    public boolean validateAll(String phone,int length,String countryCode){
       if((!isBlank(phone)) &&
               (lengthWithoutSpaces(phone) == length) &&
               (countryCodeValidation(phone,countryCode))){
           return true;
       }
       throw new PhoneNumberValidationsExceptions("Not Valid Phone Number.");
    }


    /**
     * int result=0;
     *         phone=phone.trim();
     *
     *         for (int i = 0; i < phone.length(); i++) {
     *             if(!Character.isWhitespace(phone.charAt(i))){
     *                 result +=1;
     *             }
     *         }
     *         return result;
     */


}
