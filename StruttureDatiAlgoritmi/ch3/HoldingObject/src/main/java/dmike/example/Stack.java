/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmike.example;

import java.util.LinkedList;

/**
 *
 * @author dmike
 * @param <T>
 */
public class Stack<T> {
    public void push(T v) {
        storage.addFirst(v);
    }
    public T peek(){
        return storage.getFirst();
    }
    public T pop(){
        return storage.removeFirst();
    }
    public boolean empty(){
        return storage.isEmpty();
    }
    @Override
    public String toString(){
        return storage.toString();
    }
    private final LinkedList<T> storage = new LinkedList<>();
}
