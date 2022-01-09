/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java6;

import java.util.HashMap;
import static java6.User.scan;

/**
 *
 * @author Apollos
 */
public class Admin implements User{
    String username;
    String password;
    static HashMap<String,String> tellerName_password = new HashMap<String,String>(); //stores the login details for the teller (username, password)
    static HashMap<String,String> adminName_password = new HashMap<String,String>(); //stores the login details for the admin (username,passwrod)
    
    

    @Override
    public void tellerLogin(PaymentAndSales sales, BobCard card,Admin a,Teller t,nono n1) {
       
    }

    @Override
    public void adminLogin(PaymentAndSales sales, BobCard card,Admin a, Teller t,nono n1) { //enables admins to login
          
        System.out.println("Enter username");
     username = scan.next();   
        System.out.println("Enter Password");
     password = scan.next();
    
     if(adminName_password.containsKey(username) && adminName_password.containsValue(password)){ //checks if the admin login details are correct, by checking if username and password entered are in the hashmap
         System.out.println(); 
         System.out.println("Welcome "+ username); 
           
         adminHomeScreen(sales, card, a,t,n1); // takes the admin to the admin Homescreen if details entered were correct
     
     }else{
         System.out.println("Wrong admin details");
         t.tellerHomeScreen(sales, card, a, t,n1);
     }
    }
    
    void addTeller(PaymentAndSales sales, BobCard card,Admin a, Teller t,nono n1){ //adds a new teller to the hashmap, with their own login details
        System.out.println("Teller Name");
        String teller1 = scan.next();
        System.out.println("Teller Password");
        String password1 = scan.next();
        
        
        tellerName_password.put(teller1, password1);
        System.out.println("Do you want to Add another Teller? ");
        String answer= scan.next();
        if(answer.equalsIgnoreCase("yes")){
        addTeller(sales,card,a,t,n1);
        }else{
        adminHomeScreen(sales,card,a,t,n1);
        }
    }
    
    void removeTeller(PaymentAndSales sales, BobCard card,Admin a, Teller t,nono n1){ // removes a teller from the list of tellers(removes teller from hashmap)
        System.out.println("Teller Name");
        String teller1 = scan.next();
        
        if(tellerName_password.containsKey(teller1)){
        tellerName_password.remove(teller1);
        }else{
            System.out.println("No such Teller");
        }
        System.out.println("Do you want to Remove another Teller? ");
        String answer= scan.next();
        if(answer.equalsIgnoreCase("yes")){
        removeTeller(sales,card,a,t,n1);
        }else{
        adminHomeScreen(sales,card,a,t,n1);
        }
    
    }
    
    void adminHomeScreen(PaymentAndSales sales, BobCard card,Admin a, Teller t,nono n1){ //Home screen for admins
        
        System.out.println("Select an option");
        System.out.println("1.Add a new Teller\n2.Remove a Teller\n3.Login as a Teller\n4.Stock Management\n5.Logout");
        try{
        String choice = scan.next();
        switch(choice){
            case "1":
                addTeller(sales,card,a,t,n1); 
                break;
            case "2":
                removeTeller(sales,card,a,t,n1);
                break;
            case "3":
                t.tellerLogin(sales,card,a,t,n1);
                break;
                
            case "4":
                n1.stockManagement(sales, card, a, t,n1); //takes the admin to the stock Management Screen
            case "5":
                logout(sales,card,a,t,n1); //logs out as an admin
                break;
            default:
                adminHomeScreen(sales,card,a,t,n1);
        }     
        
        }catch(Exception e){
            
            System.out.println("An Error has Occured");
            System.out.println("Program Restart!!!");
            t.tellerHomeScreen(sales, card, a, t, n1);
        }
    }

    @Override
    public void logout(PaymentAndSales sales, BobCard card,Admin a, Teller t,nono n1) {
        t.tellerHomeScreen(sales, card, a, t,n1);
    }


}