package za.ac.cput.factory;

import za.ac.cput.domain.Employee;

/*
ContactType.java
AUTHOR Farai Malone Chawora
Student Number 220145547
Date 19 Sep 2022
 */
public class EmployeeFactory {

    public  static Employee build( String firstname,String middleName,String lastName){

        

        return new Employee.Builder()

                .setFirstName(firstname)
                .setMiddleName(middleName)
                .setLastName(lastName)
                .build();
    }
    
    
    public  static Employee buildEmployee(Long id, String firstname,String middleName,String lastName){


        return new Employee.Builder()
                 .setEmployeeId(id)
                .setFirstName(firstname)
                .setMiddleName(middleName)
                .setLastName(lastName)
                .build();
    }
}
