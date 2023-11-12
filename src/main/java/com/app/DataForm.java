package com.app;

public class DataForm {


    public DataForm() {
        // default constructor
    }
    public String getUserName() {
        return userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private int  userId;
    private String userName;

    public String getEmail() {
        return email;
    }

    private String email;



    @Override
    public String toString() {
        return "DataForm{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

