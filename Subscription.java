/**
 * Subscription class represents a subscription that can be purchased by a user for accessing different services or features
 * 
 * @Author Xinyan Liu
 */
import java.util.Date;

public class Subscription {
    private Date startDate;
    private Date endDate;
    private String subscriptionLevel;

    /**
     * Constructor for creating a new subscription object with a start date, end date, and subscription level
     * 
     * @param startDate
     * @param endDate
     * @param subscriptionLevel
     */
    public Subscription(Date startDate, Date endDate, String subscriptionLevel) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.subscriptionLevel = subscriptionLevel;
    }

    /*
     * Returns the start date of the subscription
     * @return the start date of the subscription
     */
    public Date getStartDate() {
        return startDate;
    }
    
    /*
     * Sets the start date of the subscription
     * @param startDate the start date of the subscription
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    
    /*
     * Returns the end date of the subscription
     * @return the end date of the subscription
     */
    public Date getEndDate() {
        return endDate;
    }
    
    /*
     * Sets the end date of the subscription
     * @param endDate the end date of the subscription
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
    /*
     * Returns the subscription level of the subscription
     * @return the subscription level of the subscription
     */
    public String getSubscriptionLevel() {
        return subscriptionLevel;
    }
    
    /*
     * Sets the subscription level of the subscription
     * @param subscriptionLevel the subscription level of the subscription
     */
    public void setSubscriptionLevel(String subscriptionLevel) {
        this.subscriptionLevel = subscriptionLevel;
    }
}
   