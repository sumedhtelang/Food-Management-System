/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.Organization;
import Business.Role.Role;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sumedhtelang
 */
public class GovernmentEnterprise extends Enterprise {

    GovernmentEnterprise(String name, EnterpriseType type, String address) {
        super(name, type, address);
    }
    

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }

    @Override
    public List<Type> getAllOrganizationTypes() {
        List<Organization.Type> orgTypes = new ArrayList<>();
        orgTypes.add(Organization.Type.GovernmentOfficer);
        orgTypes.add(Organization.Type.GovernmentHead);
        orgTypes.add(Organization.Type.GovernmentSecretary);

        return orgTypes;
    }
    
}
