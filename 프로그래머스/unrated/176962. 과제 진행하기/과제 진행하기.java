import java.util.*; 
class Solution {
    Stack <Node> stack; 
    PriorityQueue<Node> pq; 
    public String[] solution(String[][] plans) {
        
        stack = new Stack<>(); 
        pq = new PriorityQueue<>(); 
        for(int i=0; i<plans.length; i++){
            String title = plans[i][0]; 
            String[]temp = plans[i][1].split(":"); 
            int time = Integer.parseInt(temp[0])*60 + Integer.parseInt(temp[1]); 
            int play = Integer.parseInt(plans[i][2]); 
            pq.add(new Node(title, time, play)); 
        }
        int cnt = 0; 
        int index = 0; 
        String[] answer = new String[plans.length];
        while(!pq.isEmpty()){
            
            if(pq.peek().startTime==cnt){
                Node node = pq.poll(); 
                node.playTime-=1; 
                stack.add(node);     
            }
            else{
                if(!stack.isEmpty()){
                    Node node = stack.pop(); 
                    node.playTime-=1; 
                    stack.add(node); 
                }
            }
            
            if(!stack.isEmpty()){
                if(stack.peek().playTime==0){
                    answer[index++] = stack.pop().title; 
                }
            }
            cnt++; 
        }
         while(!stack.isEmpty()){
   
                answer[index++] = stack.pop().title; 
        
         }
        return answer;
    }
    static class Node implements Comparable<Node>{
        String title; 
        int startTime; 
        int playTime;
        public Node(String title, int startTime, int playTime){
            this.title = title; 
            this.startTime = startTime; 
            this.playTime = playTime; 
        }
        public int compareTo(Node node){
            return this.startTime - node.startTime; 
        }
    }
    
}