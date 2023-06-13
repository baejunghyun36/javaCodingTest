class Solution {
    public int solution(int[] numbers, int n) {
        int answer = 0;
        int index = 0; 
        while(true){
           if(answer>n) break; 
           answer += numbers[index++]; 
        }
        return answer;
    }
}