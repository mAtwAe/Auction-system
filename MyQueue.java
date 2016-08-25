/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

/**
 *
 * @author zainal
 */
public class MyQueue<E> {
    private java.util.LinkedList<E> list=new java.util.LinkedList<E>();
    
    public MyQueue(E[] e){
        for (int i = 0; i < e.length; i++) {
            enqueue(e[i]);
        }
    }
    
    public MyQueue(){      
    }
    
    public void enqueue(E e){
        list.add(e);
    }
    
    public E dequeue(){
        return list.removeFirst();
    }
    
    public E getElement(int i){
        return list.get(i);
    }
    
    public E peek(){
        return list.peek();
    }
    
    public int getSize(){
        return list.size();
    }
    
    public boolean contains(E e){
        return list.contains(e);
    }
    
    public boolean isEmpty(){
        return list.isEmpty();
    }
    
    public String tostring(){
        return "Queue: "+list.toString();
    }
    
}
