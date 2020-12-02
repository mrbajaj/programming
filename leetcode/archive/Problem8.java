/**
 * URL: https://leetcode.com/problems/string-to-integer-atoi/
 * 
 */


class Problem8{
    public static void main(String[] args) {
        Problem8 obj = new Problem8();
        System.out.println("Ans: " + obj.myAtoi(""));
        System.out.println("Ans: " + obj.myAtoi("       "));
        System.out.println("Ans: " + obj.myAtoi("-+1"));
        System.out.println("Ans: " + obj.myAtoi("-"));
        System.out.println("Ans: " + obj.myAtoi("+"));
        System.out.println("Ans: " + obj.myAtoi("words and 987"));
        System.out.println("Ans: " + obj.myAtoi("4193 with words"));
        System.out.println("Ans: " + obj.myAtoi("      +42"));
        System.out.println("Ans: " + obj.myAtoi("      42"));
        System.out.println("Ans: " + obj.myAtoi("42"));
        System.out.println("Ans: " + obj.myAtoi("-42"));
        System.out.println("Ans: " + obj.myAtoi("-91283472332")); // -2147483648
        System.out.println("Ans: " + obj.myAtoi("214748364800")); // 2147483647
        
        
    }

    
    public int myAtoi(String str) {
        if(str.length() == 0){
            return 0;
        }
        long value = 0;
        int index = 0;
        boolean isNegative = false;
        int unwantedSpace = 0;
        while(unwantedSpace < str.length() && str.charAt(unwantedSpace) == ' '){
            unwantedSpace++;
        }
        str = str.substring(unwantedSpace);
        if(str.length() == 0){
            return 0;
        }
        if(str.charAt(0) != '-' && str.charAt(0) != '+' &&  !Character.isDigit(str.charAt(0))){
            return 0;
        }
        if(str.length() >=2 && str.charAt(0) == '-' && str.charAt(1) == '+'){
            return 0;
        }
        if(str.charAt(0) == '-'){
            isNegative = !isNegative;
            str = str.substring(1);
        }
        if(str.length() == 0){
            return 0;
        }
        if(str.charAt(0) == '+'){
            str = str.substring(1);
        }

        // System.out.println("\tstr: " + str);
        for(; index < str.length(); index++){
            if(!Character.isDigit(str.charAt(index))){
                break;
            }
            int digit = Character.getNumericValue(str.charAt(index));
            value = value * 10 + digit ;
            if(!this.isInRange(isNegative, digit, value)){
                return (isNegative) ? -2147483648 : 2147483647;
            }
            // System.out.println("\t index: " + index + " digit:" + digit + " value:" + value);
        }
        int result = (int) value;
        return (isNegative == true) ? -1 * result : result;
    }

    private boolean isInRange(boolean isNegative, int digit, long value){
        if(isNegative){
            value = -1 * value;
            if(value < Integer.MIN_VALUE){
                return false;
            }
        }else if(value > Integer.MAX_VALUE){
            return false;
        }
        return true;
    }

}