package za.ac.cput.factory;
import za.ac.cput.domain.EmployeeDepartment;

public class EmployeeDepartmentFactory {
    public  static EmployeeDepartment build(Long employeeId, Long deptId){

        return new EmployeeDepartment.Builder()
                .setEmployeeId(employeeId)
                .setDeptId(deptId)
                .build();
    }

    public static EmployeeDepartment createEmployeeDepartment
            ( Long employeeId, Long deptId) {
    return createEmployeeDepartment(employeeId, deptId);
    }
}
