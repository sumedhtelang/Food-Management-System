/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.UserAccount.UserAccount;

/**
 *
 * @author sumedhtelang
 */
public class QuotationRequest extends WorkRequest {
    private String feedRequired;

    public String getFeedRequired() {
        return feedRequired;
    }

    public void setFeedRequired(String feedRequired) {
        this.feedRequired = feedRequired;
    }

    
    public QuotationRequest(){
        this.feedRequired = feedRequired;
    }
    
    
}
