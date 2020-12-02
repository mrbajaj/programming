/**
 * URL: https://leetcode.com/problems/partition-labels/
 * 
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Problem763{
    public static void main(String[] args) {
        Problem763 obj = new Problem763();

        System.out.println("Ans: " + obj.partitionLabels("ababcbacadefegdehijhklij"));
        System.out.println("Ans: " + obj.partitionLabels2("ababcbacadefegdehijhklij"));
    }

    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        
        int[] lastIndex = new int[26];

        for(int i = 0; i < S.length(); i++){
            lastIndex[S.charAt(i) - 'a'] = i;
        }

        int start = 0, end = 0;
        for(int i =0; i< S.length(); i++){
            end = Math.max(end, lastIndex[S.charAt(i) - 'a']);
            if(i == end){
                int ans = end - start + 1;
                result.add(ans);
                start = end +1;
            }
        }

        return result;
    }

    public List<Integer> partitionLabels2(String S) {
        List<Integer> result = new ArrayList<>();
        this.helper(S, result);
        return result;
    }

    private void helper(String S, List<Integer> result){
        char dummy = '#';
        if(S.length() == 0){
            return;
        }
        char[] charArr = S.toCharArray();
        int maxIndex = 0;

        int i=0;
        for(; i <= maxIndex; i++ ){
            char currChar = charArr[i];
            if(currChar == dummy ){
                continue;
            }
            int tmpIndex = i;
            for(int j = i; j < S.length(); j++){
                if(currChar == charArr[j]){
                    charArr[j] = dummy;
                    tmpIndex = j;
                }
                if(maxIndex < tmpIndex){
                    maxIndex = tmpIndex;
                }
            }
        }

        result.add(i);
        helper(S.substring(i), result);

    }
}