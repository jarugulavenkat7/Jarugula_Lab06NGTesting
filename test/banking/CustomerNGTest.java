/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Class: 44542-02 Object Oriented Programming
 *
 * @author Venkat Sai Jarugula Description: Making sure everything works Due:
 * 03/17/21 I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or any source. I
 * have not given my code to any other student and will not share this code with
 * anyone under my circumstances.
 */
public class CustomerNGTest {

    static Customer customer;

    public CustomerNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        customer = new Customer("09/05/1993", "Bill", "Gates");
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        customer = null;
    }

    /**
     * Test of getDob method, of class Customer.
     */
    @Test
    public void testGetDob() {
        System.out.println("getDob");
        String expResult = "09/05/1993";
        String result = customer.getDob();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFirstName method, of class Customer.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        String expResult = "Bill";
        String result = customer.getFirstName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLastName method, of class Customer.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        String expResult = "Gates";
        String result = customer.getLastName();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Customer.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "Name: Gates, Bill" + "\n"
                + "Date of Birth: 09/05/1993";
        String result = customer.toString();
        assertEquals(expResult, result);
    }

}
