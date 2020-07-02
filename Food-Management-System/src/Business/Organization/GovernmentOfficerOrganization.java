/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.GovernmentOfficerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author sumedhtelang
 */
public class GovernmentOfficerOrganization extends Organization{

    GovernmentOfficerOrganization() {
        super(Organization.Type.GovernmentOfficer.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new GovernmentOfficerRole());
        return roles;
    }
    
}
