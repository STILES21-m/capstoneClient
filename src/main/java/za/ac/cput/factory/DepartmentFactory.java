package za.ac.cput.factory;



import za.ac.cput.domain.Department;

public class DepartmentFactory {

    public static Department build( String deptName, String deptDesc){



        return new Department.Builder()
                .setDeptName(deptName)
                .setDeptDesc(deptDesc)
                .build();
    }


    public static Department createDepartment(String s, String c876, String s1) {
        return null;
    }
}