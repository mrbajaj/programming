/**
 * URL: 
 * Tags: LinkedList
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
 
public class Graph {
    
    public static void main(String[] args) {
        Graph obj = new Graph();
        Solution sol = new Solution();

        Node start = obj.getGraph();
        obj.printGraph(start);
        Node result = sol.func(start);
        obj.printGraph(result);

    }

    private Node getGraph(){
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);

        one.addNeighbor(two);
        two.addNeighbor(three);
        three.addNeighbor(four);
        four.addNeighbor(one);
        four.addNeighbor(five);
        return one;
    }

    public void printGraph(Node node){
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


class Solution {
    public Node func(Node node) {
        
        return node;
        
    }
}