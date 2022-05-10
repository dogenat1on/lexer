package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;


public class Main {



    public static void main(String[] args) throws IOException {

        TokenType number = new TokenType("NUMBER","\s*[0-9]+\s*");
        TokenType Variable = new TokenType("VAR","\s*[A-Za-z]+[0-9]*\s*");
        TokenType plus = new TokenType("PLUS","\s*\\+\s*");
        TokenType minus = new TokenType("MINUS","\s*-\s*");
        TokenType asigna = new TokenType("ASIGNA","\s*=\s*");
        TokenType inter= new TokenType("INTER","\s*int\s+");
        TokenType tz= new TokenType("TZ","\s*;\s*");

        TokenType[] regexarr={inter,asigna,plus,minus,Variable,number,tz};

       String s = " ";
       Scanner in = new Scanner(new File("Codik.txt"));
       while(in.hasNext())
           s += in.nextLine() + " ";
       in.close();

       List<Token> list = defType(s,regexarr);

       for (int i =0; i < list.size(); i++){
           System.out.println(list.get(i).getPaint() + " " + list.get(i).getDraw());
       }

    }

    public static List<Token> defType(String a, TokenType[] regexarr){
        List<Token> list = new ArrayList<>();
        int err =0;
        Pattern pattern;
        Matcher match;
        while(a.length()!=0) {
            for ( int i = 0; i < regexarr.length; i++) {
                pattern = Pattern.compile(regexarr[i].getRegex());
                match = pattern.matcher(a);
                if (match.find()) {
                    if(match.start()==0){
                       list.add(new Token(regexarr[i].getName(),match.group()));
                       a = a.substring(match.end()-match.start());
                       break;
                    }

                }

            }
        }
        return list;
    }

}
