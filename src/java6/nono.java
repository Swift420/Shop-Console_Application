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
public class nono{ //Stock Class

String name;
       static HashMap<String, Integer> item_stock = new HashMap<String, Integer>(); //stores the item and the quantity it is available, in a hashmap
     static HashMap<String, Double> item_price = new HashMap<String, Double>(); // stores the item and its price, in a hashmap
     
      void addNewProduct(PaymentAndSales sales, BobCard card,Admin a,Teller t,nono n1){ //adds new products to the hashmap
         try{
          System.out.println("Enter the new Product Name");
         String item = scan.next();
         System.out.println("Enter the Quantity of the new Product");
         int stock = scan.nextInt();
         System.out.println("Enter the Price of the new Product");
         Double price = scan.nextDouble();
         
         item_stock.put(item, stock); //it adds items and the quantity its available in, to the hashmap
         item_price.put(item, price); // adds the items and its price, to the hashmap
             System.out.println("");
          System.out.println("Item Has been Successfully added");
          System.out.println("");
          System.out.println("Do you want to add another product?");
          String answer2 = scan.next();
          if(answer2.equalsIgnoreCase("yes")){
              addNewProduct(sales,card,a,t,n1); //if the admin wants to add more products, he/she will choose "yes" and the answer and the addNewProduct method is called again(Recursion)
          }else{
              stockManagement(sales,card,a,t,n1); // Else if they say no, they are taken back to the Stock Managment Screen
          }
         }catch(Exception e) {
             System.out.println("An Error Occured");
             stockManagement(sales,card,a,t,n1); // if an error occurs, it notifies the admin and takes them back to the stock Management screen
         
         }
         
     }
      
     
       void priceUpdate(PaymentAndSales sales, BobCard card,Admin a,Teller t,nono n1){ //changes the price of a product
           try{
                System.out.println("Enter Item");
                 String item = scan.next();
                 if(item_price.containsKey(item)){
                 System.out.println("Enter the new price");
                 double price = scan.nextDouble();
                 
                 System.out.println("The Old price for "+item +" was "+ item_price.get(item));
                     System.out.println("");
                     item_price.replace(item, price);
                     System.out.println("The new price for "+item +" is "+ item_price.get(item));
                     System.out.println("Do you want to Update another price for an item?");
                     String answer2 = scan.next();
                     if(answer2.equalsIgnoreCase("yes")){
                    priceUpdate(sales,card,a,t,n1); //recursion of the priceUpdate method, if the admin chooses to continue updating the prices, the updatePrice is called again
                          }else{
              stockManagement(sales,card,a,t,n1); // else if he chooses no, it takes them back to the stock Managment class
          }
                 
                 }else{
                     System.out.println("Incorrect Item");
                    stockManagement(sales,card,a,t,n1);
                 
                 }
           } catch(Exception e){
               System.out.println("Price Update Error Occured");
               
               stockManagement(sales,card,a,t,n1); //if an error occurs, it notifies and it takes it to the stock Management screen
           
           }
     
     }
         
