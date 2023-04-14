import java.util.*; 
class Solution {
    static int size; 
    static Queue <Node> list1, list2; 
    static Node start; 

    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        list1 = new LinkedList<>(); 
        list2 = new LinkedList<>(); 

        long sum1 = 0; 
        long sum2 = 0; 
        for(int i=0; i<queue1.length; i++){

            list1.add(new Node(queue1[i], i)); 
            list2.add(new Node(queue2[i], i)); 
            if(i==0){
                start = list2.peek(); 
            }
            sum1+=queue1[i]; 
            sum2+=queue2[i]; 
        }
        size = list1.size(); 
        
        while(true){
            
            if(sum1==sum2){
                break; 
            }
            answer++; 
            if(answer==600000)break; 
            if(sum1>sum2){
                sum1-=list1.peek().num; 
                sum2+=list1.peek().num;
                list2.add(list1.poll()); 
            }
            else if(sum2>sum1){
                sum2-=list2.peek().num; 
                sum1+=list2.peek().num; 
                list1.add(list2.poll()); 
            }

        }
        if(sum1!=sum2)answer = -1; 
        return answer;
    }
    static class Node {
        
        int num; 
        int index; 
        
        public Node(int num, int index){
            this.num = num; 
            this.index = index; 
        }
        
    }
}