package za.ac.cput.domain;

import java.io.Serializable;



/*
ContactType.java
AUTHOR Farai Malone Chawora
Student Number 220145547
Date 19 Sep 2022
 */

public class ContactType implements Serializable {

    private Long contactId;
    private String email;
    private String phoneNumber;



    protected ContactType(){}

    private ContactType(Builder build){
        this.contactId= build.contactId;
        this.email= build.email;
        this.phoneNumber= build.phoneNumber;


    }

    public Long getContactId() {
        return contactId;
    }



    public String getEmail() {
        return email;
    }



    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "ContactType{" +
                "contactId='" + contactId + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public static class Builder{
        private Long contactId;
        private String email;
        private String phoneNumber;

        public Builder setContactId(Long contactId) {
            this.contactId = contactId;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }
        public Builder copy(ContactType cntType){
            this.contactId=cntType.contactId;
            this.email=cntType.email;
            this.phoneNumber= cntType.phoneNumber;
            return this;

        }
        public ContactType build(){
            return new ContactType(this);
        }
    }
}
