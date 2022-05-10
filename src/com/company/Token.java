package com.company;

public class Token {
    public String type;
    public String content;
    Token(String type, String content){
        this.type = type;
        this.content = content;
    }
public String getDraw(){
        return type;
}
public String getPaint(){
        return content;
}
}

