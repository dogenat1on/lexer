package com.company;

public class TokenType {
    public String name;
    public String doge;


    public TokenType(String name, String regex) {
        this.name = name;
        this.doge = regex;
    }

    public String getName() {
        return name;
    }

    public String getRegex() {
        return doge;
    }

}
