/**
 * URL: 
 * Tags: Graph
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
 
public class Graph2 {
    
    public static void main(String[] args) {
        Graph2 obj = new Graph2();
        obj.TestCase1();
        obj.TestCase2();
    }

    private void TestCase1(){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> zero = new ArrayList<Integer>();
        zero.add(1); zero.add(2); zero.add(3);
        adj.add(zero);

        ArrayList<Integer> one = new ArrayList<Integer>();
        adj.add(one);

        ArrayList<Integer> two = new ArrayList<Integer>();
        two.add(4);
        adj.add(two);
        
        ArrayList<Integer> three = new ArrayList<Integer>();
        adj.add(three);

        ArrayList<Integer> four = new ArrayList<Integer>();
        adj.add(four);

        
        Solution sol = new Solution();
        ArrayList<Integer> result = sol.bfsOfGraph(5, adj);
        System.out.println(result);
    }

    private void TestCase2(){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> zero = new ArrayList<Integer>();
        zero.add(1); zero.add(2);
        adj.add(zero);

        ArrayList<Integer> one = new ArrayList<Integer>();
        one.add(2);
        adj.add(one);

        ArrayList<Integer> two = new ArrayList<Integer>();
        adj.add(two);
        
        
        Solution sol = new Solution();
        ArrayList<Integer> result = sol.bfsOfGraph(3, adj);
        System.out.println(result);
    }
}


class Solution {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> path = new ArrayList<Integer>();
        if(V == 0){
            return path;
        }
        boolean visited[] = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while(!queue.isEmpty()){
            Integer curr = queue.remove();
            if(visited[curr] == true){
                continue;
            }
            path.add(curr);
            visited[curr] = true;
            ArrayList<Integer> neighbors = adj.get(curr);
            for(Integer neighbor: neighbors){
                queue.add(neighbor);
            }
        }

        return path;
    }
}