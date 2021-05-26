/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;

import java.time.LocalDateTime;

/**
 * Class: 44542-02 Object Oriented Programming
 *
 * @author Venkat Sai Jarugula Description: Making sure everything works Due:
 * 03/17/21 I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or any source. I
 * have not given my code to any other student and will not share this code with
 * anyone under my circumstances.
 */
public class Transaction {

    private double additionalCharges;
    private double amount;
    private String status;
    private LocalDateTime transactionTime;
    private String transactionType;

    /**
     * Constructs transaction with the parameters transactionType, amount and transactionTime
     * @param transactionType
     * @param amount
     * @param transactionTime
     */
    public Transaction(String transactionType, double amount, LocalDateTime transactionTime) {
        this.transactionType = transactionType;
        this.amount = amount;
        this.transactionTime = transactionTime;

    }

    /**
     * Returns additional charges
     * @return Returns additional charges
     */
    public double getAdditionalCharges() {
        return additionalCharges;
    }

    /**
     * Sets additional charges
     * @param additionalCharges  additional charges to set
     */
    public void setAdditionalCharges(double additionalCharges) {
        this.additionalCharges = additionalCharges;
    }

    /**
     * Returns amount in the transaction
     * @return Returns amount in the transaction
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Sets amount in the transaction
     * @param amount The amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Returns the status of the transaction
     * @return Returns the status of the transaction
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the transaction
     * @param status The status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Returns the transaction time
     * @return  Returns the transaction time
     */
    public LocalDateTime getTransactionTime() {
        return transactionTime;
    }

    /**
     * Sets the transaction time
     * @param transactionTime The transaction time to set
     */
    public void setTransactionTime(LocalDateTime transactionTime) {
        this.transactionTime = transactionTime;
    }

    /**
     * Returns the transaction type
     * @return Returns the transaction type
     */
    public String getTransactionType() {
        return transactionType;
    }

    /**
     * Sets the transaction type
     * @param transactionType The transaction type to set
     */
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    /**
     * Returns transaction object in string format
     * @return Returns transaction object in string format
     */
    @Override
    public String toString() {

        return "\n" + String.format("%-19s %-24s %-15s %-24s %-9s %n", transactionType, transactionTime, String.format("%.2f", amount), String.format("%.2f", additionalCharges), status);
    }

}
