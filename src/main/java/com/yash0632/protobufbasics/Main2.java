package com.yash0632.protobufbasics;

import java.io.*;
import java.sql.Time;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Main2 {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("C:/Users/YASHS/Downloads/large_raw_data.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        long startTime =new Date().getTime();
        while(bufferedReader.readLine() != null){

        }
        long timeRequired = new Date().getTime() - startTime;
        System.out.println(timeRequired);

        bufferedReader.close();
    }

}
