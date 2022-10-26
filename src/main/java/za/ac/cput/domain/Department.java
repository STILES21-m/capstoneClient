package za.ac.cput.domain;

/*
Employee-management-system.java
Department.java
Author: Martinez Safari 219325332
Date: 22/09/2022
 */



import java.io.Serializable;


public class Department implements Serializable{


    private Long deptId;
    private String deptName;
    private String deptDesc;

    protected Department(){}

    private Department(Builder builder){
        this.deptId= builder.deptId;
        this.deptName= builder.deptName;
        this.deptDesc= builder.deptDesc;


    }
    public Long getDeptId() {
        return deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public String getDeptDesc() {
        return deptDesc;
    }
    @Override
    public String toString() {
        return "Department{" +
                "deptId='" + deptId + '\'' +
                ", deptName='" + deptName + '\'' +
                ", deptDesc='" + deptDesc + '\'' +
                '}';
    }
    public static class Builder{
        private String deptName, deptDesc;
        private Long deptId;

        public Builder setDeptId(Long deptId) {
            this.deptId = deptId;
            return this;
        }

        public Builder setDeptName(String deptName) {
            this.deptName = deptName;
            return this;
        }

        public Builder setDeptDesc(String deptDesc) {
            this.deptDesc = deptDesc;
            return this;
        }
        public Builder copy(Department department){
            this.deptId= department.deptId;
            this.deptName= department.deptName;
            this.deptDesc= department.deptDesc;
            return this;
        }
        public Department build(){

            return new Department(this);
        }

    }



}