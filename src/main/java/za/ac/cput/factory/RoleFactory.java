/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.cput.factory;

import za.ac.cput.domain.Role;

/**
 *
 * @author martinez
 */
public class RoleFactory {
        public  static Role build( String roleName,String roleDesc) {

        return new Role.Builder()
               .setRoleName(roleName).setRoleDesc(roleDesc).build();
    }
}
