import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * URL: https://leetcode.com/problems/occurrences-after-bigram/
 * 
 * 
 */

class Problem1078{

    public static void main(String[] args) {
        Problem1078 obj = new Problem1078();

        String text = "alice is a good girl she is a good student", first = "a", second = "good";

        System.out.println("Ans: " + Arrays.toString(obj.findOcurrences(text, first, second)) );

    }

    public String[] findOcurrences(String text, String first, String second) {
        String[] allWords = text.split(" ");

        List<String> thirds = new ArrayList<>();
        
        System.out.println(Arrays.toString(allWords));

        for(int i=0; i< allWords.length-2; i++){
            if(allWords[i].equals(first) && allWords[i+1].equals(second)){
                thirds.add(allWords[i+2]);
            }
        }

        return thirds.stream().toArray(String[]::new);
    }
}