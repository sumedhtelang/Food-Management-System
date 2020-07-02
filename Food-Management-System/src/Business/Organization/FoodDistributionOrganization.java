/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.FoodDistributionRole;
import Business.Role.Role;
import Business.WorkQueue.SupervisorWorkRequest;
import java.util.ArrayList;

/**
 *
 * @author sumedhtelang
 */
public class FoodDistributionOrganization extends Organization {
    
    private ArrayList<SupervisorWorkRequest> replyApprovalQueue;

    public ArrayList<SupervisorWorkRequest> getReplyApprovalQueue() {
        return replyApprovalQueue;
    }

    public void setReplyApprovalQueue(ArrayList<SupervisorWorkRequest> replyApprovalQueue) {
        this.replyApprovalQueue = replyApprovalQueue;
    }

    public FoodDistributionOrganization() {
        super(Organization.Type.FoodDistribution.getValue());
        this.replyApprovalQueue = new ArrayList<>();
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new FoodDistributionRole());
        return roles;
    }
    
}
