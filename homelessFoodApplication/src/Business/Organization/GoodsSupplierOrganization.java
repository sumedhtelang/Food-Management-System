/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.GoodsSupplierRole;
import Business.Role.Role;
import Business.WorkQueue.SupervisorWorkRequest;
import java.util.ArrayList;

/**
 *
 * @author sumedh
 */
public class GoodsSupplierOrganization extends Organization{
    
    private ArrayList<SupervisorWorkRequest> approvalQueue;

    public ArrayList<SupervisorWorkRequest> getApprovalQueue() {
        return approvalQueue;
    }

    public void setApprovalQueue(ArrayList<SupervisorWorkRequest> approvalQueue) {
        this.approvalQueue = approvalQueue;
    }
    


    public GoodsSupplierOrganization() {
     super(Organization.Type.GoodSupplier.getValue()); 
     this.approvalQueue = new ArrayList<>();
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new GoodsSupplierRole());
        return roles;
    }
    
}
