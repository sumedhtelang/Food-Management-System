/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.UserAccount.UserAccount;
import java.util.Date;

/**
 *
 * @author raunak
 */
public abstract class WorkRequest {

    private UserAccount provider;   
    private UserAccount receiver;
    private UserAccount delivery;


    private String currentStatus;
    private Date requestDate;
    private Date publishDate;
    private String foodType;
    private int foodQuantityInKg;
    private String deliveryOption;
    private String decision;
    private String providerAddress;
    private String recieverAddress;
    private String feedRequired;
    private int requirement;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    

    public int getRequirement() {
        return requirement;
    }

    public void setRequirement(int requirement) {
        this.requirement = requirement;
    }

    public String getProviderAddress() {
        return providerAddress;
    }

    public UserAccount getDelivery() {
        return delivery;
    }

    public void setDelivery(UserAccount delivery) {
        this.delivery = delivery;
    }

    public void setProviderAddress(String providerAddress) {
        this.providerAddress = providerAddress;
    }

    public String getRecieverAddress() {
        return recieverAddress;
    }

    public void setRecieverAddress(String recieverAddress) {
        this.recieverAddress = recieverAddress;
    }
    
    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }
        
    //Constructor....
//     public WorkRequest() {
//        requestDate = new Date();        
//    }   

    
    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public int getFoodQuantityInKg() {
        return foodQuantityInKg;
    }

    public void setFoodQuantityInKg(int foodQuantityInKg) {
        this.foodQuantityInKg = foodQuantityInKg;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getDeliveryOption() {
        return deliveryOption;
    }

    public void setDeliveryOption(String deliveryOption) {
        this.deliveryOption = deliveryOption;
    }
   
    public UserAccount getProvider() {
        return provider;
    }

    public void setProvider(UserAccount provider) {
        this.provider = provider;
    }
    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public String getFeedRequired() {
        return feedRequired;
    }

    public void setFeedRequired(String feedRequired) {
        this.feedRequired = feedRequired;
    }
    
    
    

    @Override
    public String toString() {
        return  provider.getUsername();
    }
}
