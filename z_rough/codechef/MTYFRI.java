import java.io.*;
import java.util.*;
import java.lang.*;

class MTYFRI{

    public int min(int[] seq,int n){
        // returns max value index from even position
        int ind = 0;
        for(int i = 2; i<n; i++){
            if(i%2 == 0 && seq[ind] < seq[i]){
                ind = i;
            }
        }
        return ind;
    }

    public int max(int[] seq,int n){
        //return min value index from odd position
        int ind = 1;
        for(int i = 3; i<n; i++){
            if(i%2 != 0 && seq[ind] > seq[i]){
                ind = i;
            }
        }
        return ind;
    }

    public boolean canTomuWin(int[] seq, int n){
        // returns true if tomu wins
        int motu=0;
        int tomu=0;
        for(int i=0; i<n; i++){
            if(i==0 || i%2 ==0){
                // even
                motu += seq[i];
            }else{
                tomu += seq[i];
            }
        }
        if(tomu > motu){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args){
        MTYFRI obj = new MTYFRI();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int testCase=0; testCase < t; testCase++){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int tmp;
            int[] seq = new int[n];

            for(int i=0; i<n; i++){
                seq[i] = sc.nextInt();
            }

            for(int swap_itr = 0; swap_itr < k; swap_itr ++){
                // find max value index from even position
                // find min value index from odd position
                // swap min index value and max index value

                tmp = seq[ obj.max(seq,n) ];
                seq[ obj.max(seq,n) ] = seq[ obj.min(seq,n) ];
                seq[ obj.min(seq,n) ] = tmp;
            }

            if(obj.canTomuWin(seq,n)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }




        }


        sc.close();
    }
}




// https://www.cc.com/MAY18B/problems/MTYFRI

/*
Input:
2
6 0
1 1 1 1 1 1
5 1
2 4 6 3 4

Output:
NO
YES

 */
