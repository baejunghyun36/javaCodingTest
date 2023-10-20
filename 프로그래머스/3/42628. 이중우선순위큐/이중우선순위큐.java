import java.util.*; 
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        StringTokenizer st = null; 
        PriorityQueue<Integer> minQ = new PriorityQueue<>(); 
        PriorityQueue<Integer> maxQ = new PriorityQueue<>((o1, o2) -> o2-o1); 
        for(String op : operations){
            st = new StringTokenizer(op); 
            String s = st.nextToken(); 
            int x = Integer.parseInt(st.nextToken()); 
            if(s.equals("I")){
                minQ.add(x); 
                maxQ.add(x); 
            }
            else{
                if(maxQ.isEmpty())continue; 
                if(x>=0){
                    int v = maxQ.poll(); 
                    minQ.remove(v); 
                }
                else {
                    int v = minQ.poll(); 
                    maxQ.remove(v); 
                }
            }
        }
        if(!maxQ.isEmpty()){
            answer[0] = maxQ.peek(); 
            answer[1] = minQ.peek(); 
        } 
        return answer;
        
    }
    
    
}