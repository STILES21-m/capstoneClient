package za.ac.cput.domain;

import java.io.Serializable;

/*
Employee.java
AUTHOR Farai Malone Chawora
Student Number 220145547
Date April 9 2022
 */

public class Employee implements Serializable {


    private Long employeeId;
    private String firstName;
    private String middleName;
    private String lastName;





    protected Employee() {
    }
    private Employee(Builder builder){
        this.firstName= builder.firstName;
        this.middleName=builder.middleName;
        this.lastName= builder.lastName;
        this.employeeId= builder.employeeId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getMiddleName() {
        return middleName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public static class Builder {
        private String firstName;
        private String middleName;
        private String lastName;
        private Long employeeId;


        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;

        }
        public Builder setMiddleName(String middleName) {
            this.middleName = middleName;
            return this;

        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setEmployeeId(Long employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public Builder copy(Employee employee) {
            this.firstName = employee.firstName;
            this.middleName = employee.middleName;
            this.lastName = employee.lastName;
            this.employeeId = employee.employeeId;
            return this;

        }

        public Employee build() {
            return new Employee(this);
        }
    }


}

