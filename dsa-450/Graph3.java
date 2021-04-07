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
import java.util.Stack;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

    public void addNeighbor(Node neighbor){
        neighbors.add(neighbor);
    }
}
 
public class Graph3 {
    
    public static void main(String[] args) {
        Graph3 obj = new Graph3();
        Solution sol = new Solution();

        Node start = obj.getGraph();
        sol.dfs(start);
        sol.bfs(start);
    }

    // private Node getGraph(){
    //     Node one = new Node(1);
    //     Node two = new Node(2);
    //     Node three = new Node(3);
    //     Node four = new Node(4);
    //     Node five = new Node(5);

    //     one.addNeighbor(two);
    //     two.addNeighbor(three);
    //     three.addNeighbor(four);
    //     four.addNeighbor(one);
    //     four.addNeighbor(five);
    //     return one;
    // }
    private Node getGraph(){
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);

        one.addNeighbor(two);
        one.addNeighbor(five);

        two.addNeighbor(one);
        two.addNeighbor(three);
        two.addNeighbor(six);

        three.addNeighbor(two);
        three.addNeighbor(four);
        
        four.addNeighbor(three);
        four.addNeighbor(five);

        five.addNeighbor(one);
        five.addNeighbor(four);

        six.addNeighbor(two);

        
        return one;
    }
}


class Solution {
    public void dfs(Node node) {
        Set<Node> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();

        stack.add(node);
        while(!stack.isEmpty()){
            Node curr = stack.peek();

            if(!visited.contains(curr)){
                visited.add(curr);
                System.out.print(curr.val + " ");
            }

            Node nextNeighbour = getUnvisitedNeighbour(visited, curr.neighbors);

            if(nextNeighbour != null){
                stack.push(nextNeighbour);
            }else{
                stack.pop();
            }
        }
        System.out.println();
    }
    
    private Node getUnvisitedNeighbour(Set<Node> visited, List<Node> neighbors){
        for(Node neighbor: neighbors){
            if(!visited.contains(neighbor)){
                return neighbor;
            }
        }
        return null;
    }

    public void bfs(Node node){
        //BFS
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();

        queue.add(node);
        while(!queue.isEmpty()){
            Node curr = queue.remove();

            // process
            if(!visited.contains(curr)){
                visited.add(curr);
                System.out.print(curr.val + " ");
                for(Node child: curr.neighbors){
                    queue.add(child);
                }

            }

        }
        System.out.println();

    }
}