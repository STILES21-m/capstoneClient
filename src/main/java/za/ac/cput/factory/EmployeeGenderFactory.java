package za.ac.cput.factory;

import za.ac.cput.domain.EmployeeGender;

/*
EmployeeAddressAPI.java
AUTHOR Mutamba Prince Bulambo
Student Number 220177767
Date April 11 2022
 */
public class EmployeeGenderFactory {
    public  static EmployeeGender EmployeeGenderBuilder(Long genderId,Long employeeId){

     
        return  new EmployeeGender.Builder().setEmployeeId(employeeId).setGenderId(genderId).Build();
    }
}
