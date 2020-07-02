/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.OrganizationDirectory;
import java.util.ArrayList;

/**
 *
 * @author sumedh
 */
public class EnterpriseDirectory {
    private ArrayList<Enterprise> enterpriseList;
   

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public void setEnterpriseList(ArrayList<Enterprise> enterpriseList) {
        this.enterpriseList = enterpriseList;
    }
    
    public EnterpriseDirectory(){
        enterpriseList=new ArrayList<Enterprise>();
    }
    
    //Create enterprise
    public Enterprise createAndAddEnterprise(String name,Enterprise.EnterpriseType type, String address){
        Enterprise enterprise=null;
        if(type==Enterprise.EnterpriseType.NGO){
            enterprise=new NGOEnterprise(name, type, address);
            enterpriseList.add(enterprise);
        }
        else if(type==Enterprise.EnterpriseType.HomelessShelter){
            enterprise=new HomelessShelterEnterprise(name, type, address);
            enterpriseList.add(enterprise);
        }
        else if(type==Enterprise.EnterpriseType.Government){
            enterprise=new GovernmentEnterprise(name, type, address);
            enterpriseList.add(enterprise);
        }
        return enterprise;
    }
}
