/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java6;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java6.PaymentAndSales;
import static java6.nono.item_price;
import static java6.nono.item_stock;
import static java6.Teller.adminName_password;
import static java6.Teller.makeSales;
import static java6.Teller.tellerName_password;
import static java6.User.scan;


public class Java6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        BobCard b1 = new BobCard(1234,987654); // create an Bobcard object, with the pin number 1234 and Card Number of 987654
        PaymentAndSales s1 = new PaymentAndSales(); // paymentAndSales object
        Admin a1 = new Admin(); //Admin object
        nono n1 = new nono(); //nono (Stock Management) object
        Teller t1 = new Teller(); //teller object
        b1.deposit(10000.00); //Deposit 10000 in the account of the bobcard b1
        
        s1.register(b1); //register the bobcard so it will be able to make transactions with the system.
        
        //The items, their prices and how many of them are in stock
        item_price.put("GTA5", 80.00); 
        item_stock.put("GTA5", 30);
        item_price.put("COD4", 50.00);
        item_stock.put("COD4", 10);
        item_price.put("Minecraft", 27.95);
        item_stock.put("Minecraft", 20);
        item_price.put("AC2", 35.00);
        item_stock.put("AC2", 3);
        
        // The tellers and the admins, with their details (username, password)
        tellerName_password.put("Apollos", "Zeus");   
        tellerName_password.put("Kagwedha", "Odin"); 
        adminName_password.put("Jason", "Thor");
        adminName_password.put("Provi", "Kratos");
        
        t1.tellerHomeScreen(s1, b1, a1, t1, n1); // This is the Homescreen, what the system first displays
        s1.deregister(b1); // De register the bobcard b1 after done with transactions, so it wont be able to make transactions with the system anymore
        
        //System.out.println(b1.getBalance()); -> check if money has been deducted.
       
        
    }

    
    
}

interface IObserver{
    void update(BobCard c, Double price); // this updates the balance of the account for the Bobcard when it has done a transaction.
}

class BobCard extends CustomerAccount implements IObserver{ //Bobcard extends the customer account and inherits everything from it. 
    int cardPin;
    int cardNumber;
    
    BobCard(int cardPin, int cardNumber){ // Constructor of BObCard, it takes cardPin and CardNumber so when a bobcard object is created, it is created with a pin and a Card Number
        this.cardNumber = cardNumber;
        this.cardPin = cardPin;
    
    }
    int getCardpin(){ // Gets the pin of the card
        return cardPin;
    }
    int getCardNumber(){ //Gets the Number of the card
        return cardNumber;
    }
    @Override
    public void update(BobCard c, Double price){ //this updates the balance of the account for the Bobcard when it has done a transaction., it is implemented from the IObserver interface
        Double x = c.getBalance() - price;
        c.deposit(x);
    }

}

class CustomerAccount extends Bank{ // This keeps the balance which is on the bobcard, and inherits everything from the Bank class
    private Double balance;

    public  Double getBalance() { // Gets the Balance on the account
        return balance;
    }

    public void deposit(Double balance) { //Deposits money onto the account
        this.balance = balance;
    }
    
    

}




interface User{
    Scanner scan = new Scanner(System.in);
    
    
    static HashMap<String,String> tellerName_password = new HashMap<String,String>(); //stores the Login details for the Tellers, using key and value of a hashmap
    static HashMap<String,String> adminName_password = new HashMap<String,String>(); // stores the Login details for the admins, using key and value of a hashmap
    void tellerLogin(PaymentAndSales sales, BobCard card,Admin a, Teller t,nono n1); // method called to log in the teller
    void adminLogin(PaymentAndSales sales, BobCard card,Admin a, Teller t,nono n1); // method called to log in the admin
    void logout(PaymentAndSales sales, BobCard card,Admin a, Teller t,nono n1); //method called to logout as a teller or an admin, depending on which is logged in
}





class Bank{ //Has the bank details of the Customer Account
    final String  BANKNAME = "Anon Bank";
    final String DATE_BUILT = "20-04-2018";
    final String LOCATION = "Sweden";
    

}



