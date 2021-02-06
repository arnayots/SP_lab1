package com.company;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello, world!");

        try (FileReader reader = new FileReader("test.txt"))
        {
            int c;
            while ((c=reader.read()) != -1) {
                System.out.print((char) c);
            }
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }

        System.out.println("End of the program");


	// write your code here
    }
}
