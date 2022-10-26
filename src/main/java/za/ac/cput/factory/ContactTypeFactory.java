package za.ac.cput.factory;


import za.ac.cput.domain.ContactType;
/*
ContactType.java
AUTHOR Farai Malone Chawora
Student Number 220145547
Date 19 Sep 2022
 */
public class ContactTypeFactory {

public static ContactType build(String email,String phoneNumber){


    return new ContactType.Builder()
            .setEmail(email)
            .setPhoneNumber(phoneNumber)
            .build();
}
}
