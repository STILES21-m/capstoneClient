package za.ac.cput.domain;

import java.io.Serializable;
/*
EmployeeAddressAPI.java
AUTHOR Mutamba Prince Bulambo
Student Number 220177767
Date April 11 2022
 */


public class EmployeeAddress implements  Serializable{

    private Long employeeId, addressTypeId;

    public Long getEmployeeId() {
        return employeeId;
    }

    public Long getAddressTypeId() {
        return addressTypeId;
    }



    public EmployeeAddress() {

    }
    public EmployeeAddress(Builder builder)
    {
        this.employeeId=builder.employeeId;
        this.addressTypeId=builder.addressTypeId;

    }


    @Override
    public String toString() {
        return "EmployeeAddress{" +
                "employeeId=" + employeeId +
                ", addressTypeId=" + addressTypeId +
                '}';
    }
    public static class EmployeeAddressId implements Serializable
    {

        private Long employeeId;
        private Long  addressTypeId;

        public EmployeeAddressId() {
        }

        public EmployeeAddressId(Long employeeId, Long addressTypeId) {
            this.employeeId = employeeId;
            this.addressTypeId = addressTypeId;
        }

        public Long getEmployeeId() {
            return employeeId;
        }

        public Long getAddressTypeId() {
            return addressTypeId;
        }

    }

    public static class Builder
    {
        private Long employeeId;
        private Long  addressTypeId;
        public Builder setEmployeeId(Long employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public Builder setAddressTypeId(Long addressTypeId) {
            this.addressTypeId = addressTypeId;
            return this;
        }
        public Builder cody(EmployeeAddress employeeAddress)
        {
            this.employeeId=employeeAddress.employeeId;
            this.addressTypeId=employeeAddress.addressTypeId;
            return this;
        }
        public EmployeeAddress  Build()
        {
            return new EmployeeAddress (this);
        }
    }


}
