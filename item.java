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
import static java.lang.Double.parseDouble;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;



/**
 *
 * @author zainal
 */
public class item {
    String item,item_id;
    double price, min_price;  
    int currentUserIndex;
    
    MyLinkedList<String>  userID_link=new MyLinkedList<>();
    MyLinkedList<String>  userName_link=new MyLinkedList<>();
    MyLinkedList<Double> bid_link=new MyLinkedList<>();
    MyLinkedList<String>  itemName_link=new MyLinkedList<>();
    MyLinkedList<String> itemID_link = new MyLinkedList<>();
    MyLinkedList<String> itemID_link2=new MyLinkedList<>();
    MyLinkedList<Double> minPrice_link=new MyLinkedList<>();
    
    public item(){ 
        readItemTxt();
    }
    
    //add ITEM
    public item(String item, double min_price, int currentUserIndex){        
        user obj = new user();
        this.currentUserIndex=currentUserIndex;    
        this.item=item;
        this.min_price=min_price;
        Scanner scan;
        PrintWriter write;
        //test check
        System.out.println("current: "+currentUserIndex);       
        try{
            scan = new Scanner(new FileInputStream("item.txt"));
            readItemTxt();
            
            String userID=(String)obj.userID_link.get(currentUserIndex);
            String userName=(String)obj.userName_link.get(currentUserIndex);
            write = new PrintWriter(new FileOutputStream("item.txt",true));
            if(scan.hasNextLine())
                write.println();
            System.out.println("print item id");
            
            write.print(userID+","+userName+","+item+","+(itemID_link.size)+","+min_price);
            write.close();
            
        }catch(IOException e){            
        }     
    }
    
    public void readItemTxt(){
        try(Scanner in = new Scanner(new FileInputStream("item.txt"))){
                         
                itemID_link=new MyLinkedList();
                itemName_link=new MyLinkedList();
                while(in.hasNextLine()){
                    String[] line= in.nextLine().split(",");
                    for (int i = 0; i < line.length/5; i++) {
                        userID_link.add(line[i]);
                        userName_link.add(line[i+1]);
                        itemName_link.add(line[i+2]);
                        itemID_link.add(line[i+3]);
                        itemID_link2.add(line[i+3]);
                        minPrice_link.add(Double.parseDouble(line[i+4]));                 
                    }
                }
            
        }catch(FileNotFoundException ex){
            System.out.println("File Lost Item");
        }            
    }
    
    public void bid(int currentUserIndex, double bid_price, String item_id){
        
        user obj = new user();
        this.currentUserIndex=currentUserIndex; 
        
        String userID=(String)obj.userID_link.get(currentUserIndex);
        String userName=(String)obj.userName_link.get(currentUserIndex);
        
        String filename = "auction.txt";
        PrintWriter write =null;
        Scanner scan = null;
        MyQueue<String> queue=new MyQueue<>();
        
        try{
            //Queue is applied
            queue.enqueue(userID);
            queue.enqueue(userName);
            queue.enqueue(Double.toString(bid_price));
            queue.enqueue(item_id);
  
            write = new PrintWriter(new FileOutputStream(filename,true));
            scan = new Scanner(new FileInputStream(filename));
            if(scan.hasNextLine()) //just for spacing
                write.println("");
            write.print(queue.dequeue()+","+queue.dequeue()+","+queue.dequeue()+","+queue.dequeue());
            write.close();           
        }catch(IOException e){           
        }
    }
    
    public void Frequency(){
        //itemID_link2-item.txt;
        //readITEM
        int noItem = itemID_link2.size;
        MyLinkedList<String> temp = itemID_link2;
        itemID_link2.print();
        
        readAuctionTxt();
        int nofre = itemID_link.size;
        
        
        for (int i = 0; i < noItem; i++) {
            int sum=0;
            System.out.print("itemID :"+i);
            for (int j = 0; j < nofre; j++) {
                if(itemID_link.get(j).equals(temp.get(i)))
                    sum++;
            }
            System.out.println(", frequency = "+sum);
        }    
    }   
    
    public void item_winner(String itemID){       
        sortBidpriceDescend();
        int IDitem = Integer.parseInt(itemID);
        int index=itemID_link.indexOf(itemID);     
        item obj=new item();
        System.out.println("Winner: "+userName_link.get(index)+" "+userID_link.get(index)+" "+bid_link.get(index)+" "+obj.itemName_link.get(IDitem));       
    }
    
    public void sortBidpriceAscend(){
        convert sort=new convert();       
        readAuctionTxt(); //get from readLinkedlist
        sort.sortAscend(bid_link,userName_link,userID_link,itemName_link); 
    }
    
    public void sortBidpriceDescend(){
        convert sort=new convert();       
        readAuctionTxt(); //get from readLinkedlist       
        sort.sortDescend(bid_link,userName_link,userID_link,itemName_link); 
    }
    
    public void sortNameAsc(){
        convert sort=new convert();      
        readAuctionTxt(); //get from readLinkedlist
        sort.sortAscend(userName_link,userID_link,bid_link,itemName_link);
    }
    
