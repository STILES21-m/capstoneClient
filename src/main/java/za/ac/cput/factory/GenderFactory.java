package za.ac.cput.factory;

import za.ac.cput.domain.Gender;


/*
EmployeeAddressAPI.java
AUTHOR Mutamba Prince Bulambo
Student Number 220177767
Date April 11 2022
 */
public class GenderFactory {
    public  static Gender GenderBuilder(String genderType, String description){

       
        return  new Gender.Builder().setGenderType(genderType).setDescription(description).Build();
    }
}