       void stockUpdate(PaymentAndSales sales, BobCard card,Admin a,Teller t,nono n1){ //updates the stock levels of products
           try{
          System.out.println("Enter Item");
                 String item = scan.next();
                 if(item_stock.containsKey(item)){
                 System.out.println("Enter the new Stock Amount");
                 int stock1 = scan.nextInt();
                 
                 System.out.println("The Previous Stock for "+item +" was "+ item_stock.get(item));
                     System.out.println("");
                     int tot = item_stock.get(item) + stock1; // it gets the total of the current stock of the product and adds the new one you want to add
                     item_stock.replace(item, tot);  // this adds the new stock value to the hashmap
                     System.out.println("The new Stock level for "+item +" is now "+ item_stock.get(item));
                     System.out.println("");
                     System.out.println("Do you want to Update another product stock?");
                     String answer2 = scan.next();
                     if(answer2.equalsIgnoreCase("yes")){
                    stockUpdate(sales,card,a,t,n1); //recursion happens if the admin chooses to continue updating
                          }else{
              stockManagement(sales,card,a,t,n1);
          }
                     
                 }else{
                     System.out.println("Incorrect Item");
                    stockManagement(sales,card,a,t,n1);
                 
                 }
           }catch(Exception e){
               System.out.println("Stock update Error Occured");
               stockManagement(sales,card,a,t,n1);
           }
      }
       void removeProduct(PaymentAndSales sales, BobCard card,Admin a,Teller t,nono n1){ //removes the item from the list of products being sold
          try{
           System.out.println("Enter Item to be removed");
          String item = scan.next();
          if(item_stock.containsKey(item)){
                 item_stock.remove(item); //removes item and its stock levels from the hashmap
                 item_price.remove(item); //removes item and price from the hashmap
                 System.out.println("Item has been successfully removed");
                 System.out.println("");
                 System.out.println("Do you want to Remove another item");
                     String answer2 = scan.next();
                     if(answer2.equalsIgnoreCase("yes")){
                    removeProduct(sales,card,a,t,n1);
                          }else{
              stockManagement(sales,card,a,t,n1);
          }
                 
                 
          }else{
              System.out.println("Incorrect Item Entered");
              stockManagement(sales,card,a,t,n1);
          }
          }catch(Exception e){
              System.out.println("Remove Product Error Occured");
              stockManagement(sales,card,a,t,n1);
          }
      }
       void getProductDetails(PaymentAndSales sales, BobCard card,Admin a,Teller t,nono n1){ //this gets the details(price, quantity) of a specific product
           try{
          System.out.println("Enter Product Name");
          String item = scan.next();
          if(item_stock.containsKey(item)){
          System.out.println("***********************************");
          System.out.println("Product Name "+ item );
          System.out.println("Product Price "+ item_price.get(item));
          System.out.println("Product Stock Levels "+ item_stock.get(item));
          System.out.println("**********************************");
          }
          System.out.println("Do you want to get another product's details?");
          String answer2 = scan.next();
          if(answer2.equalsIgnoreCase("yes")){
              getProductDetails(sales,card,a,t,n1);
          }else{
              stockManagement(sales,card,a,t,n1);
          }
          System.out.println("");

          stockManagement(sales,card,a,t,n1);
           }catch(Exception e){
               System.out.println("An Error occured at getting product details");
           stockManagement(sales,card,a,t,n1);
           }
      
      }
          
        void checkStockLevels(PaymentAndSales sales, BobCard card,Admin a,Teller t,nono n1){ //displays all products and their stock levels
           for(String name: item_stock.keySet()){
               String key = name.toString();
               String value = item_stock.get(name).toString();
               System.out.println(key + " "+ value);
           }
           System.out.println("");
           stockManagement(sales,card,a,t,n1);
       
       }   
        void stockManagement(PaymentAndSales sales, BobCard card,Admin a,Teller t,nono n1){ // this is the main screen for the Stock management
            System.out.println("");
           System.out.println("Choose from 1 - 7");
           System.out.println("1.Add a new Product\n2.Update the stock levels\n3.Update the item price\n4.Check Stock Levels\n5.Get product Details\n6.Remove a product\n7.Admin Screen");
           try{
           String num = scan.next();
           switch(num){
               case "1":
                   addNewProduct(sales,card,a,t,n1);//adds new product 
                   break;
               case "2":
                   stockUpdate(sales,card,a,t,n1);//updates the stock levels
                   break;
               case "3":
                   priceUpdate(sales,card,a,t,n1);// update the prices
                   break;
               case "4": 
                   checkStockLevels(sales,card,a,t,n1); // prints out all products and their quanitites
                   break;
               case "5":
                   getProductDetails(sales,card,a,t,n1); // prints out the details of a single product
                   break;
               case "6": 
                   removeProduct(sales,card,a,t,n1); //removes a product from the list that are being sold
                   break;
               case "7":
                   a.adminHomeScreen(sales, card, a, t,n1); //takes the admin to the admin homescreen
                   break;
               default:
                   System.out.println("Please Choose numbers from 1 - 7");
                   stockManagement(sales, card, a, t,n1); //default if the admin chooses the wrong number, which will bring them back to the same screen
                   break;
           }
           }catch(Exception e){
               System.out.println("An Error Occured");
               System.out.println("Diverting to Admin Home Screen");
               a.adminHomeScreen(sales, card, a, t, n1);
           }
       
       } 
}
