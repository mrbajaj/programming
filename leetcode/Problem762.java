import java.util.HashMap;
import java.util.Map;

/**
 * URL: https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/
 * 
 */

 class Problem762{

    public static void main(String[] args) {
        Problem762 obj = new Problem762();

        System.err.println("Ans: " + obj.countPrimeSetBits(6, 10));

        System.err.println("Ans: " + obj.countPrimeSetBits(10, 15));
         
    }

    public Boolean isPrime(int x, Map<Integer,Boolean> isPrimeMap){
        if(isPrimeMap.containsKey(x)){
            return isPrimeMap.get(x);
        }
        Boolean isPrime = true;

        if(x == 1){
            isPrimeMap.put(x, !isPrime);
            return !isPrime;
        }

        for(int i=2; i <= Math.sqrt(x); i++){
            if(x%i == 0){
                isPrime = false;
                break;
            }
        }

        isPrimeMap.put(x, isPrime);
        return isPrime;
    }

    public int getBitCount(int x){
        int bc = 0, tmp;
        while(x>0){
            tmp = x & 1;
            if(tmp == 1){
                bc++;
            }
            x = x >> 1;
        }
        return bc;
    }

    public int countPrimeSetBits(int L, int R) {
        Map<Integer,Boolean> isPrimeMap = new HashMap<>();
        int countPrimeSetBits = 0; 
        int bitCount;
        boolean isPrime;

        for(int x = L; x<= R; x++){
            bitCount = this.getBitCount(x);
            isPrime = this.isPrime(bitCount, isPrimeMap);
            // System.out.println("x:" + x + "\tbitcount=" + bitCount + " :" + isPrime );

            if( isPrime ){
                countPrimeSetBits++;
            }

        }
        // System.out.println(isPrimeMap);
        
        
        return countPrimeSetBits;
    }

 }