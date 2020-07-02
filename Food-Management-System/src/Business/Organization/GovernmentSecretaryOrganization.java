/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.GovernmentOfficerRole;
import Business.Role.GovernmentSecretaryRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author sumedhtelang
 */
public class GovernmentSecretaryOrganization extends Organization {
 
    GovernmentSecretaryOrganization() {
        super(Organization.Type.GovernmentSecretary.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new GovernmentSecretaryRole());
        return roles;
    }
}
