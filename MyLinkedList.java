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
public class MyLinkedList<E> {

    
    //basic
    public class Node<E> {
    E element;
    Node<E> next;
    
    public Node(){
        element=null;
        next=null;
    }
    
    public Node(E item){
        element=item;
        next=null;
    }   
    }
    
    //method/function
    
    Node<E> head;
    Node<E> tail;
    int size;
    
    public MyLinkedList(){
        this.head=null;
        this.tail=null;
    }
    
    //add FIRST
    public void addFirst(E e){
        Node<E> newNode=new Node<E>(e);
        newNode.next=head;
        head=newNode;
        size++;
        if(tail==null)tail=head;
    }
    
    //add LAST
    public void addLast(E e){
        if(tail==null) head=tail=new Node<E>(e);
        else{
            tail.next=new Node(e);
            tail=tail.next;
        }
        size++;
    }
    
    public int size(){
        return this.size;
    }
    
    //add INDEX
    public void add(int index,E e){
        if(index==0) addFirst(e);
        
        else if(index>=size) addLast(e);
        else{
            Node<E> current=head;
            for (int i = 1; i < index; i++) 
                current=current.next;
            Node<E>temp=current.next;
            current.next=new Node<E>(e);
            current.next.next=temp;
            size++;            
        }           
    }
    
    //removeFirst
    public E removeFirst(){
        if(size==0) return null;
        else{
            Node<E> temp=head;
            head=head.next;
            size--;
            if(head==null) tail=null;
            return temp.element;
        }
    }
    
    //removeLast(){
    public E removeLast(){
        if(size==0)return null;
        else if(size==1){
            Node<E> temp= head;
            head=tail=null;
            size=0;
            return temp.element;
            }
        else{
            Node<E> current = head;
            for (int i = 0; i < size-2; i++) 
                current=current.next;
            Node<E> temp=tail;
            tail=current;
            tail.next=null;
            size--;
            return temp.element;            
        }
    }
    
    
    //removeIndex
    public E remove(int index){
        if(index<0||index>=size) return null;
        else if(index==0) return removeFirst();
        else if(index==size-1) return removeLast();
        else{
            Node<E> current = head;
            for (int i = 0; i < index-1; i++) 
                current=current.next;
            Node<E> temp = current.next;
            current.next=temp.next;
            size--;
            return temp.element;          
        }
    }
    
    ///EXTEND-ED LINKED LIST
    
    public void add(E e){
        addLast(e);
    }
       
    
    public boolean contains(E e){
        Node<E> current=head;
        while(current!=null) {           
            if (current.element.equals(e)) {               
                return true;
            }           
            current=current.next;             
        }        
        return false;
    }
    
    public E get(int index){
        Node<E> current=head;
        if(index<0||index>=size)return null;
        else if(index==0)return current.element;
        else{           
            for (int i = 0; i < index; i++) 
                current=current.next;                
            return current.element;
        }
    }
    
    public E getFirst(){
        return head.element;
    }
    
    public E getLast(){
        Node<E> current = head;
        while(current.next!=null)
            current=current.next;
        return current.element;
    }
    
    public int indexOf(E e){
        Node<E> current=head;
        int index=0;
        while(current!=null){
            if(current.element.equals(e))
                return index;
            index++;
            current=current.next;
        }      
        return -1; 
    }
    
    public int lastIndex(E e){
        Node<E> current=head;
        int index=-1;
        if(current.element.equals(e)) return 0;
            for(int i=1;current.next!=null;i++){
                if(current.element.equals(e)){
                    index=i;
                }else{
                    current=current.next;
                }
            }
        return index;            
    }
    
    public E set(int index,E e){
        Node<E> current=head;
        Node<E> temp;
        System.out.println(size);
        if(index<0) return null;
        else if(index>size-1){
            this.addLast(e);
            //System.out.println("sini");
            return null;
        }
        else if(index==0){
            temp=head;
            head.element=e;
            return temp.element;
        }
        else{
            //System.out.println("lolol");
            for(int i =1; i<index-1;i++)
                current=current.next;
            temp=current.next;
            current.next.element=e;
            return temp.element;
        }
    }
    
    public void clear(){
        this.head=null;
        this.tail=null;
    }
    
    public void print(){
        Node<E> current=head;       
        while(current!=null){
            System.out.print(current.element+" ");
            current=current.next;            
        }
        System.out.println();
    }
    
    public void reverse(){
        Node<E> current=head;
        Node<E> temp;
        Node<E> previous=null;
        
        for (int i = 0; i < this.size-1; i++) {
            temp=current.next;
            current.next=previous;
            previous=current;
            current=temp;            
        }
        current.next=previous;
        this.head=current;
        this.print();
    } 
}
