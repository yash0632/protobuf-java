package com.yash0632.protobufbasics;

import com.yash0632.protobufbasics.protos.AddressBook;
import com.yash0632.protobufbasics.protos.Person;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main5 {
    static void Print(AddressBook addressBook){
        for(Person person : addressBook.getPersonList()){
            System.out.println("Person ID: "+ person.getId());
            System.out.println("Name: " + person.getName());
            if(person.hasEmail()){
                System.out.println("Email : "+ person.getEmail());
            }
            for(Person.PhoneNumber phoneNumber : person.getPhonesList()){
                switch(phoneNumber.getType()){
                    case MOBILE:
                        System.out.println("Mobile: "+ phoneNumber.getNumber());
                        break;
                    case HOME:
                        System.out.println("Home: "+ phoneNumber.getNumber());
                        break;
                    case WORK:
                        System.out.println("Work: "+ phoneNumber.getNumber());
                        break;
                }
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        if(args.length != 1){
            System.err.println("Usage: AddPerson ADDRESS_BOOK_FILE");
            System.exit(-1);
        }

        FileInputStream file = new FileInputStream(args[0]);
        AddressBook addressBook = AddressBook.parseFrom(file);
        Print(addressBook);

    }
}
