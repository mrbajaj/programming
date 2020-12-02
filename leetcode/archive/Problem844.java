/**
 * Runtime: 6 ms, faster than 5.74% of Java online submissions for Backspace String Compare.
 * Memory Usage: 36.5 MB, less than 48.48% of Java online submissions for Backspace String Compare.
 */
 import java.util.Arrays;

class Problem844{

    public static void main(String[] args) {
        Problem844 obj = new Problem844();

        System.out.println("Ans:" + obj.backspaceCompare("ab#c", "ad#c"));

    }

    public boolean backspaceCompare(String S, String T) {
        
        System.out.print("S:" + S + "\t");
        S = ultimateString(S.toCharArray());
        System.out.print("S:" + S + "\t");
        S = S.replaceAll("\\W+", " ");
        System.out.print("S:" + S + "\t");

        System.out.println();
        
        System.out.print("T:" + T + "\t");
        T = ultimateString(T.toCharArray());
        System.out.print("T:" + T + "\t");
        T = T.replaceAll("\\W+", " ");
        System.out.print("T:" + T + "\t");


        System.out.println();

        return S.equals(T);
    }

    private String ultimateString(char[] arr){
        int l = arr.length;

        int backspace = 0;

        for(int i = l-1; i>=0 ; i--){

            if(arr[i] == '#'){
                backspace++;
            }else{
                if(backspace != 0){
                    arr[i] = '$';
                    backspace--;
                }
            }

        }

        return Arrays.toString(arr);

    }
}