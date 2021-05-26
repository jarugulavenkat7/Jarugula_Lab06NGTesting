/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
public class TransactionNGTest {

    static Transaction transaction;
    Account account;
    Customer customer;

    public TransactionNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d H:m:s");
        transaction = new Transaction("DEPOSIT", 1000.00, LocalDateTime.parse("2021-02-02 08:42:02", formatter));
        account= new Account(3429587739L, customer, true);
        customer= new Customer("Clint","Barton","09/23/1994");
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction);
        account.setTransactions(transactions);
        
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
       transaction= null;
    }

    /**
     * Test of getAdditionalCharges method, of class Transaction.
     */
    @Test
    public void testGetAdditionalCharges() {
        System.out.println("getAdditionalCharges");
       // Transaction instance = null;
        double expResult = 0.0;
        double result = transaction.getAdditionalCharges();
        assertEquals(result, expResult, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    

    /**
     * Test of getAmount method, of class Transaction.
     */
    @Test
    public void testGetAmount() {
        System.out.println("getAmount");
       // Transaction instance = null;
        double expResult = 1000.0;
        double result = transaction.getAmount();
        assertEquals(result, expResult, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    

    /**
     * Test of getStatus method, of class Transaction.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        Transaction instance = null;
        String expResult = "";
        String result = instance.getStatus();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setStatus method, of class Transaction.
     */
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        String status = "";
        Transaction instance = null;
        instance.setStatus(status);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getTransactionTime method, of class Transaction.
     */
    @Test
    public void testGetTransactionTime() {
        System.out.println("getTransactionTime");
       // Transaction instance = null;
        LocalDateTime expResult = null;
        LocalDateTime result = transaction.getTransactionTime();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    
    /**
     * Test of getTransactionType method, of class Transaction.
     */
    @Test
    public void testGetTransactionType() {
        System.out.println("getTransactionType");
        //Transaction instance = null;
        String expResult = "";
        String result = transaction.getTransactionType();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

  

    /**
     * Test of toString method, of class Transaction.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        
        String expResult = "DEPOSIT             2021-02-02T08:42:02      1000.00         0.00                     SUCCESS   ";
        String result = account.getTransactions().toString();
        System.out.println(expResult);
        System.out.println(result);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.

    }

}
