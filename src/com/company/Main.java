package com.company;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello, world!");

        try (FileReader reader = new FileReader("test.txt"))
        {
            int c;
            String word = "";
            while ((c=reader.read()) != -1)
            {
                int tmp1 = (int) c;
                if(tmp1 >= 65 && tmp1 <= 90){
                    word += (char) c;
                    System.out.println("Symbol " + c + " added to " + word);
                } else {
                    //if(word != "")
                        System.out.println(word);
                    word = "";
                }
            }
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }

        System.out.println("End of the program");


	// write your code here
    }
}
