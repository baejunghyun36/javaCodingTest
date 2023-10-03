class Solution {
    public int[] solution(int n, int k) {
        
        int[] answer = new int [n/k]; 
        int x = 1; 
        for(int i=0; i<answer.length; i++){
            answer[i] = x*k; 
            x++; 
        }
        
        
        
        return answer;
    
    }
}