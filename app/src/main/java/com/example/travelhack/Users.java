package com.example.travelhack;

public class Users {

    private String userName;

    private String userPhone;

    private String userAddress;

    private String userEmail;

    // an empty constructor is
    // required when using
    // Firebase Realtime Database.
    public Users() {

    }

    // created getter and setter methods
    // for all our variables.
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserContactNumber() {
        return userPhone;
    }

    public void setUserContactNumber(String userContactNumber) {
        this.userPhone = userContactNumber;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
