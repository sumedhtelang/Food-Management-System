/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.HomelessShelterDonationRole;
import Business.Role.Role;
import Business.WorkQueue.QuotationRequest;
import java.util.ArrayList;

/**
 *
 * @author sumedhtelang
 */
public class HomelessShelterDonationOrganization extends Organization {

    private ArrayList<QuotationRequest> quotationRequest;

    public ArrayList<QuotationRequest> getQuotationRequest() {
        return quotationRequest;
    }

    public void setQuotationRequest(ArrayList<QuotationRequest> quotationRequest) {
        this.quotationRequest = quotationRequest;
    }

    public HomelessShelterDonationOrganization() {
        super(Organization.Type.HomelessShelterDonation.getValue());
        this.quotationRequest = new ArrayList<>();
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new HomelessShelterDonationRole());
        return roles;
    }
    
}
