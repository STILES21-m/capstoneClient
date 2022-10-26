/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.cput.factory;

import za.ac.cput.domain.EmployeeRole;

/**
 *
 * @author martinez
 */
public class EmployeeRoleFactory {
    public  static EmployeeRole build(Long employeeId, Long roleId){

        return new EmployeeRole.Builder()
                .setEmployeeId(employeeId).setRoleId(roleId).build();

    }
}
