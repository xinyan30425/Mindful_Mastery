/**
 * Payment class representing a payment made for a course
 * 
 * @Author Xinyan Liu
 */

import java.util.Date;

public class Payment {
    private double amount;
    private Date date;
    private String paymentMethod;

    /**
     * Constructs a new Payment object with the specified amount, date and payment method
     * 
     * @param amount
     * @param date
     * @param paymentMethod
     */
    public Payment(double amount, Date date, String paymentMethod) {
        this.amount = amount;
        this.date = date;
        this.paymentMethod = paymentMethod;
    }

    
    /*
     * Returns the amount of the payment
     * 
     * @return the amount of the payment 
     */
    public double getAmount() {
        return amount;
    }
    
    /*
     * Sets the amount of the payment
     * 
     * @param amount the amount of the payment
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    /*
     * Returns the date when the payment was made
     * 
     * @return the date when the payment was made      
     */
    public Date getDate() {
        return date;
    }
    
    /*
     * Sets the date when the payment was made
     * 
     * @param date the date when the payment was made
     */
    public void setDate(Date date) {
        this.date = date;
    }
    
    /*
     * Returns the payment method used for the payment
     * 
     * @return the payment method used for the payment
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }
    
    /*
     * Sets the payment method used for the payment
     * 
     * @param paymentMethod the payment method used for the payment
     */
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

}