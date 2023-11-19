package com.libraryManagement.model;


public class Subscribers extends User{

    public Subscribers(String userName, String userReference) {
        super(userName, userReference);
    }

    public Subscribers(String idUser, String UserName, String UserReference) {
        super(idUser, UserName, UserReference);
    }
}
