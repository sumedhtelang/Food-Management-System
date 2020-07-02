/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import java.util.ArrayList;
import Business.Organization.Organization.Type;

/**
 *
 * @author raunak
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization( Type type){
        Organization organization = null;
        
                if (type.getValue().equals(Organization.Type.Delivery.getValue())){
                organization = new DeliveryOrganization();          
                organizationList.add(organization);
            }
        else if (type.getValue().equals(Organization.Type.FoodDistribution.getValue())){
                organization = new FoodDistributionOrganization();
                organizationList.add(organization);
            }
        else if (type.getValue().equals(Organization.Type.GoodSupplier.getValue())){
                organization = new GoodsSupplierOrganization();
                organizationList.add(organization);
            }
         
      
        
                if (type.getValue().equals(Organization.Type.Pickup.getValue())){
                organization = new PickupOrganization();
                organizationList.add(organization);
                }
                else if (type.getValue().equals(Organization.Type.HomelessShelterManager.getValue())){
                organization = new HomelessShelterManagerOrganization();
                organizationList.add(organization);
                }
                else if (type.getValue().equals(Organization.Type.HomelessShelterDonation.getValue())){
                organization = new HomelessShelterDonationOrganization();
                organizationList.add(organization);
                }
        
            
        
        
                if (type.getValue().equals(Organization.Type.GovernmentHead.getValue())){
                organization = new GovernmentHeadOrganization();
                organizationList.add(organization);
                }
                else if (type.getValue().equals(Organization.Type.GovernmentOfficer.getValue())){
                organization = new GovernmentOfficerOrganization();
                organizationList.add(organization);
                }
                else if (type.getValue().equals(Organization.Type.GovernmentSecretary.getValue())){
                organization = new GovernmentSecretaryOrganization();
                organizationList.add(organization);
                }
        
            
       
        return organization;
    }
}