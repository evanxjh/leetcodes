package Greedy;

/**
 * @author EvanHsia
 * @ClassName Huffman.java
 * @Description 哈夫曼编码
 * @createTime 2019-10-08- 18:53
 */

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 哈夫曼编码采用了贪心策略：使出现频率最高的字符的编码最短，从而保证整体的编码长度最短。
 * 首先生成一颗哈夫曼树，每次生成过程中选取频率最少的两个节点， 生成一个新节点作为它们的父节点，
 * 并且新节点的频率为两个节点的和。 选取频率最少的原因是，生成过程使得先选取的节点位于树的更低层，
 * 那么需要的编码长度更长，频率更少可以使得总编码长度更少。
 */
public class Huffman {
    private class Node implements Comparable<Node>{
        char ch;
        int freq;
        boolean isLeaf;
        Node left,right;

        public Node(char ch,int freq){
            this.ch=ch;
            this.freq=freq;
            this.isLeaf=true;
        }

        public Node(Node left,Node right,int freq){
            this.left=left;
            this.right=right;
            this.freq=freq;
            this.isLeaf=false;
        }
        @Override
        public int compareTo(Node o) {
            return this.freq-o.freq;
        }
    }

    public Map<Character,String> encode(Map<Character,Integer> frequencyForChar){
        //利用最小堆，方便取出频率最小的两个元素
        PriorityQueue<Node> pq=new PriorityQueue<Node>();
        for (Character c:frequencyForChar.keySet()){
            pq.offer(new Node(c,frequencyForChar.get(c)));
        }

        while(pq.size()!=1){
            Node node1=pq.poll();
            Node node2=pq.poll();
            pq.add(new Node(node1,node2,node1.freq+node2.freq));
        }
        return encode(pq.peek());
    }

    private Map<Character,String> encode(Node node){
        Map<Character,String> encodingForChar=new HashMap<>();
        encode(node,"",encodingForChar);
        return encodingForChar;
    }


    //生成编码
    private void encode(Node node,String encoding,Map<Character,String> encodingForChar){
        if (node.isLeaf){
            encodingForChar.put(node.ch,encoding);
            return;
        }
        encode(node.left,encoding+'0',encodingForChar);
        encode(node.right,encoding+'1',encodingForChar);
    }

}
