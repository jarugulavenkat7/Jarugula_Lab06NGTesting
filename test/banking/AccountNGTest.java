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
public class AccountNGTest {

    static Account account;
    static Customer customer;

    public AccountNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        customer = new Customer("10/20/1990", "Pepper", "Potts");
        account = new Account(3454543934L, customer, false);
        ArrayList<Transaction> transactions = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d H:m:s");
        Transaction transaction1 = new Transaction("DEPOSIT", 100.00, LocalDateTime.parse("2021-01-22 01:05:12", formatter));
        Transaction transaction2 = new Transaction("WITHDRAW", 300.00, LocalDateTime.parse("2021-2-11 11:05:31", formatter));
        Transaction transaction3 = new Transaction("WITHDRAW", 400.00, LocalDateTime.parse("2021-02-25 09:05:12", formatter));
        Transaction transaction4 = new Transaction("DEPOSIT", 200.00, LocalDateTime.parse("2021-03-01 11:32:11", formatter));
        Transaction transaction5 = new Transaction("ONLINEPURCHASE", 136.65, LocalDateTime.parse("2020-10-03 7:2:23", formatter));
        Transaction transaction6 = new Transaction("WITHDRAW", 300.00, LocalDateTime.parse("2021-03-18 10:01:45", formatter));
        Transaction transaction7 = new Transaction("ONLINEPURCHASE", 209.84, LocalDateTime.parse("2021-03-22 12:01:01", formatter));
        Transaction transaction8 = new Transaction("ONLINEPURCHASE", 7.99, LocalDateTime.parse("2021-03-25 12:2:01", formatter));
        Transaction transaction9 = new Transaction("WITHDRAW", 300.00, LocalDateTime.parse("2021-03-28 14:25:12", formatter));
        transactions.add(transaction1);
        account.makeTransaction(transaction1);
        transactions.add(transaction2);
        account.makeTransaction(transaction2);
        transactions.add(transaction3);
        account.makeTransaction(transaction3);
        transactions.add(transaction4);
        account.makeTransaction(transaction4);
        transactions.add(transaction5);
        account.makeTransaction(transaction5);
        transactions.add(transaction6);
        account.makeTransaction(transaction6);
        transactions.add(transaction7);
        account.makeTransaction(transaction7);
        transactions.add(transaction8);
        account.makeTransaction(transaction8);
        transactions.add(transaction9);
        account.makeTransaction(transaction9);
        account.setTransactions(transactions);

    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of generateStatement method, of class Account.
     */
    @Test
    public void testGenerateStatement() {
        System.out.println("generateStatement");
        Account instance = null;
        String expResult = "Name: Potts, Pepper\n" +
"Date of Birth: 10/20/1990\n" +
"Account Number: 3454543934\n" +
"Account Information:-   Interest Rate: 5.80%\n" +
"Transaction Limit for withdrawal: No Limit\n" +
"-------------------------------------------------------------------------------\n" +
"Transaction Type    Transaction Time         Amount          Additional Charges       Status    \n" +
"\n" +
"DEPOSIT             2021-01-22T01:05:12      100.00          0.00                     SUCCESS   \n" +
"\n" +
"WITHDRAW            2021-02-11T11:05:31      300.00          0.00                     FAILED    \n" +
"\n" +
"WITHDRAW            2021-02-25T09:05:12      400.00          0.00                     FAILED    \n" +
"\n" +
"DEPOSIT             2021-03-01T11:32:11      200.00          0.00                     SUCCESS   \n" +
"\n" +
"ONLINEPURCHASE      2020-10-03T07:02:23      136.65          1.99                     SUCCESS   \n" +
"\n" +
"WITHDRAW            2021-03-18T10:01:45      300.00          0.00                     FAILED    \n" +
"\n" +
"ONLINEPURCHASE      2021-03-22T12:01:01      209.84          0.00                     FAILED    \n" +
"\n" +
"ONLINEPURCHASE      2021-03-25T12:02:01      7.99            1.99                     SUCCESS   \n" +
"\n" +
"WITHDRAW            2021-03-28T14:25:12      300.00          0.00                     FAILED    \n" +
"\n" +
"-------------------------------------------------------------------------------\n" +
"Current Balance: 151.38     Interest: $8.78\n" +
"************************************************************************";
        String result = account.generateStatement();
        System.out.println(result);
        
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getNoofWithdrawals method, of class Account.
     */
    @Test
    public void testGetNoofWithdrawals() {
        System.out.println("getNoofWithdrawals");
        int expResult = 2;
        int result = account.getNoofWithdrawals();
        System.out.println(result);
        
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of makeTransaction method, of class Account.
     */
    @Test
    public void testMakeTransaction() {
        System.out.println("makeTransaction");
        Transaction transaction = new Transaction("DEPOSIT", 15000.00, LocalDateTime.parse("2021-01-10T08:42:02"));
        String expResult = "Transaction Successful";
        String result = account.makeTransaction(transaction);

        assertEquals(result, expResult);

        // TODO review the generated test code and remove the default call to fail.
    }

}
