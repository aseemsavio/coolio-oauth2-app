package com.coolio.templates;

/**
 * @author Aseem Savio
 * Template Class to be sent as the Body in the Async request.
 */
public class UserNamePassword {

    public String userName;
    public String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
