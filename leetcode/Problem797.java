/**
 * URL: https://leetcode.com/problems/all-paths-from-source-to-target/
 * 
 */
import java.util.List;
import java.util.ArrayList;

public class Problem797{
    public static void main(String[] args) {
        int[][] graph = new int[][]{ {2,4}, {3}, {1,3}, {4}, {} };

        Solution1 obj1 = new Solution1();
        System.out.println("Ans: " + obj1.allPathsSourceTarget(graph));

        Solution2 obj2 = new Solution2();
        System.out.println("Ans: " + obj2.allPathsSourceTarget(graph));
        
    }
    
}

class Solution1{

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        int source = 0, target = graph.length - 1;
        dfs(graph, source, target, path, result);
        return result;
    }
    private void dfs(int[][] graph, int curr, int target, List<Integer> path, List<List<Integer>> result) {
        
        if (curr == target) result.add(new ArrayList<Integer>(path));
        for(int i : graph[curr]){
            path.add(i);
            dfs(graph, i, target, path, result);
            path.remove(path.size() - 1);
        }
    }
}

class Solution2{

    public List<List<Integer>> allPathsSourceTarget(int[][] graph)  
    { 
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        int v = graph.length;
        int s = 0, d = v - 1;
        boolean[] isVisited = new boolean[v]; 
        ArrayList<Integer> pathList = new ArrayList<>(); 
          
        pathList.add(s);
        printAllPathsUtil(graph, s, d, isVisited, pathList, result); 
        return result;
    } 
  
    
    private void printAllPathsUtil(int[][] graph, Integer u, Integer d,  boolean[] isVisited,  List<Integer> localPathList, List<List<Integer>> result) { 
          
        // Mark the current node 
        isVisited[u] = true; 
          
        if (u.equals(d))  
        { 
            result.add(new ArrayList<Integer>(localPathList));
            // if match found then no need to traverse more till depth 
            isVisited[u]= false; 
            return ; 
        } 
          
        // Recur for all the vertices  adjacent to current vertex 
        int[] adjList = graph[u];
        for (Integer i : adjList)  
        { 
            if (!isVisited[i]) 
            { 
                // store current node in path[] 
                localPathList.add(i); 
                printAllPathsUtil(graph, i, d, isVisited, localPathList, result); 
                  
                // remove current node  in path[] 
                localPathList.remove(i); 
            } 
        } 
          
        // Mark the current node 
        isVisited[u] = false; 
    }
}


