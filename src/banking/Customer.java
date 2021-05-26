/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;

/**
 * Class: 44542-02 Object Oriented Programming
 *
 * @author Venkat Sai Jarugula Description: Making sure everything works Due:
 * 03/17/21 I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or any source. I
 * have not given my code to any other student and will not share this code with
 * anyone under my circumstances.
 */
public class Customer {

    private String dob;
    private String firstName;
    private String lastName;

    /**
     * Constructs customer with dob, firstName and  lastName
     * @param dob Date of birth of customer. (DD/MM/YYYY)
     * @param firstName First Name of the customer.
     * @param lastName Last Name of the customer.
     */
    public Customer(String dob, String firstName, String lastName) {
        this.dob = dob;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Returns date of birth of the customer 
     * @return Returns date of birth
     */
    public String getDob() {
        return dob;
    }

    /**
     * Sets the date of birth of the customer
     * @param dob The dob to set
     */
    public void setDob(String dob) {
        this.dob = dob;
    }

    /**
     * Returns the first name of the customer
     * @return Returns the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the customer
     * @param firstName The firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the last name of the customer
     * @return Returns the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the customer
     * @param lastName The lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the customer object in string format
     * @return Returns the customer object in string format
     */
    @Override
    public String toString() {
        return "Name: " + lastName + ", " + firstName + "\nDate of Birth: " + dob;
    }

}
