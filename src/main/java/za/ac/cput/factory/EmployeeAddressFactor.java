package za.ac.cput.factory;

import za.ac.cput.domain.EmployeeAddress;

/*
EmployeeAddressAPI.java
AUTHOR Mutamba Prince Bulambo
Student Number 220177767
Date April 11 2022
 */
public class EmployeeAddressFactor {
    public  static EmployeeAddress EmployeeAddressBuilder( Long employeeId,Long addressTypeId)
    {
       
        return new EmployeeAddress.Builder().setEmployeeId(employeeId).setAddressTypeId(addressTypeId).Build();
    }
}
