package com.izavasconcelos.coreengineering.tema06;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PhoneBook {
    List<Contact> contactList = new ArrayList<>();
    private int couter = 0;

    public boolean newContact(Contact contact) {
        if(contact == null) {
            return false;
        }else{
            contact.setId(couter++);
            return contactList.add(contact);
        }
    }

    public List<Contact> findNameContact(String nameToFind) {
        if( nameToFind == null) {
            return null;
        }
        else if (nameToFind.isEmpty()){
            return null;
        } else {
            return contactList.stream().filter(contacts -> contacts.getName().contains(nameToFind)).collect(Collectors.toList());
        }
    }

    public Optional<Contact> findIdContact(int idToFind) {
            return contactList.stream().filter(contacts -> contacts.getId() == idToFind).findFirst();
    }

    public List<Contact> removeContact(String nameToRemove) {
        List<Contact> contactToRemove = findNameContact(nameToRemove);
        if(contactToRemove == null || contactToRemove.isEmpty()) {
            return null;
        } else {
            contactList.removeIf(n -> n.getName().equals(nameToRemove));
            return contactList;
        }

    }
}
