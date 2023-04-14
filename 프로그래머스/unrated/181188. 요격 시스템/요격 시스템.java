import java.util.*; 
class Solution {
    static PriorityQueue<Node> q; 
    public int solution(int[][] targets) {
        int answer = 0;
        q = new PriorityQueue<>(); 
        for(int i=0; i<targets.length; i++){
            int a = targets[i][0]; 
            int b = targets[i][1]; 
            q.add(new Node(a, b)); 
        }
        int s = 0; 
        int e = 0;
        
        while(!q.isEmpty()){
            Node node = q.poll(); 
            int start = node.start; 
            int end = node.end; 
            
            if(s==0&&e==0){
                s = start; 
                e = end; 
                
                answer++; 
                continue; 
            }
            if(start>=e){
                s = start; 
                e = end; 
                answer++; 
            }
            else if(start<=e){
                s = start; 
                if(e>end)e = end; 
            }
     
        }
        
        return answer;
    }
    
    static class Node implements Comparable<Node>{
        
        int start; 
    
   
        int end; 
        public Node(int start, int end){
            this.start = start; 
            this.end = end; 
        }
        public int compareTo(Node n){
            if(this.start==n.start){
                return n.end - this.end; 
            }
            return this.start - n.start; 
        }
        
    }
}

//출발시간 가장 빠른거 
//가장 긴거 