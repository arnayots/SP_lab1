package com.company;
import java.io.*;
import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static int MaxWordLenght = 28;
    public static String FileNameInput = "input.txt";
    public static String FileNameOut = "out.txt";

    public static void main(String[] args) {
        try {
            System.out.println("***** Start of program work *****");
            FileReader fileIn = new FileReader(FileNameInput);
            TreeSet<String> dictionary = new TreeSet<String>(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if(o1.length() > o2.length())
                        return 1;
                    if(o1.length() < o2.length())
                        return -1;
                    return o1.compareTo(o2);
                }
            });

            int c;
            String word = "";
            while ((c = fileIn.read()) != -1)
            {
                if((c >= 65 && c <= 90) || (c >= 97 && c <= 122)){
                    if(c <= 90)
                        c += 32;
                    word += (char) c;
                } else {
                    if(word.length() > MaxWordLenght)
                        word = word.substring(0, MaxWordLenght);
                    if(word != "")
                        dictionary.add(word);
                    word = "";
                }
            }
            fileIn.close();

            FileWriter fileOut = new FileWriter(FileNameOut);
            for(String sample : dictionary){
                fileOut.write(sample.length() + " " + sample + "\n");
            }
            fileOut.close();
            System.out.println("***** Program finished word succesfully *****");
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
