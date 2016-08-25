/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;



public class user {
    String user_name;
    String user_id;
    item item;
    
    public user(){  
        readUserTxt();        
    }
    
    MyLinkedList userID_link;
    MyLinkedList userName_link;
    
    public user(String user_name) {
        this.user_name=user_name;      
        //write to text file     
        String filename = "user.txt";
        PrintWriter write;
        Scanner scan;     
        try{
            scan=new Scanner(new FileInputStream(filename));
            readUserTxt();
            write = new PrintWriter(new FileOutputStream(filename,true));
            scan = new Scanner(new FileInputStream(filename));
            if(scan.hasNextLine()) //just for spacing
                write.println("");
            write.print((userID_link.size)+","+user_name);
            write.close();             
        }catch(IOException e){           
        }            
    }
   
    public void readUserTxt(){
        try(Scanner in = new Scanner(new FileInputStream("user.txt"))){
            
                userID_link=new MyLinkedList();
                userName_link=new MyLinkedList();
                while (in.hasNext()) { // iterates each line in the file
                    String[] line = in.nextLine().split(",");  
                    for(int i=0;i<(line.length/2);i++){
                        userID_link.add(line[i]);
                        userName_link.add(line[i+1]);                   
                    }
                }            
        }catch (FileNotFoundException ex) {
            System.out.println("File Lost User");
        }       
    }
    
    public void displayUser(){
        readUserTxt();
        userID_link.print();
        userName_link.print();  
    }
      
    public void bid(int currentUserIndex, double bid_price, String item_id){
        item.bid(currentUserIndex, bid_price, item_id);
    }
    
    
    public String toString(){
        return user_name+" "+user_id;
    }
    
    
    
}
