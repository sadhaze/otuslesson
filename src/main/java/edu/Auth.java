package edu;

public class Auth {
    public String getAuth(String login, String pass){
        return login.compareTo(pass)==0?"Access":"Denied";
    }
}
