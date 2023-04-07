import java.util.*; 
class Solution {
    
    static Stack <Integer> stack; 
    static List<Integer> answer; 
    public int solution(int[] order) {
        answer = new ArrayList<>(); 
        stack = new Stack<>(); 
        int x = 1; 

        for(int cur : order){
            
            if(x<=cur){
                for(x=x; x<=cur; x++){
                    stack.add(x); 
                }
            }
            if(!stack.isEmpty()&&stack.peek()==cur){
                answer.add(stack.pop()); 
            }
            else break; 
        }
        
    
        return answer.size();
    }
}