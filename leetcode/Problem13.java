import java.util.HashMap;
import java.util.Map;

/**
 * URL: https://leetcode.com/problems/roman-to-integer/
 * 
 */

class Problem13{
    public static void main(String[] args) {
        // String roman  = "CDXCIX"; // 499
        // String roman  = "CCCXCI"; //391

        // String roman  = "I"; // 1
        // String roman  = "V"; // 5
        String roman  = "IV"; // 4
        

        System.out.println("Ans: " + romanToInt(roman));
    }

    public static int romanToInt(String s) {
        int ans = 0;
        Map<String, Integer> map = new HashMap<String, Integer>(){{
            put("I",1); put("II", 2); put("III", 3); put("IV", 4);
            put("V", 5); put("VI", 6); put("VII", 7); put("VIII", 8); put("IX", 9); 
            put("X",10); put("XX", 20); put("XXX", 30); put("XL", 40);
            put("L", 50); put("LX", 60); put("LXX", 70); put("LXXX", 80); put("XC", 90);
            put("C",100); put("CC", 200); put("CCC", 300); put("CD", 400);
            put("D", 500); put("DC", 600); put("DCC", 700); put("DCCC", 800); put("CM", 900);
            put("M", 1000); put("MM", 2000); put("MMM", 3000);
        }};

        String key;
        int start = 0;
        int end = s.length();
        while(start <= end){
            key = s.substring(start, end);
            System.out.print("key =" + key + "(" + map.get(key) +  ") || start =" + start + " end =" + end);
            if(map.containsKey(key) ){
                System.out.println("\tFound");
                ans += map.get(key);
                start = end;
                end = s.length();
            }else{
                System.out.println("\tNotFound");
                end--;
            }
        }

        return ans;
        
    }

}