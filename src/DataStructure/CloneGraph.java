package DataStructure;

import java.util.*;

/**
 * @author EvanHsia
 * @ClassName CloneGraph.java
 * @Description No.133 Medium
 * @createTime 2019-10-09- 13:58
 */
public class CloneGraph {
    //把新老节点通过map关联起来
    //BFS
    public Node cloneGraph(Node node){
        if (node==null){
            return null;
        }
        Map<Node,Node> visited=new HashMap<>();
        Queue<Node> queue=new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()){
            Node cur=queue.poll();
            Node cloneNode=visited.compute(cur,(k,v)->v==null?new Node(cur.val,new LinkedList<>()):v);

            cur.neighbors.forEach(neighbor->{
                if (!visited.containsKey(neighbor)){
                    queue.offer(neighbor);
                    Node cloneNeighbor=new Node(neighbor.val,new LinkedList<>());
                    cloneNode.neighbors.add(cloneNeighbor);
                    visited.put(neighbor,cloneNeighbor);
                }else {
                    cloneNode.neighbors.add(visited.get(neighbor));                     //已经访问过的节点，直接将其neighbor复制过来即可
                }
            });
        }
        return visited.get(node);
    }


    //DFS
    Map<Node,Node> oldtonew=new HashMap<>();
    public Node cloneGraph2(Node node){
        if (node==null){
            return null;
        }
        //不访问重复节点
        if (oldtonew.containsKey(node)){
            return oldtonew.get(node);
        }
        Node newNode=new Node(node.val,new LinkedList<>());
        oldtonew.put(node,newNode);
        for (Node neighbor:node.neighbors){
            newNode.neighbors.add(cloneGraph2(neighbor));
        }
        return newNode;
    }
    class Node{
        public int val;
        public List<Node> neighbors;
        public Node(){}
        public Node(int val,List<Node> neighbors){
            this.val=val;
            this.neighbors=neighbors;
        }
    }
}
