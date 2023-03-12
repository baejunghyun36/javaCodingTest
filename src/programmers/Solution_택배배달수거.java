import java.util.*;
class Solution_택배배달수거 {
  static PriorityQueue <Node> dpq;
  static PriorityQueue <Node> ppq;
  static long dis1, dis2, temp1, temp2;
  public long solution(int cap, int n, int[] deliveries, int[] pickups) {
    long answer = 0;
    dpq = new PriorityQueue<>();
    ppq = new PriorityQueue<>();
    for(int i=0; i<deliveries.length; i++){
      if(deliveries[i]!=0)dpq.add(new Node(i+1, deliveries[i]));
      if(pickups[i]!=0)ppq.add(new Node(i+1, pickups[i]));
    }
    while(!(dpq.isEmpty()&&ppq.isEmpty())){

      dis1 = dis2 = 0;
      temp1 = temp2 = cap;
      while(!dpq.isEmpty()){
        Node node = dpq.peek();
        dis1 = Math.max(dis1, node.x);
        node.cnt-=temp1;
        if(node.cnt<=0){
          temp1 = node.cnt*(-1);
          dpq.poll();
        }
        else break;

      }
      while(!ppq.isEmpty()){
        Node node = ppq.peek();
        dis2 = Math.max(dis2, node.x);
        node.cnt-=temp2;
        if(node.cnt<=0) {
          temp2 = node.cnt*(-1);
          ppq.poll();
        }
        else break;
      }
      answer += Math.max(dis1, dis2);
    }
    return answer*2;
  }

  static class Node implements Comparable <Node>{

    int x;
    int cnt;

    public Node (int x, int cnt){
      this.x = x;
      this.cnt = cnt;
    }

    public int compareTo(Node n){
      return n.x - this.x;
    }

  }
}