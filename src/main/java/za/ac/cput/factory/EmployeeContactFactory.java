package za.ac.cput.factory;

import za.ac.cput.domain.EmployeeContact;
/*
ContactType.java
AUTHOR Farai Malone Chawora
Student Number 220145547
Date 19 Sep 2022
 */
public class EmployeeContactFactory {
 public  static EmployeeContact build(Long employeeId, Long contactId){

     return new EmployeeContact.Builder()
             .setEmployeeId(employeeId).setContactId(contactId).build();

  }
}
