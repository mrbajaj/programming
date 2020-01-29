/**
 * URL: https://leetcode.com/problems/hamming-distance/
 */
class Problem461{

    public static void main(String[] args) {
        Problem461 obj = new Problem461();

        System.out.println("Ans: " + obj.hammingDistance(1, 4));
        System.out.println("Ans: " + obj.hammingDistance_manual(1, 4));
    }

    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public int hammingDistance_manual(int x, int y) {
        int z = x ^ y; //xor
        
        int oneBitCount = 0;
        while(z != 0){
            oneBitCount = oneBitCount + (z & 1);
            z >>= 1;
        }

        return oneBitCount;
    }
}