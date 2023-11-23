import java.util.*; 
class Solution {

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        PriorityQueue<Node> delQ, picQ;
        delQ = new PriorityQueue<>(); 
        picQ = new PriorityQueue<>();
        init(deliveries, pickups, n, delQ, picQ); 
        return greedySolution(cap, delQ, picQ); 
    }
    
    public void init(int [] deliveries, int [] pickups, int n, PriorityQueue<Node> delQ, PriorityQueue<Node> picQ ){

        for(int i=0; i<n; i++) if(deliveries[i]!=0)delQ.add(new Node(i+1, deliveries[i])); 
        for(int i=0; i<n; i++) if(pickups[i]!=0)picQ.add(new Node(i+1, pickups[i])); 
    }
    
    public int getMaxDistance(PriorityQueue<Node> pq, int cap){
        int c = cap; 
        int dis = -1; 
        while(!pq.isEmpty()&&c>0){
            if(dis==-1) dis = pq.peek().dis; 
            if(c<pq.peek().count){
                pq.peek().count-= c; 
                break; 
            }
            else c-= pq.poll().count; 
        }
        return dis; 
    }
    
    public long greedySolution(int cap, PriorityQueue<Node> delQ, PriorityQueue<Node> picQ){
        long answer = 0; 
        while(true){
            if(delQ.isEmpty()&&picQ.isEmpty())break; 
            answer+= Math.max(getMaxDistance(delQ, cap), getMaxDistance(picQ, cap)); 
        }
        return answer*2; 
    }
    

    
    public class Node implements Comparable<Node>{
        
        int dis; 
        int count; 
        
        public Node (int dis, int count){
            this.dis = dis; 
            this.count = count; 
        }      
        
        public int compareTo(Node node){
            return node.dis - this.dis; 
        }
        
    }
}