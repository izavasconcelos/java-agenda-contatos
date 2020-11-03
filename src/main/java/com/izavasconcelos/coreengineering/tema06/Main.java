package com.izavasconcelos.coreengineering.tema06;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner keyBoard = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook();
        int selectOption;

        do {
            menu();
            selectOption = Integer.parseInt(keyBoard.nextLine());

            switch (selectOption){
                case 1:
                    System.out.println("***************** New Contact *********************");
                    System.out.print("Name: ");
                    String name = keyBoard.nextLine();
                    System.out.print("Phone: ");
                    String phone = keyBoard.nextLine();
                    phoneBook.newContact(new Contact(name, phone));
                    System.out.println("***************************************************");
                    break;
                case 2:
                    if(phoneBook.contactList.isEmpty()){
                        System.out.println("*** List is empty!  ***");
                    } else {
                        System.out.println(phoneBook.contactList);
                    }
                    break;
                case 3:
                    System.out.println("*************** Remove Contact ********************");
                    System.out.print("Name to remove: ");
                    String nameToRemove = keyBoard.nextLine();
                    List<Contact> contactRemove = phoneBook.removeContact(nameToRemove);
                    if(contactRemove == null) {
                        System.out.println("## Contact Not Found! ##");
                    } else{
                        System.out.println(phoneBook.contactList);
                    }
                    System.out.println("***************************************************");
                    break;
                case 4:
                    System.out.println("*************** Search Contact ********************");
                    System.out.println("********* [ 1 ] - Name   [ 2 ] - ID  **************");
                    int selectSearch = Integer.parseInt(keyBoard.nextLine());
                    switch (selectSearch){
                        case 1:
                            System.out.print("Name to search: ");
                            String nameToFind = keyBoard.nextLine();
                            List<Contact> contact = phoneBook.findNameContact(nameToFind);
                            if(contact.isEmpty()){
                                System.out.println("##  Contact Not Found!  ##");
                            }else{
                                System.out.println(contact);
                            }
                            System.out.println("***************************************************");
                            break;
                        case 2:
                            System.out.print("ID to search: ");
                            int idToFind = Integer.parseInt(keyBoard.nextLine());
                            Optional<Contact> contactId = phoneBook.findIdContact(idToFind);
                            if(contactId.isPresent()){
                                System.out.println(contactId.get());
                            }else{
                                System.out.println("##  Contact Not Found!  ##");
                            }
                            System.out.println("***************************************************");
                            break;
                        default:
                            System.out.println("Invalid option!");
                    }
                    break;
                default:
                   if(selectOption > 4) System.out.println("Invalid Option!");
            }

        }while(selectOption != 0);
        System.out.println("####   Bye   ####");

    }

    public static void menu() {
        System.out.println(" ");
        System.out.println("***************** Ilegra Contacts *****************");
        System.out.println("**                                               **");
        System.out.println("**  1 - New Contact                              **");
        System.out.println("**  2 - List Contact                             **");
        System.out.println("**  3 - Remove Contact                           **");
        System.out.println("**  4 - Search Contact                           **");
        System.out.println("**  0 - Exit                                     **");
        System.out.println("**                                               **");
        System.out.println("***************************************************");
        System.out.print(">>");
    }

}
