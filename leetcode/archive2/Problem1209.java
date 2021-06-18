/**
 * URL: 
 * Tags: 
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */

import java.util.Stack;
import javafx.util.Pair;


public class Problem1209{
    public static void main(String[] args) {
        SolutionOptimizedWitPair sol = new SolutionOptimizedWitPair();

        System.out.println("Ans: " + sol.removeDuplicates("abcd", 2));

        System.out.println("Ans: " + sol.removeDuplicates("deeedbbcccbdaa", 3));

        System.out.println("Ans: " + sol.removeDuplicates("pbbcggttciiippooaais", 2));
    }
}


/**
 * 
 * 17 testcase passed out of 18
 * 
 */
class SolutionBruteForce {
    
    public String removeDuplicates(String s, int k) {
        System.out.println("----------------" + s);
        if(s == "" || s == null){
            return "";
        }
        boolean changed = false;
        String ns = "";
        for(int i=0; i < s.length();){
            int j = i;
            while(j <= i + k && j < s.length() && s.charAt(i) == s.charAt(j)){
                j++;
            }
            System.out.println(s.substring(i,j) + " " + i + " " + j);
            if(j - i != k){
                ns = ns + s.charAt(i);
                i++;
            }else{
                i = j;
                changed = true;
            }
        }

        if(changed){
            return removeDuplicates(ns, k);
        }else{
            return s;
        }
    }

}

class SolutionOptimized {

    static class Frequency{
        Character c;
        Integer i;

        Frequency(Character cc, Integer ii){
            c = cc;
            i = ii;
        }

        public String toString(){
            return c + ":" + i + " ";
        }
    }
    
    public String removeDuplicates(String s, int k) {
        Stack<Frequency> stack = new Stack<>();

        for(int i=0; i < s.length(); i++){
            Character currChar = s.charAt(i);

            if(stack.isEmpty()){
                stack.push(new Frequency(currChar, 1));
            }else{
                Frequency peek = stack.peek();

                if(peek.c == currChar){
                    stack.pop();
                    if(peek.i == k-1){
                        // System.out.println(peek.c);
                    }else{
                        stack.push(new Frequency(currChar, peek.i + 1));
                    }
                }else{
                    stack.push(new Frequency(currChar, 1));
                }

            }
        }

        System.out.println(stack);
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            Frequency top = stack.pop();
            for(int i = 0; i < top.i; i++){
                sb.append(top.c);
            }
                
        }

        return sb.reverse().toString();

    }
}

class SolutionOptimizedWitPair {

    public String removeDuplicates(String s, int k) {
        Stack<Pair<Character, Integer>> stack = new Stack<>();

        for(int i=0; i < s.length(); i++){
            Character currChar = s.charAt(i);

            if(stack.isEmpty()){
                stack.push(new Pair(currChar, 1));
            }else{
                Pair<String, Integer> peek = stack.peek();

                if(peek.getKey() == currChar){
                    stack.pop();
                    if(peek.getValue() == k-1){
                        // System.out.println(peek.c);
                    }else{
                        stack.push(new Frequency(currChar, peek.getValue() + 1));
                    }
                }else{
                    stack.push(new Frequency(currChar, 1));
                }

            }
        }

        System.out.println(stack);
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            Pair<String, Integer> top = stack.pop();
            for(int i = 0; i < top.getValue(); i++){
                sb.append(top.getValue());
            }
                
        }

        return sb.reverse().toString();

    }
}

/**
 * a 0 1
b 1 2
Ans: abcd
d 0 1
eee 1 4
ee 2 4
e 3 4
d 4 5
bb 5 7
b 6 7
ccc 7 10
cc 8 10
c 9 10
b 10 11
Ans: deeedbbcccbdaa
p 0 1
bb 1 3
b 2 3
c 3 4
gg 4 6
g 5 6
tt 6 8
t 7 8
c 8 9
iii 9 12
ii 10 12
i 11 12
pp 12 14
p 13 14
oo 14 16
o 15 16
aa 16 18
a 17 18
Ans: pbbcggttciiippooaais
 */