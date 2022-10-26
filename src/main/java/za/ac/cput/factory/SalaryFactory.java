package za.ac.cput.factory;

import za.ac.cput.domain.Salary;



public class SalaryFactory
{
    public static Salary build(String salaryAmount, String salaryDescription)
    {
        return new Salary.Builder()
                .setSalaryAmount(salaryAmount)
                .setSalaryDescription(salaryDescription)
                .build();
    }
}





