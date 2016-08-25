/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author zainal
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException{
        System.out.println("Welcome to the AUCTION PROGRAM!");
        System.out.println("\n[Menu]");
        System.out.println("(1) Display");
        System.out.println("(2) Register to join");
        System.out.println("(3) Login if you are a member");
        System.out.println("(4) Quit!");
        
        System.out.print("\nEnter your choice: ");
        Scanner menu = new Scanner(System.in);
        int choice = menu.nextInt();
        System.out.println(" ");
        convert<String> con=new convert<String>();
        
        switch(choice){
            case 1:
                System.out.println("[Displaying]");

                System.out.println("(1) Sorted name");
                System.out.println("(2) Sorted bidding price");
                System.out.println("(3) Sorted item");
                System.out.println("(4) Sorted bidding frequency");
                System.out.println("(5) Winner");
                
                
                System.out.print("\nEnter your choice: ");
                Scanner menu1 = new Scanner(System.in);
                int choice1 = menu1.nextInt();
                item obj1 = new item();
                user toCheck = new user();
                
                switch(choice1){
                    case 1: 
                        System.out.println("Sorted name");
                        System.out.println("---Alphabatical---");
                        
                        obj1.sortNameAsc();
                        obj1.userID_link.print();obj1.userName_link.print();obj1.bid_link.print();obj1.itemID_link.print();
                        System.out.println("--Reverse Alphabatical--");System.out.println();
                        //obj1.sortNameDsc();
                        obj1.userID_link.reverse();obj1.userName_link.reverse();obj1.bid_link.reverse();obj1.itemID_link.reverse();
                        
                        break;
                    case 2:
                        System.out.println("Sorted bidding price Ascending ");
                        obj1.sortBidpriceAscend();
                        obj1.userID_link.print();obj1.userName_link.print();obj1.bid_link.print();obj1.itemID_link.print();
                        System.out.println("Descending");
                        obj1.userID_link.reverse();obj1.userName_link.reverse();obj1.bid_link.reverse();obj1.itemID_link.reverse();                        break;
                    case 3:
                        System.out.println("Sorted item Ascending & Descending");
                        obj1.sortItemAsc();
                        obj1.userID_link.print();obj1.userName_link.print();obj1.bid_link.print();obj1.itemID_link.print();
                        System.out.println("Descending");                  
                        obj1.userID_link.reverse();obj1.userName_link.reverse();obj1.bid_link.reverse();obj1.itemID_link.reverse();
                        break;
                    case 4:
                        System.out.println("Sorted bidding frequency");
                        item test = new item();
                        test.Frequency();
                        
                        break;
                    case 5:
                        obj1.itemID_link.print();
                        obj1.itemName_link.print();
                        System.out.print("Please choose Item ID: ");
                        Scanner scan1 = new Scanner(System.in);
                        String itemid = scan1.nextLine();
                    
                        obj1.item_winner(itemid);              
                        //obj1.sortItemDsc();
                        //obj1.userID_link.print();obj1.userName_link.print();obj1.bid_link.print();obj1.itemID_link.print();         
                        break;
                    default: System.out.println("Error!");
                        break;
                }
                break;               
            case 2:
                System.out.println("[Register]");
                System.out.print("\nEnter your username: ");
                Scanner username_reg = new Scanner(System.in);
                String username = username_reg.next();
                user userReg = new user(username);             
                    System.out.println("Registration successful!");     
                break;
            case 3:
                System.out.println("[Login]");
                
                System.out.print("\nEnter your username: ");
                Scanner username_login = new Scanner(System.in);
                String username1 = username_login.next();
                user toCheck1=new user();
                int currentUserIndex;
                if(toCheck1.userName_link.contains(username1)){
                    System.out.println("Login successful!");
                    System.out.println("Print userName link");
 //to get index of userID
                    currentUserIndex=toCheck1.userName_link.indexOf(username1);
                    System.out.println("currentUserIndex :"+currentUserIndex);
                    System.out.println("[LOGIN SUCCEED]");
                    System.out.println("(1) Sell");
                    System.out.println("(2) Bid");
                    System.out.println("(3) Delete item");
                    System.out.println("(4) Exit");

                    System.out.print("\nEnter your choice: ");
                    Scanner scanItem=new Scanner(System.in);
                    Scanner scanMinPrice= new Scanner(System.in);
                    Scanner menu3 = new Scanner(System.in);
                    int choice3 = menu3.nextInt();
                    switch (choice3){
                        case 1:
                            System.out.println("[Sell]");
                            System.out.print("Enter your Item name: ");
                            String item_name = scanItem.nextLine();
                            System.out.print("Enter the minimum price: ");
                            double minPrice = scanMinPrice.nextDouble();
                            
                            item newItem=new item(item_name,minPrice, currentUserIndex);
                  //function sell
                            break;
                        case 2:
                            System.out.println("[Bid]");
                            System.out.println("currentuser index: "+currentUserIndex);
                            //function bid
                            System.out.println("Play to bid! ");
                                                       
                            item listItem = new item();
                            listItem.itemID_link.print();
                            listItem.itemName_link.print();
                            System.out.print("Choose item ID: ");
                            Scanner scanItem1 = new Scanner(System.in);
                            String itemID = scanItem1.nextLine();
                            System.out.print("Bidding price: ");
                            double itemBid = scanItem1.nextDouble();
                            
                            listItem.bid(currentUserIndex, itemBid, itemID);
                            break;

                        case 3:
                            
                            System.out.println("[Delete]");
                            item ola = new item();
                            ola.runDelete(username1);
                            //modify algorithm
                            break;
                        case 4:
                            System.out.println("Exiting...");
                            break;
                    }               
                    break;
                }
                else
                    System.out.println("Error! You are not logged in!");
                break;
            case 4:
                System.out.println("[Quit]");
                System.out.println("You want to quit.");
                System.out.println("Thank you for using our system!");
                break;
            default : 
                System.out.println("Error!");               
        }
    }   
}
