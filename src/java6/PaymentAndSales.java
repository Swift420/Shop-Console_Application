/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java6;

import java.util.ArrayList;
import java.util.Scanner;
import static java6.nono.item_price;
import static java6.nono.item_stock;

/**
 *
 * @author Apollos
 */
public class PaymentAndSales implements IObservable{
    Scanner scan = new Scanner(System.in);
    double total1;
    String answer;
    String item;
     boolean  stay_in_loop;
     double totalItems;
    private ArrayList<BobCard> cards = new ArrayList<>(); //stores a list of the Bobcard objects

    @Override
    public void register(BobCard c) { // Registers the bobcard to be used for transactions
        cards.add(c);
    }

    @Override
    public void deregister(BobCard c) { //de registers the bobcard that was used for transactions when it is done being used.
        cards.remove(c);
    }

    @Override
    public void notify1(Double price) { //Notifies the Csutomer Account to call the update method when a transcation has been complete, so subtract money from the balance of the account
        for(BobCard c : cards){
            c.update(c, price);
        }
    }
   
    public boolean AccountVerification(BobCard c){ //It verifies if the card number and card pin entered is correct
        
        System.out.println("Card Number");
        int cardNumber1 = scan.nextInt();
        System.out.println("Card Pin");
        int cardPin1 = scan.nextInt();
        
        return cardNumber1==c.cardNumber && cardPin1 == c.cardPin;
    
    }
    public void sellItem(BobCard c){ // It enables the sale of items, The sellItem method is part of the sell method
        System.out.println("Enter Item");
        item = scan.next();
        if(item_stock.containsKey(item)){
        System.out.println("Amount of products you want");
        totalItems = scan.nextInt();
       
        total1 = item_price.get(item) * totalItems;
        
        if(item_stock.get(item) > totalItems){ //it checks if the is enough stock of the products that the customer wants to buy, if the isn't it gives a message that the isnt enough stock of the product to be sold
            if(c.getBalance() >= total1){ //it checks if the is enough funds on the customer account, in order to complete the transaction
                item_stock.put(item, item_stock.get(item)-(int)totalItems);
                notify1(total1); // calls the notify method, which calls the update method to change the balance on the customer account
               
                
                
            }else{
            System.out.println("Card Verification Not Accepted");
            
        }
    
    }else {
            System.out.println("Not enough stock");
        }
    }else{
            System.out.println("No Such Item");
            sellItem(c);
        }}
    
    public void sell( BobCard c){ //Sell method allows sales to happen but it has account verification, and transactions will not happen if card details entered are wrong
                                   // The sellItem method is part of the sell method
        
        try{
        if(AccountVerification(c) == true){
            try{sellItem(c);
            
            System.out.println("Do you want to  sell another item?Yes or No");
                answer = scan.next();
            }catch(Exception e){
                
                sell(c);
            
            }
        }else{
            System.out.println("Wrong Account Details");
            sell(c);
        }}catch(Exception e){
                System.out.println("An Exception Happened");
                sell(c);
                
                } 
    
        
    }
    public void paymentScreen(BobCard c){
        stay_in_loop = true;
        PaymentAndSales p3 = new PaymentAndSales();
        Teller t3 = new Teller();
        nono n3 = new nono();
        Admin a3 = new Admin();
        
            System.out.println("Select an option");
            System.out.println("1.Sell item\n2.Login As Admin");
            String selection = scan.next();
            
            switch(selection){ //The are 2 options to be chosen, either sell a product or login as an admin
                case "1":
                    try{
                    sell(c);
                    
                   
                while(answer.equalsIgnoreCase("yes"))
                {
                    sellItem(c);
                    System.out.println("Do you want to  sell another item?Yes or No");
                    answer = scan.next();
                    if(answer.equalsIgnoreCase("no")){
                        p3.paymentScreen(c);
                    }
                
                }}catch(Exception e){
                        System.out.println("An Error Occured");
                        sell(c); // if an error occurs, during the sale of an item (or while the sell method is in session), the error will be caught and the sell method will be called again, allowing the sale of items to continue
                }
                    break;
                case "2":
                    a3.adminLogin(this, c, a3, t3, n3); // takes the user to the admin login  screen
                    
                default:
                    
                    paymentScreen(c);
                    
            
            }
            
        
        
    
    }
    
    
}
