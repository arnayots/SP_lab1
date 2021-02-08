package com.company;
import java.io.*;
import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static int MaxWordLenght = 28;
    public static String FileNameInput = "input2.txt";
    public static String FileNameOut = "out2.txt";

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
                if((c >= 65 && c <= 90) || (c >= 97 && c <= 122) || (c == 45) || (c == 39)){
                    if(c >= 65 && c <= 90)
                        c += 32;
                    word += (char) c;
                } else {
                    if(word.length() > MaxWordLenght)
                        word = word.substring(0, MaxWordLenght);
                    if(word != "") {
                        int len = word.length();
                        int beg = 0;
                        char[] tmp = new char[len];
                        for (int i = 0; i < len; i++)
                            tmp[i] = word.charAt(i);
                        while((beg < len) && (tmp[beg] == '\'' || tmp[beg] == '-' ))
                            beg++;
                        while((beg < len) && (tmp[len - 1] == '\'' || tmp[len - 1] == '-' ))
                            len--;
                        word = word.substring(beg, len);
                        dictionary.add(word);
                    }
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
