/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class: 44542-02 Object Oriented Programming
 *
 * @author Venkat Sai Jarugula Description: Making sure everything works Due:
 * 03/17/21 I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or any source. I
 * have not given my code to any other student and will not share this code with
 * anyone under my circumstances.
 */
public class BankDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        //Note: (i). You can create any variables required within the main method but not as global/instance variables.
        //      (ii). The dates times provided for the transaction times are in yyyy-MM-dd HH:mm:ss
        // 1. Create an arraylist of Accounts and name it as accounts to store the list of accounts
        ArrayList<Account> accounts = new ArrayList<>();
        // 2. Create a scanner object and name it as sc to read the input from keyboard
        Scanner sc = new Scanner(new File("input.txt"));
        while (sc.hasNext("newAccount")) {
            sc.nextLine();
            // 3. Read the values account type, first name, last name, date of birth from the input file
            String firstName = sc.next();
            String lastName = sc.nextLine();
            String dob = sc.nextLine();

            long accountNumber = sc.nextLong();

            boolean hasLimitedWithdrawals = sc.nextBoolean();

            // 4. Create an Customer object.
            Customer customer = new Customer(dob, firstName, lastName);
            // 5. Create an Account object.
            Account account = new Account(accountNumber, customer, hasLimitedWithdrawals);

            // 6. Print full name of the customer.
            System.out.println("\n------------------------------------------------------------");
            System.out.println("Name of the customer: " + customer.getFirstName() + " " + customer.getLastName());

            System.out.println("------------------------------------------------------------");

            sc.nextLine();
            while (sc.hasNext("DEPOSIT") || sc.hasNext("WITHDRAW") || sc.hasNext("ONLINEPURCHASE")) {
                //     a. Read trasaction and a create transaction object by initalizing the multiple argument constructor.

                String completeLine = sc.nextLine();
                String[] transactionLine = completeLine.split(" ");

                String transactionType = transactionLine[0];

                double amount = Double.parseDouble(transactionLine[1]);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d H:m:s");
                LocalDateTime transactionTime = LocalDateTime.parse(transactionLine[2] + " " + transactionLine[3], formatter);

                Transaction transaction = new Transaction(transactionType, amount, transactionTime);

                //     b. call makeTransaction() method on account object.
                String transactionValue = account.makeTransaction(transaction);

                //     c. Print appropiate message upon completing each transaction based on return value of makeTransaction().
                //if makeTransaction returns "Insufficient Balance" print "Insufficient funds. Available funds: {funds}".
                if (transactionValue.equals("Insufficient Balance")) {
                    System.out.println("Insufficient funds. Available funds: " + String.format("%.2f", Math.round(account.getBalance() * 100) / 100.0));
                } //  where {funds} is the available funds on account.
                //if makeTransaction returns "MaxTransactions" print "Exceeded number of withdrawals transactions. Number of available withdrawals per month: 6"
                else if (transactionValue.equals("MaxTransactions")) {
                    System.out.println("Exceeded number of withdrawals transactions. Number of available withdrawals per month: 6");
                } //if makeTransaction returns "Transaction Successful" then print "The balance after {transactionType} in dollars is {funds}"
                else if (transactionValue.equals("Transaction Successful")) {
                    System.out.println("The balance after " + transaction.getTransactionType() + " in dollars is " + String.format("%.2f", Math.round(account.getBalance() * 100) / 100.0));
                }
                //  where {transactionType} is type of transaction.

            }
            // 10. Add Account object to accounts Arraylist.
            accounts.add(account);
        }
        // Print "Invoke getNoofWithdrawals() on SavingsAccount objects"
        System.out.println("************************************************************************");
        System.out.println("*********Invoke getNoofWithdrawals() on Account objects**********");
        System.out.println("************************************************************************");
        for (Account account : accounts) {

            System.out.println(account.getCustomer().getFirstName() + " made " + (account.getNoofWithdrawals()) + " withdrawals in this month.");
        }
        // 11(a). For each Account from accounts, invoke getNoofWithdrawals() method on SavingsAccount objects
        // 11(b). Print number of withdrawls made in this month for each account.

        // Print "Invoke generateStatement() on all objects in accounts ArrayList"
        // 12. Invoke generateStatement() method on all objects in accounts ArrayList and print all account statements
        System.out.println("***********************************************************************");
        System.out.println("****Invoke generateStatement() on all objects in accounts ArrayList****");
        System.out.println("************************************************************************");

        for (Account account : accounts) {
            System.out.println(account.generateStatement());
        }

    }

}
