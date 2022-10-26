package za.ac.cput.domain;

/*
Employee-management-system.java
EmployeeDepartment.java
Author: Martinez Safari 219325332
Date: 22/09/2022
 */


import java.io.Serializable;


public class EmployeeDepartment implements Serializable {


    private Long employeeId;

    private Long deptId;

    private EmployeeDepartment(Builder builder) {
        this.employeeId = builder.employeeId;
        this.deptId = builder.deptId;

    }

    protected EmployeeDepartment() {

    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "EmployeeDepartment{" +
                "employeeId='" + employeeId + '\'' +
                ", deptId='" + deptId + '\'' +
                '}';
    }


    public static class EmployeeDepartmentID implements Serializable {

        private Long employeeId, deptId;

        protected EmployeeDepartmentID() {
        }

        public Long getEmployeeId() {
            return employeeId;
        }

        public Long getDeptId() {
            return deptId;
        }

        public EmployeeDepartmentID(Long employeeID, Long deptID) {
            this.employeeId = employeeID;
            this.deptId = deptID;
        }
    }
        public static class Builder {
            private Long employeeId;
            private Long deptId;

            public Builder setEmployeeId(Long employeeId) {
                this.employeeId = employeeId;
                return this;
            }

            public Builder setDeptId(Long deptId) {
                this.deptId = deptId;
                return this;
            }

            public Builder copy(EmployeeDepartment employeeDepartment) {
                this.employeeId = employeeDepartment.employeeId;
                this.deptId = employeeDepartment.deptId;
                return this;
            }

            public EmployeeDepartment build() {
                return new EmployeeDepartment(this);
            }
        }
    }
