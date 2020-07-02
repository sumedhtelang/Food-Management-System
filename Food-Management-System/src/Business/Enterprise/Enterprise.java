 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import java.util.List;

/**
 *
 * @author sumedh
 */
public abstract class Enterprise extends Organization{
    
    private String enterpriseName;
    private String enterpriseAddress;
    private EnterpriseType enterpriseType;
    private OrganizationDirectory organizationDirectory;

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getEnterpriseAddress() {
        return enterpriseAddress;
    }

    public void setEnterpriseAddress(String enterpriseAddress) {
        this.enterpriseAddress = enterpriseAddress;
    }
    
    
    
    
    public enum EnterpriseType{
        NGO("NGO"), HomelessShelter("Homeless Shelter"),Government("Government");
        
        private String value;
        
        private EnterpriseType(String value){
            this.value=value;
        }
        public String getValue() {
            return value;
        }
        @Override
        public String toString(){
        return value;
    }
    }

    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }

    public void setEnterpriseType(EnterpriseType enterpriseType) {
        this.enterpriseType = enterpriseType;
    }
    
    public Enterprise(String enterpriseName, EnterpriseType enterpriseType, String address){
        super(enterpriseName);
        this.enterpriseName= enterpriseName;
        this.enterpriseAddress = address;
        this.enterpriseType = enterpriseType;
        organizationDirectory=new OrganizationDirectory();
    }
    
    public abstract List<Organization.Type> getAllOrganizationTypes();
}
