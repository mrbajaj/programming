import java.io.*;
import java.util.*;

public class ArrayListOfArrayList {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            ArrayList<Integer> al = new ArrayList<Integer>();
            int nums = sc.nextInt();
            for(int x=0; x < nums; x++){
                al.add(sc.nextInt());
            }
            mat.add(al);
        }
        int q = sc.nextInt();
        for(int i = 0; i < q; i++){
            Integer row = sc.nextInt() - 1;
            Integer col = sc.nextInt() - 1;
            
            ArrayList ele = mat.get(row);
            try{
                System.out.println(ele.get(col));    
            }catch(Exception e){
                System.out.println("ERROR!");    
            }
        }
    }
}

/*
//  Sample Input
5
5 41 77 74 22 44
1 12
4 37 34 36 52
0
3 20 22 33
5
1 3
3 4
3 1
4 3
5 5
*/