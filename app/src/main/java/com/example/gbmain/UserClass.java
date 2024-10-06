package com.example.gbmain;

public class UserClass {
    private String email ,ownerName ;

    public UserClass(String email, String ownerName) {
        this.email = email;
        this.ownerName = ownerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}