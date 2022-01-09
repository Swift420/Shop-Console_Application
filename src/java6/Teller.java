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
public class Teller implements User{
    
    String username;
    String password;
    static HashMap<String,String> tellerName_password = new HashMap<String,String>(); //stores the login details for the teller (username, password)
    static HashMap<String,String> adminName_password = new HashMap<String,String>(); //stores the login details for the admin (username, password)
    
    
    @Override
    public void tellerLogin(PaymentAndSales sales, BobCard card,Admin a, Teller t,nono n1) { //enables a teller to login
        
        System.out.println("Enter username");
     username = scan.next();   
        System.out.println("Enter Password");
     password = scan.next();
    
    
    
    
     if(tellerName_password.containsKey(username) && tellerName_password.containsValue(password)){ //checks if login details that the teller entered are valid
         System.out.println("Authentification complete");
         System.out.println("Welcome "+ username);
         caseTeller(sales,card,a,t,n1);
         
         
     }else{
         System.out.println("Wrong Teller Details");
         tellerHomeScreen(sales,card,a,t,n1);
     }
     
     
    }
    
    void caseTeller(PaymentAndSales sales, BobCard card,Admin a, Teller t,nono n1){
        System.out.println("Please Select an Option");
         System.out.println("1.Make sales\n2.Login As an Admin\n3.Logout");
         try{
         int answer = scan.nextInt();
         
         switch(answer){
             case 1:
                 makeSales(sales,card); //enables the teller to make sales
                 break;
             case 2:
                 adminLogin(sales, card, a,t,n1); //enables an admin to login 
                 break;
             case 3:
                 logout(sales,card,a,t,n1); //logs out as a teller
                 break;
             default:
                 System.out.println("Choose only between 1 to 3");
                 caseTeller(sales,card,a,t,n1);

         }}catch(Exception e){
             caseTeller(sales,card,a,t,n1);
         }
    
    }
   static void makeSales(PaymentAndSales sales, BobCard card){
        sales.paymentScreen(card);
    
    }
   
   void landingScreen(){ // this is the first thing that displays
       System.out.println("**************************************");
        System.out.println("*  Welcome to Anonymous Game Shop    *");
        System.out.println("*  The Finest Game Shop World Wide   *");
        System.out.println("*  Where the Elite are Recognised    *");
        System.out.println("*  Where the Best Games are Supplied *");
        System.out.println("**************************************");
        
   }
    
    void tellerHomeScreen(PaymentAndSales sales, BobCard card,Admin a, Teller t,nono n1){ // this is the home screen
        landingScreen();
        System.out.println("");
        System.out.println("1.Teller Login\n2.Admin Login");
        String choice = scan.next();
        
        switch(choice){
            case "1":
                tellerLogin(sales,card,a,t,n1);
                break;
            case "2":    
                adminLogin(sales, card, a,t,n1);
            default:
                System.out.println();
                System.out.println("Choose only between 1 and 2");
                tellerHomeScreen(sales,card,a,t,n1);
        }
    
    
    }

    @Override
    public void adminLogin(PaymentAndSales sales, BobCard card,Admin a, Teller t,nono n1) { //enables logging in as an admin
        System.out.println("Enter username");
     username = scan.next();   
        System.out.println("Enter Password");
     password = scan.next();
    
     if(adminName_password.containsKey(username) && adminName_password.containsValue(password)){
         System.out.println();
         System.out.println("Welcome "+ username); 
         
         a.adminHomeScreen(sales, card, a,t,n1);
     
     }else{
         System.out.println("Wrong admin details");
         tellerHomeScreen(sales, card, a, t,n1);
     }
    
    }

    @Override
    public void logout(PaymentAndSales sales, BobCard card,Admin a, Teller t,nono n1) { //allows a teller to logout
        tellerHomeScreen(sales,card,a,t,n1);
    }



}
