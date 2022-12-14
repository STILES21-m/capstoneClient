package za.ac.cput.factory;

import za.ac.cput.domain.AddressType;



/*
EmployeeAddressAPI.java
AUTHOR Mutamba Prince Bulambo
Student Number 220177767
Date April 11 2022
 */

public class AddressTypeFactory {
    public static AddressType buildAddressType(String streetName, String postalCode,String areaName, String city){

        

       return  new AddressType.Builder().setStreetName(streetName).setPostalCode(postalCode).setAreaName(areaName)
               .setCity(city).build();
    }
     public static AddressType buildAddressTypei(Long id,String streetName, String postalCode,String areaName, String city){

        

       return  new AddressType.Builder().setAddressTypeId(id).setStreetName(streetName).setPostalCode(postalCode).setAreaName(areaName)
               .setCity(city).build();
    }
}
