import java.util.HashMap;
import java.util.Map;

/**
 * URL: https://leetcode.com/problems/roman-to-integer/
 * 
 */

class Problem13{
    public static void main(String[] args) {
        
        Solution2 sol = new Solution2();

        System.out.println("Ans: " + sol.romanToInt("CDXCIX")); // 499

        System.out.println("Ans: " + sol.romanToInt("CCCXCI")); // 391

        System.out.println("Ans: " + sol.romanToInt("I")); // 1

        System.out.println("Ans: " + sol.romanToInt("V")); // 5

        System.out.println("Ans: " + sol.romanToInt("IV")); // 4
    }

}

class Solution {
    public int romanToInt(String s) {
        int num = 0;
        int len = s.length();


        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);    map.put("IV", 4);   map.put("V", 5);    map.put("IX", 9); 
        map.put("X", 10);   map.put("XL", 40);  map.put("L", 50);   map.put("XC", 90); 
        map.put("C", 100);  map.put("CD", 400); map.put("D", 500);  map.put("CM", 900); 
        map.put("M", 1000);

        for(int i = 0; i < len;){
            String oneChar = Character.toString((s.charAt(i)) );;
            String twoChar = null;
            if( i < len-1 ){
                twoChar = Character.toString( (s.charAt(i)) ) + Character.toString((s.charAt(i+1)) ) ;
            }

            if(twoChar != null && map.containsKey(twoChar)){
                num += map.get(twoChar);
                i+=2;
            }else{
                num+= map.get(oneChar);
                i++;
            }
        }

        return num;
        
    }
}


class Solution2 {

    public int romanToInt(String s) {
        int previous = 0, current = 0, ans = 0;
        for (int i = s.length() - 1 ; i >= 0 ; i--){
            if (s.charAt(i) == 'I') current = 1;
            else if (s.charAt(i) == 'V') current = 5;
            else if (s.charAt(i) == 'X') current = 10;
            else if (s.charAt(i) == 'L') current = 50;
            else if (s.charAt(i) == 'C') current = 100;
            else if (s.charAt(i) == 'D') current = 500;
            else if (s.charAt(i) == 'M') current = 1000;
            if (previous > current) ans -= current;
            else ans += current;
            previous = current;
        }
        return ans;
    }
}