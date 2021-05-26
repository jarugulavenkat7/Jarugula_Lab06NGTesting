/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

/**
 * Class: 44542-02 Object Oriented Programming
 *
 * @author Venkat Sai Jarugula Description: Making sure everything works Due:
 * 03/17/21 I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or any source. I
 * have not given my code to any other student and will not share this code with
 * anyone under my circumstances.
 */
public class Account {

    private long accountNumber;
    private Customer customer;
    private double balance;
    private ArrayList<Transaction> transactions;
    private boolean hasLimitedWithdrawals;
    private static final double SAVING_INTEREST = 5.80;

    /**
     * Constructs the account with the parameters accountNumber,customer and hasLimitedWithdrawals
     * @param accountNumber Bank Account number
     * @param customer Customer of an account
     * @param hasLimitedWithdrawals Withdrawal limit for current month.
     */
    public Account(long accountNumber, Customer customer, boolean hasLimitedWithdrawals) {
        this.accountNumber = accountNumber;
        this.customer = customer;
        this.hasLimitedWithdrawals = hasLimitedWithdrawals;
        this.transactions = new ArrayList<>();

    }

    /**
     * Returns the account number of the account
     * @return Returns the account number of the account
     */
    public long getAccountNumber() {
        return accountNumber;
    }

    /**
     *Sets the account number of the account
     * @param accountNumber The accountNumber to set
     */
    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * Returns customer object
     * @return Returns customer object
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     *Sets customer object
     * @param customer the customer object to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Returns the balance in the account
     * @return Returns the balance 
     */
    public double getBalance() {
        return balance;
    }

    /**
     *Sets the balance in the account
     * @param balance The balance  to set
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Returns the list of transactions in the account
     * @return Returns the list of transactions
     */
    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    /**
     *Sets the list of transactions in the account
     * @param transactions The transactions list to set
     */
    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    /**
     *Returns  whether the account has limited withdrawals or not 
     * @return Returns  whether the account has limited withdrawals or not
     */
    public boolean isHasLimitedWithdrawals() {
        return hasLimitedWithdrawals;
    }

    /**
     * Sets whether the account has limited withdrawals or not 
     * @param hasLimitedWithdrawals Sets whether the account has limited withdrawals or not
     */
    public void setHasLimitedWithdrawals(boolean hasLimitedWithdrawals) {
        this.hasLimitedWithdrawals = hasLimitedWithdrawals;
    }

    /**
     * Returns the generated statement of the account
     * @return Returns the generated statement of the account
     */
    public String generateStatement() {
        String statement = "\n" + customer.toString()
                + "\nAccount Number: " + accountNumber
                + "\nAccount Information:-   " + "Interest Rate: " + String.format("%.2f", SAVING_INTEREST) + "%"
                + "\nTransaction Limit for withdrawal: " + (hasLimitedWithdrawals == true ? "7 Transactions" : 
                "No Limit")
                + "\n-------------------------------------------------------------------------------"
                + "\n" + String.format("%-19s %-24s %-15s %-24s %-9s %n",
                        "Transaction Type", "Transaction Time", "Amount", "Additional Charges", "Status");
        for (Transaction transaction : transactions) {
            statement += transaction.toString();
        }
        statement += "\n-------------------------------------------------------------------------------"
                + "\nCurrent Balance: " + String.format("%.2f", balance) + "     Interest: $" +
                String.format("%.2f", (balance * SAVING_INTEREST / 100))
                + "\n************************************************************************";
        return statement;
    }

    /**
     * Returns the number of withdrawals 
     * @return Returns the number of withdrawals 
     */
    public int getNoofWithdrawals() {

        int currentMonthValue = LocalDateTime.now().getMonthValue();
        int numberOfTransactions = 0;
        for (Transaction transaction : transactions) {
            if (transaction.getTransactionType().equals("WITHDRAW") && 
                    transaction.getTransactionTime().getMonthValue() == currentMonthValue) {
                numberOfTransactions += 1;
                //withDrawalTrans.add(transaction);
            }
        }
        return numberOfTransactions;
    }

    /**
     * Returns the transaction status
     * @param transaction 
     * @return Returns the transaction status
     */
    public String makeTransaction(Transaction transaction) {
        transactions.add(transaction);
        String transactionStatus = "";
        if ((transaction.getTransactionType().equals("WITHDRAW")
                || transaction.getTransactionType().equals("ONLINEPURCHASE"))
                && balance < transaction.getAmount()) {
            transaction.setAdditionalCharges(0.0);
            transaction.setStatus("FAILED");
            transactionStatus = "Insufficient Balance";
        } else {
            if (transaction.getTransactionType().equals("DEPOSIT")) {
                transaction.setStatus("SUCCESS");
                balance = balance + transaction.getAmount();
                transactionStatus = "Transaction Successful";
            } else if (transaction.getTransactionType().equals("ONLINEPURCHASE")) {
                transaction.setStatus("SUCCESS");
                transaction.setAdditionalCharges(1.99);
                balance = balance - (transaction.getAmount() + transaction.getAdditionalCharges());
                transactionStatus = "Transaction Successful";
            } else if (transaction.getTransactionType().equals("WITHDRAW")) {
                if (balance > transaction.getAmount() && hasLimitedWithdrawals == false) {
                    if (getNoofWithdrawals() > 6) {
                        if (transaction.getAmount() * 0.01 > 2.59) {
                            transaction.setAdditionalCharges(transaction.getAmount() * 0.01);
                        } else {
                            transaction.setAdditionalCharges(2.59);
                        }
                        transaction.setStatus("SUCCESS");
                        balance = balance - (transaction.getAmount() + transaction.getAdditionalCharges());
                        transactionStatus = "Transaction Successful";
                    } else {
                        transaction.setStatus("SUCCESS");
                        balance = balance - (transaction.getAmount());
                        transactionStatus = "Transaction Successful";
                    }
                } else {
                    if (getNoofWithdrawals() > 6) {
                        transaction.setStatus("FAILED");
                        transactionStatus = "MaxTransactions";
                    } else {
                        transaction.setStatus("SUCCESS");
                        balance = balance - transaction.getAmount();
                        transactionStatus = "Transaction Successful";
                    }
                }

            }
        }

        
        return transactionStatus;
    }

}