    public void sortNameDsc(){
         
        convert sort=new convert();      
        readAuctionTxt(); //get from readLinkedlist
        sort.sortDescend(userName_link,userID_link,bid_link,itemName_link);
    }
    
    public void sortItemAsc(){
        convert sort = new convert();
        readAuctionTxt();
        sort.sortAscend(itemID_link, userName_link, userID_link, bid_link);
    }
    
    public void sortItemDsc(){
        convert sort = new convert();
        readAuctionTxt();
        sort.sortDescend(itemID_link, userName_link, userID_link, bid_link);
    }   
          
    public void readAuctionTxt(){
        try(Scanner in = new Scanner(new FileInputStream("auction.txt"))){
            userID_link=new MyLinkedList();
            userName_link=new MyLinkedList();
            bid_link=new MyLinkedList();
            itemID_link=new MyLinkedList();
            
            while (in.hasNext()) { // iterates each line in the file
                String[] line = in.nextLine().split(",");  
                for(int i=0;i<(line.length/4);i++){
                    userID_link.add(line[i]);
                    userName_link.add(line[i+1]);
                    bid_link.add(parseDouble(line[i+2]));
                    itemID_link.add(line[i+3]);
                }
            }
        }catch (IOException e){
            
        }       
    }
    
    public <E extends Comparable<? super E>>void display(LinkedList<E> a,LinkedList<E> b,LinkedList<E> c, LinkedList<E> d){
        ListIterator dis1 = a.listIterator();
        ListIterator dis2 = b.listIterator();
        ListIterator dis3 = c.listIterator();
        ListIterator dis4 = d.listIterator();
        
         try(PrintWriter out=new PrintWriter(new FileOutputStream("test.txt", true))){
             while(dis1.hasNext()&& dis2.hasNext()&& dis3.hasNext()){
            out.println(dis1.next()+","+ dis2.next()+","+ dis3.next()+","+ dis4.next());
        }
        }catch ( IOException e){
            System.out.println("error");
        }
    }
    
    public String toString(){
        return item+" "+item_id+" "+min_price;
    }   
    
    ////////////////////DELETE??????????
    
    public void runDelete(String x){
        deleteAuction(findName(x, userName_link,userID_link, itemName_link, itemID_link,minPrice_link));
    }
    
    public static String findName(String x,MyLinkedList<String> name, MyLinkedList<String> nameid, MyLinkedList<String> itemname, MyLinkedList<String> itemid, MyLinkedList<Double> min){
        convert fer=new convert();
        int[] index=fer.searchIndex(x,name);
        System.out.println("row that has your name: ");
        System.out.println("number \t\t\t name \t\t\t name id \t\t\t item \t\t\t item id \t\t\t minPrice");
        for(int i=0;i<index.length;i++){
            System.out.println(i+"\t\t\t"+name.get(index[i])+"\t\t\t"+nameid.get(index[i])+"\t\t\t"+itemname.get(index[i])+"\t\t\t"+itemid.get(index[i])+"\t\t\t"+min.get(index[i]));
        }
        Scanner key=new Scanner(System.in);
        int put=0;
        Boolean check=false;
        
        
        while(check==false){
            System.out.println("enter a number that you to want to delete:");
            put=key.nextInt();
        if(put<0||put>=index.length){
            System.out.println("number is not register!");
            check=false;
        }else{
            check=true;
        }
        }
        String del=itemid.get(index[put]);
        fer.deleteRow(index[put],name,nameid,itemname,itemid,min);
        return del;
}
    public void deleteAuction(String item){
        int[] index=findItem(item);
        System.out.print("row ");
        for(int i=index.length-1;i>=0;i--){
        System.out.println(index[i]+"olol"+"\t\t\t"+userID_link.remove(index[i])+"\t\t\t"+userName_link.remove(index[i])+"\t\t\t"+bid_link.remove(index[i])+"\t\t\t"+itemID_link.remove(index[i]));
        }
        System.out.print(" has been deleted\n");
        
        System.out.println("auction left: ");
        for(int i=0;i<itemID_link.size();i++){
        System.out.println(userID_link.get(i)+"\t\t\t"+userName_link.get(i)+"\t\t\t"+bid_link.get(i)+"\t\t\t"+itemID_link.get(i));
        }
        convert print=new convert();
        print.printNewAuction(userID_link,userName_link,bid_link,itemID_link);
    }
    
    public int[] findItem(String itemid){
        userID_link.clear();
        userName_link.clear();
        bid_link.clear();
        itemID_link.clear();
        readAuctionTxt();
        
        int size=0;
        for(int i=0;i<itemID_link.size();i++){
            if(itemid.equalsIgnoreCase((String)itemID_link.get(i))){
                size++;
            }
        }
       
        
        int[] index=new int[size];
        int o=0;
        boolean check=false;
        for(int i=0;i<itemID_link.size();i++){
            if(itemid.equalsIgnoreCase(itemID_link.get(i))){
                index[o]=i;
                o++;
                check=true;
            }
        }
        if(check==false){
            System.out.println("element does not exist");
        }
        return index;
    }
}
