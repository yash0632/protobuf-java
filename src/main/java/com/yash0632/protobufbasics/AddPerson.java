package com.yash0632.protobufbasics;

import com.yash0632.protobufbasics.protos.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class AddPerson {
    static Person promptForAddress(Scanner sc, PrintStream stdout) throws IOException {
        Person.Builder person = Person.newBuilder();

        stdout.print("Enter person ID: ");
        person.setId(sc.nextInt());
        sc.nextLine();
        stdout.print("Enter name : ");
        String name = sc.nextLine();
        person.setName(name);

        stdout.print("Enter email address: ");
        String email = sc.nextLine();

        if(email.length() > 0){
            person.setEmail(email);
        }

        while(true){
            stdout.print("Enter a phone number: ");
            String number = sc.nextLine();
            if(number.length() == 0){
                break;
            }

            Person.PhoneNumber.Builder phoneNumber = Person.PhoneNumber.newBuilder();
            phoneNumber.setNumber(number);

            stdout.print("Is this a mobile, home or work phone?");
            String type = sc.nextLine();
            if(type.equals("mobile")){
                phoneNumber.setType(Person.PhoneType.MOBILE);
            } else if(type.equals("home")){
                phoneNumber.setType(Person.PhoneType.HOME);
            } else if(type.equals("work")){
                phoneNumber.setType(Person.PhoneType.WORK);
            } else {
                stdout.print("Unknown phone type. Using default.");
            }

            person.addPhones(phoneNumber);
        }

        return person.build();
    }
}
