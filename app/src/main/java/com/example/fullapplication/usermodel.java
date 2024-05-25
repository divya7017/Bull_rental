package com.example.fullapplication;

public class usermodel {
    private String name;
    private String phoneno;
    private String email;

    private String username;
    public usermodel() {

    }

    public usermodel(String name, String phoneno, String email, String username) {
        this.name = name;
        this.phoneno = phoneno;
        this.email = email;
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
