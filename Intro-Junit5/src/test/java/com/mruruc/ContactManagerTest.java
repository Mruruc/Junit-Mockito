package com.mruruc;

import com.mruruc.entity.Contact;
import com.mruruc.exceptions.NameValidationsExceptions;
import com.mruruc.exceptions.PhoneNumberValidationsExceptions;
import com.mruruc.services.ContactManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class ContactManagerTest {
    private ContactManager contactManager;
    private Contact contact;

    @BeforeEach
    void init() {
        this.contactManager = new ContactManager();
        this.contact = new Contact();
    }

    @Test
    @DisplayName("Testing Contact AND Contact Manger,Instance.")
    void test_instance() {

        assertInstanceOf(Contact.class, contact);
        assertInstanceOf(ContactManager.class, contactManager);

    }

    @Test
    @DisplayName("Adding new Contact Without Issue.")
    void addContactTest() {
        contact.setFullName("John Doe");
        contact.setPhone("+48562421321");
        boolean expected = contactManager.addContact(contact);
        assertTrue(expected);
    }

    @Test
    @DisplayName("Testing Blank Name Input!")
    void testing_blankName() {
        contact.setFullName("");
        contact.setPhone("+48562421321");

        assertThrows(RuntimeException.class,
                () -> contactManager.addContact(contact));
    }

    @Test
    @DisplayName("Miss Length Of Phone")
    void testing_missLength() {
        contact.setFullName("John Doe");
        contact.setPhone("+485624213");
        assertThrows(RuntimeException.class,
                () -> contactManager.addContact(contact));
    }

    @Test
    @DisplayName("Wrong Country Code")
    void testing_wrong_countryCode() {
        contact.setFullName("John Doe");
        contact.setPhone("+18562421333");
        assertThrows(RuntimeException.class,
                () -> contactManager.addContact(contact));
    }


    @DisplayName("Test with Multiple Names")
    @ParameterizedTest
    @ValueSource(strings = {"  1  ", "", " cx "})
    void test_multiple_test(String name) {
        contact.setFullName(name);
        contact.setPhone("+48562421333");

        assertThrows(NameValidationsExceptions.class,
                () -> contactManager.addContact(contact));
    }

    @DisplayName("Testing Multiple Not Validate Phone")
    @ParameterizedTest
    //  @CsvFileSource(resources = "/test_data.csv")
    @CsvSource({"+4845245245255", "+14525652321", "+555", "5",})
    void test_multiple_phone(String phoneNumber) {
        contact.setPhone(phoneNumber);
        contact.setFullName("John Doe");
        assertThrows(PhoneNumberValidationsExceptions.class,
                () -> contactManager.addContact(contact));

    }

    @AfterEach
    void tearDown() {
        contactManager = null;
        contact = null;
    }
}
