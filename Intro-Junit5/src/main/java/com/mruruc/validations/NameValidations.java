package com.mruruc.validations;

import com.mruruc.exceptions.NameValidationsExceptions;

public class NameValidations implements Validator{

    public NameValidations() {}

    @Override
    public boolean isBlank(String instance) {
        if(instance == null){
            return true;
        }

        for (int i = 0; i < instance.length(); i++) {
            if(!Character.isWhitespace(instance.charAt(i))){
                return false;
            }
        }
        return true;
    }

    @Override
    public int lengthWithoutSpaces(String instance) {
        if(instance == null){
            return 0;
        }

        int result = instance.replaceAll("\\s", "").length();
        return result;
    }

    @Override
    public boolean validateAll(String instance) {
        if(!isBlank(instance) && lengthWithoutSpaces(instance) > 2){
            return true;
        }
        throw new NameValidationsExceptions("Name Can Not be Blank Or Minimum 2 Character!");
    }
}
