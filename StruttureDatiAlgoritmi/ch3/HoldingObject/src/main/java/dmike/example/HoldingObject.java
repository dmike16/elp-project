/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmike.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author dmike
 */
class ListFeatures {
    static void show(){
        List<String> listString = new ArrayList<>();
        listString.add("Prima Stringa");
        System.out.println("1: List toString " + listString);
        
        listString.addAll(Arrays.asList("Bella","Zio","Okay"));
        System.out.println("2: Afeter addAll " + listString);
        
        String  ele = listString.get(3);
        System.out.println("3: Ele " + ele);
        
        System.out.println("4: Contain " + listString.contains(ele));
        System.out.println("5: IndexOf " + listString.indexOf(ele));
        
        String s = "Zio";
        System.out.println("6: remove " + listString.remove(s));
        
        String[] arrS = {"Oggi","Domani","Dopodomani"};
        Collections.addAll(listString, arrS);
        System.out.println("7: static addAll " + listString);
        
        List<String> sub = listString.subList(1, 4);
        System.out.println("8: remove " + sub);
        
        
        System.out.println("9: containsAll " + listString.containsAll(sub));
        
        Collections.sort(sub);
        System.out.println("10: Sort " + sub);
        System.out.println("11: Print " + listString);
        
        List<String> copy = new ArrayList<>(listString);
        sub = Arrays.asList(listString.get(1),listString.get(2));
        System.out.println("12: Short Copy " + sub);
        copy.retainAll(sub);
        System.out.println("13: Intersec " + copy);
        
        copy = new ArrayList<>(listString);
        copy.remove(2);
        System.out.println("14: Remove by Index " + copy);
        
        copy.set(1, "*****");
        System.out.println("15: Replace " + copy);
        
        System.out.println("16: Empty " + listString.isEmpty());
        listString.clear();
        System.out.println("17: Clear " + listString.isEmpty());
        
        listString.addAll(Arrays.asList("Ho","un","cjcojo","*é*é*é*é"));
        Object[] o = listString.toArray();
        System.out.println("18: toArray " + o[1]);
        
        ArrayList<String> arrList = new ArrayList<>(listString);
        LinkedList<String> link = new LinkedList<>(listString);
        HashSet<String> sSet = new HashSet<>(listString);
        TreeSet<String> sTree = new TreeSet<>(listString);
        
        showIterator(arrList.iterator());
        showIterator(link.iterator());
        showIterator(sSet.iterator());
        showIterator(sTree.iterator());
    }
    
    static void showIterator(Iterator<String> it){
        while(it.hasNext()){
            String s = it.next();
            System.out.print(" ele: " + s);
        }
        System.out.println();
    }
}

class LinkedListFeatures{
    static void show(){
        LinkedList<Integer> linkInt = new LinkedList<>();
        Collections.addAll(linkInt, 0,1,2,3,4,5,6,7,8,9);
        System.out.println("1: " + linkInt);
        
        System.out.println("2: " + linkInt.getFirst());
        System.out.println("3: " + linkInt.element());
        System.out.println("4: " + linkInt.peek());
        System.out.println("5: " + linkInt.remove());
        System.out.println("6: " + linkInt.removeFirst());
        System.out.println("7: " + linkInt.poll());
        
        System.out.println("8: " + linkInt);
        
        linkInt.addFirst(34);
        System.out.println("9: " + linkInt);
        
        linkInt.offer(43);
        System.out.println("10: " + linkInt);
        System.out.println("11: " + linkInt.removeLast());
    }
    static void useStack(){
        Stack<String> stack = new Stack<>();
        String input = "+U+n+c-+e+r+t-+a-+i-+n+t+y-+ -+r+u-+l+e+s-";
        String[] s = input.split("");
        
        for (int i = 0,len = s.length; i < len;i++){
            switch(s[i]){
                case "+":
                    stack.push(s[++i]);
                    break;
                case "-":
                    System.out.println("Popped: " + stack.pop());
                    break;
                default:
                    break;
            }
        }
    } 
}
class SetFeatures {
    static void show(){
        Set<Integer> intSet = new TreeSet<>();
        Random rand = new Random(47);
        
        for(int i = 0; i < 10000; i++){
            intSet.add(rand.nextInt(30));
        }
       System.out.println(intSet);
       
       Set<Character> vowels = new HashSet<>();
       Collections.addAll(vowels, 'a','e','i','o','u');
       String[] words = {"bella", "super", "chicco"};
       
       int total = 0;
       for (String s: words){
           Character[] tmpC = new Character[s.length()];
           for(int i=0,len=tmpC.length; i < len; i++){
               tmpC[i] = s.charAt(i);
           }
           List<Character>  tmpL = new ArrayList<>();
           Collections.addAll(tmpL,tmpC);
           tmpL.retainAll(vowels);
           System.out.println("Vowels in \""+ s + "\": " +tmpL.size());
           total += tmpL.size();
       }
       System.out.println("Total vowels = " + total);
    }
}
class MapsFeatures{
    static void show(){
        Map<String,Integer> mmp = new HashMap<>();
        mmp.put("bella", 2);
        mmp.put("no", 3);
        System.out.println(mmp);
        
        List<String> keys = new LinkedList<>();
        String[] tmp = new String[1];
        Collections.addAll(keys, mmp.keySet().toArray(tmp));
        Collections.sort(keys);
        System.out.println("Sorted Keys: " + keys);
        Map<String,Integer> mp = new LinkedHashMap<>();
        keys.stream().forEach((s) -> {
            mp.put(s, mmp.get(s));
        });
        System.out.println(mp);
        
    }
}
public class HoldingObject {
    public static void main(String...arg){
        ListFeatures.show();
        LinkedListFeatures.show();
        LinkedListFeatures.useStack();
        SetFeatures.show();
        MapsFeatures.show();
        
        ReversibleArrayList<String> ral = new ReversibleArrayList<>(
                Arrays.asList("To be or not to be".split(" ")));
        ral.stream().forEach((s)->{
            System.out.print(s + " ");
        });
        System.out.println();
        for(String s: ral.reversed()){
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
