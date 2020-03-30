/**
 * URL: https://leetcode.com/problems/generate-parentheses/
 * 
 */
import java.util.ArrayList;
import java.util.List;

class Problem22{
    public static void main(String[] args) {
        Problem22 obj = new Problem22();

        System.out.println("Ans: "+ obj.generateParenthesis(3));
    }
    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();
        if(n == 0){
            return results;
        }
        char[] current = new char[n*2];
        // current[0] = '(';
        // this.backtrack(n, 1, 0, results, current, 1);
        this.backtrack(n, 0, 0, results, current, 0);

        return results;
    }

    public void backtrack(int n, int open, int close, List<String> results, char[] current, int position){
        System.out.println("current:"+ String.valueOf(current) + "\topen:"+ open + "\tclose:" + close + "\tposition:"+position);
        if(close == n){
            results.add(String.valueOf(current));
            System.out.println();
            return;
        }

        if(open < n){
            // add opening
            current[position] = '(';
            this.backtrack(n, open+1, close, results, current, position+1);
        }

        if(close < open){
            // add closing
            current[position] = ')';
            this.backtrack(n, open, close+1, results, current, position+1);
        }
        
    }
}