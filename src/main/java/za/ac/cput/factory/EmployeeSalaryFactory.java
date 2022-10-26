package za.ac.cput.factory;

import za.ac.cput.domain.EmployeeSalary;

public class EmployeeSalaryFactory
{
    public static EmployeeSalary build(Long employeeId, Long salaryId)
    {

        return new EmployeeSalary.Builder()
                    .setEmployeeId(employeeId)
                    .setSalaryId(salaryId)
                    .build();
    }
}
