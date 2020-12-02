/**
 * URL: https://leetcode.com/problems/clone-graph/
 * 
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

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
 
public class Problem133 {
    
    public static void main(String[] args) {
        Problem133 obj = new Problem133();
        Solution sol = new Solution();

        Node start = obj.getGraph();
        obj.printGraph(start);
        Node result = sol.cloneGraph(start);
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
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        Node cloned = null;
        Map<Node, Node> originalCloneMap = new HashMap<>();
        this.prepareMap(node, originalCloneMap);

        Set<Node> keys = originalCloneMap.keySet();

        for(Node orginal: keys){
            Node clone = originalCloneMap.get(orginal);

            List<Node> cloneNeighbors = new ArrayList<>();
            for(Node neighbor: orginal.neighbors){
                cloneNeighbors.add(originalCloneMap.get(neighbor));
            }
            clone.neighbors = cloneNeighbors;
            if(orginal == node){
                cloned = clone;
            }
        }

        return cloned;
        
    }

    private void prepareMap(Node node, Map<Node, Node> originalCloneMap){
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();

        queue.add(node);
        while(!queue.isEmpty()){
            Node curr = queue.remove();

            // process
            if(!visited.contains(curr)){
                visited.add(curr);
                Node clone = new Node(curr.val);
                originalCloneMap.put(curr, clone);
                for(Node child: curr.neighbors){
                    queue.add(child);
                }

            }

        }
        
    }
}