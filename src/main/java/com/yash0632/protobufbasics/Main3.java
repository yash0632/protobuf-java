package com.yash0632.protobufbasics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

public class Main3 {
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(reader);
        long startTime = new Date().getTime();
        StringBuilder line = new StringBuilder();
        //String line2 = "";
        int characterUtf8;
        String inputLine;
        while((inputLine = bufferedReader.readLine()) != null){
            //line.append((char)characterUtf8);
            //line2 = line2 +
            line.append(inputLine);
        }

        long timeRequired = new Date().getTime() - startTime;
        System.out.println(timeRequired);
        //System.out.println(line.toString());
        bufferedReader.close();
    }
}
