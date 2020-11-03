package com.izavasconcelos.coreengineering.tema06;

import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class PhoneBookTest {

    private Contact newContactTestOne, newContactTestTwo, notContact;
    private final PhoneBook phoneBook = new PhoneBook();

    @Before
    public void inputTest(){
        newContactTestOne = new Contact("Izabela", "51999652469");
        newContactTestTwo = new Contact("Joao", "51999223344");
        phoneBook.newContact(newContactTestOne);
        phoneBook.newContact(newContactTestTwo);

        notContact = new Contact("NãoToCadastrado", "0000");

    }
    @Test
    public void testAddNewContact() {
        assertTrue(phoneBook.contactList.contains(newContactTestOne));
    }

    @Test
    public void testAddNullContact() {
        assertFalse(phoneBook.newContact(null));
    }
    @Test
    public void testNotContain() {
        assertFalse(phoneBook.contactList.contains(notContact));
    }
    @Test
    public void testListContacts() {
        assertNotNull(phoneBook.contactList);
    }

    @Test
    public void testRemoveContact() {
        List<Contact> contact = phoneBook.removeContact("Izabela");
        assertFalse(contact.isEmpty());
        assertFalse(phoneBook.contactList.contains(newContactTestOne));
    }
    @Test
    public void testContactList() {
        assertEquals(2, phoneBook.contactList.size());
    }
    @Test
    public void testSearchContact() {
        assertEquals("Joao",newContactTestTwo.getName());
        assertEquals(1,newContactTestTwo.getId());
    }
    @Test
    public void testSearchNullContact() {
        List<Contact> nullContact = phoneBook.findNameContact(null);
        assertNull(nullContact);
    }
    @Test
    public void testSearchEmptyContact() {
        List<Contact> nullContact = phoneBook.findNameContact("");
        assertNull(nullContact);
    }

    @Test
    public void testFindNameDoesNotExist() {
        List<Contact> contact = phoneBook.findNameContact("Maria");
        assertTrue(contact.isEmpty());
    }

    @Test
    public void testFindIdDoesNotExist() {
        Optional<Contact> contact = phoneBook.findIdContact(15);
        assertFalse(contact.isPresent());
    }

    @Test
    public void testRemoveNameDoesNotExist() {
        List<Contact> contactNull = phoneBook.removeContact("Felipe");
        assertNull(contactNull);
    }

    @Test
    public void testRemoveNameEmpty() {
        List<Contact> contactNull = phoneBook.removeContact("");
        assertNull(contactNull);
    }

}
