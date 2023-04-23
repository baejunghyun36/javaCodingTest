class Solution {
    static int [] num ; 
    public int solution(int n) {
        int answer = 0;
        num = new int[100001]; 
        num[0] = 0; 
        num[1] = 1; 
        num[2] = 1; 
        for(int i=3; i<=n; i++){
            num[i] = (num[i-2]+num[i-1])%1234567; 
        }
        answer = num[n]; 
        return answer;
    }
}