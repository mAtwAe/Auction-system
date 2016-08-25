/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

/**
 *
 * @author zainal
 */
public class convert<E> {
    
    public <E extends Comparable<? super E>>int[] searchIndex(E x, LinkedList<E> j){
        
        int size=0;
        for(int i=0;i<j.size();i++){
            if(x.compareTo(j.get(i))==0){
                size++;
            }
        }
   
        int[] z=new int[size];
        int o=0;
        boolean check=false;
        for(int i=0;i<j.size();i++){
            if(x.compareTo(j.get(i))==0){
                z[o]=i;
                o++;
                check=true;
            }
        }
        if(check==false){
            System.out.println("element does not exist");
        }
        return z;
    }
    
    public <E >void deleteRow(int x,LinkedList<String> ij, LinkedList<String> it, LinkedList<Double> iv, LinkedList<Double> ix){
        System.out.println("row has been delete: ");
        System.out.println(ij.remove(x)+""+it.remove(x)+""+iv.remove(x)+""+ix.remove(x));
    }
    
    public void findName(String x,LinkedList<String> name, LinkedList<String> id, LinkedList<Double> price, LinkedList<Double> min){
        int[] index=searchIndex(x,name);
        for(int i=0;i<index.length;i++){
            System.out.println(i+" | "+name.get(index[i])+" | "+id.get(index[i])+" | "+price.get(index[i])+" | "+min.get(index[i]));
        }
        Scanner key=new Scanner(System.in);
        int put=0;
        Boolean check=false;
        int del;
        
        while(check==false){
            System.out.println("enter a number that you to want to delete:");
            put=key.nextInt();
        if(put<0||put>=index.length){
            System.out.println("number is not register!");
            check=false;
        }else{
            del=put;
            check=true;
        }
        }
        deleteRow(put,name,id,price,min);
    }
    
    public <E extends Comparable<E>> void sortAscend(MyLinkedList<E> o,MyLinkedList<E> x,MyLinkedList<E> z,MyLinkedList<E> v){
        boolean nnpass=true;
        for(int k=1;k<o.size()&& nnpass;k++){
            nnpass=false;
            for(int i=0;i<o.size()-k;i++){
                if(o.get(i).compareTo(o.get(i+1))>0){
                    swap(o,i,i+1);
                    swap(x,i,i+1);
                    swap(z,i,i+1);
                    swap(v,i,i+1);
                    nnpass=true;
                }
            }
        }
    }
    
    public <E extends Comparable<E>> void sortDescend(MyLinkedList<E> o,MyLinkedList<E> x,MyLinkedList<E> z,MyLinkedList<E> v){
        boolean nnpass=true;
        for(int k=1;k<o.size()&& nnpass;k++){
            nnpass=false;
            for(int i=0;i<o.size()-k;i++){
                if(o.get(i).compareTo(o.get(i+1))<0){
                    swap(o,i,i+1);
                    swap(x,i,i+1);
                    swap(z,i,i+1);
                    swap(v,i,i+1);
                    nnpass=true;
                }
            }
        }
    }
    
    public <E> void swap(MyLinkedList <E> o,int i,int j){
        E temp=o.get(j);
        o.remove(j);
        o.add(j, o.get(i));
        o.remove(i);
        o.add(i, temp);
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
    /////////////////////////DELETE////////////////////////////////////
    public <E extends Comparable<? super E>>int[] searchIndex(E x, MyLinkedList<E> j){
        String y=(String)x;
        
        int size=0;
        for(int i=0;i<j.size();i++){
            if(y.equalsIgnoreCase((String)j.get(i))){
                size++;
            }
        }
        
        int[] z=new int[size];
        int o=0;
        boolean check=false;
        for(int i=0;i<j.size();i++){
            if(y.equalsIgnoreCase((String)j.get(i))){
                z[o]=i;
                o++;
                check=true;
            }
        }
        System.out.println(z[0]);
        if(check==false){
            System.out.println("element does not exist");
        }
        return z;
    }
    
    public <E extends Comparable<? super E>>void deleteRow(int x,MyLinkedList<E> ij, MyLinkedList<E> it, MyLinkedList<E> iv, MyLinkedList<E> ix, MyLinkedList<E> iw){
        
        System.out.print("row ");
        System.out.print(ij.remove(x)+"\t\t\t"+it.remove(x)+"\t\t\t"+iv.remove(x)+"\t\t\t"+ix.remove(x)+"\t\t\t"+iw.remove(x));
        System.out.print(" has been deleted\n");
        printNew(ij, it, iv, ix, iw);
    }
    
    public <E extends Comparable<? super E>>void printNew(MyLinkedList<E> ij, MyLinkedList<E> it, MyLinkedList<E> iv, MyLinkedList<E> ix, MyLinkedList<E> iw){
        
        try(PrintWriter out=new PrintWriter(new FileOutputStream("item.txt"))){
             for(int i=0;i<ij.size();i++){
            out.println(it.get(i)+","+ij.get(i)+","+iv.get(i)+","+ix.get(i)+","+iw.get(i));
        }
        }catch ( IOException e){
            System.out.println("error");
        }
    }
    
    public <E extends Comparable<? super E>>void printNewAuction(MyLinkedList<E> ij, MyLinkedList<E> it, MyLinkedList<E> iv, MyLinkedList<E> ix){
        
        try(PrintWriter out=new PrintWriter(new FileOutputStream("auction.txt"))){
             for(int i=0;i<ij.size();i++){
            out.println(ij.get(i)+","+it.get(i)+","+iv.get(i)+","+ix.get(i));
        }
        }catch ( IOException e){
            System.out.println("error");
        }
    }
}
