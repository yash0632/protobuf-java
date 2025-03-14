package com.yash0632.protobufbasics;

import com.yash0632.protobufbasics.protos.AddressBook;
import com.yash0632.protobufbasics.protos.Person;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        if(args.length != 1){
            System.err.println("Usage: AddPerson ADDRESS_BOOK_FILE");
            System.exit(-1);
        }

        AddressBook.Builder addressBook = AddressBook.newBuilder();

        //Read the existing address book
        try{
            FileInputStream fileInputStream = new FileInputStream(args[0]);
            addressBook.mergeFrom(fileInputStream);
            fileInputStream.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
            System.err.println("ERROR : "+ e.getMessage());
        }catch(IOException e){
            e.printStackTrace();
            System.err.println(e.getMessage());
        }

        try{
            Scanner sc = new Scanner(System.in);
            Person person = AddPerson.promptForAddress(sc,System.out);
            sc.close();

            addressBook.addPerson(person);
            FileOutputStream output = new FileOutputStream(args[0]);
            addressBook.build().writeTo(output);
            output.close();
        }catch(IOException e){
            System.err.println(e.getMessage());
        }
    }
}
