/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.GovernmentHeadRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author sumedhtelang
 */
public class GovernmentHeadOrganization extends Organization {

    public GovernmentHeadOrganization() {
        super(Organization.Type.GovernmentHead.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new GovernmentHeadRole());
        return roles;
    }
    
}
