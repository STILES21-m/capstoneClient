package za.ac.cput.domain;



import java.io.Serializable;
/*
EmployeeAddressAPI.java
AUTHOR Mutamba Prince Bulambo
Student Number 220177767
Date April 11 2022
 */

public class EmployeeGender implements Serializable
{
    private Long employeeId;
    private Long genderId;
  

    public EmployeeGender(Builder builder)
    {
        this.employeeId=builder.employeeId;
        this.genderId=builder.genderId;
   

    }

    public EmployeeGender() {

    }

     public Long getEmployeeId() {
        return employeeId;
    }
    public Long getGenderId()
    {
        return genderId;
    }

   


    @Override
    public String toString() {
        return "EmployeeGender{" +
                "genderId='" + genderId + '\'' +
                ", employeeId='" + employeeId + '\'' +
                '}';
    }
    public static class EmployeeGenderID implements Serializable {

        private Long employeeId, genderId;

        protected EmployeeGenderID() {
        }

        public EmployeeGenderID(Long employeeID, Long genderId) {
            this.employeeId = employeeID;
            this.genderId = genderId;
        }

        public Long getEmployeeId() {
            return employeeId;
        }

        public Long genderId() {
            return genderId;
        }

    }

    public static class Builder
    {

        private Long genderId;
        private Long employeeId;



        public Builder setGenderId(Long genderId) {
            this.genderId =genderId;
            return this;
        }

        public Builder setEmployeeId(Long employeeId) {
            this.employeeId = employeeId;
            return this;
        }



        public Builder cody(EmployeeGender employee)
        {
            this.genderId=employee.genderId;
            this.employeeId=employee.employeeId;


            return this;
        }
        public EmployeeGender  Build()
        {
            return new EmployeeGender (this);
        }
    }

}
