/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.structures;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author calumbruton
 */
public class MyStack<Item> implements Iterable<Item>{
    public class Node{
        Item item = null;
        Node next = null;
    }
    
    Node first = null;
        
    
    public boolean isEmpty(){
        return first == null;
    }
    
    public void push(Item item){
        Node nxt = new Node();
        nxt.item = item;
        if (isEmpty()) first = nxt;
        else {
            nxt.next = first;
            first = nxt;
        }
    }
    
    public Item peek(){
        if (isEmpty()) return null;
        return first.item;
    }
    
    public Item pop(){
        if (isEmpty()) return null;
        Item ret = first.item;
        first = first.next;
        return ret;
    }
    
    public Iterator<Item> iterator() {
        return new MyIterator();
    }
    
    public class MyIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            else {
                Item item = current.item;
                current = current.next;
                return item;
            }
        }
        
    }
    
    
    public static void main(String [] args){
        MyStack<Integer> stack = new MyStack<Integer>();
        stack.push(5);
        stack.push(20);
        stack.push(12);
        stack.push(25);
        //while (!stack.isEmpty()){
        //    System.out.println(stack.pop());
        //}
        
        for (int x : stack) {
            System.out.println(x);
        }
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
        stack.pop();
        System.out.println(stack.isEmpty());
        
    }
    
}
