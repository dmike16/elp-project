/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmike.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author dmike
 * @param <T>
 */
public class ReversibleArrayList<T> extends ArrayList<T> {
    public ReversibleArrayList(Collection<T> c){
        super(c);
    }
    public Iterable<T> reversed(){
        return () -> new Iterator<T>(){
            int current = size() -1;
            @Override
            public boolean hasNext(){
                
                return current > -1;
            }
            @Override
            public T next(){
                return get(current--);
            }
            @Override
            public void remove(){
                throw new UnsupportedOperationException();
            }
        };
    }
}
