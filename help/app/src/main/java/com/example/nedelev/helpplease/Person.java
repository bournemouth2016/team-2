package com.example.jonat.testproject;

/**
 * Created by jonathan on 19/11/2016.
 */

public class Person {

   public enum Role {CAPTAIN, OWNER};
    private final Role role;
    private String phoneNumber;


    public Person(final Role role, final String phoneNumber){
        this.role = role;
        this.phoneNumber = phoneNumber;
    }

    public Role getRole(){
        return role;
    }

    public void setPhoneNumber(final String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

}
