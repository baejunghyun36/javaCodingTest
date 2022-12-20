package programmers;

import java.util.*; 
class Solution_이중우선순위큐 {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        answer[0]=answer[1]=0; 
        PriorityQueue <Integer> min = new PriorityQueue<>(); 
        PriorityQueue <Integer> max = new PriorityQueue<>(Collections.reverseOrder()); 
        int cnt = 0; 
        int total = 0; 
        for(int i=0; i<operations.length; i++){
            String[] temp = operations[i].split(" "); 
            if(temp[0].equals("I")){
                min.add(Integer.parseInt(temp[1])); 
                max.add(Integer.parseInt(temp[1])); 
                total++; 
            }
            else{
                if(total==cnt) continue;
                if(temp[1].equals("1"))max.poll();
                else if(temp[1].equals("-1"))min.poll();
                cnt++;
            }
        }
        
        if(total!=cnt){
            answer[0]= max.poll(); 
            answer[1] = min.poll(); 
        }
        
        return answer;
    }
}