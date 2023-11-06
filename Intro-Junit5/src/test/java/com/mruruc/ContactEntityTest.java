package com.mruruc;

import com.mruruc.entity.Contact;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactEntityTest {
    private Contact contact;

    @BeforeEach
    @DisplayName("Initializing Contact Object Before Each Test Case.")
    void init(){
        this.contact=new Contact("John Doe","+48735465388");
    }

    @Test
    @DisplayName("Testing Contact Instance.")
    void test_contact(){
        String name="John Doe".trim();
        String phone="+48735465388".trim();
        assertEquals(name,contact.getFullName());
        assertEquals(phone,contact.getPhone());
    }

    @AfterEach
    @DisplayName("After Each Test Object will be Garbage.")
    void tearDown(){
        contact=null;
    }
}
