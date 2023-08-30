class Solution {
    public int solution(int n) {
        int answer = 0;
        int a = 1; 
        int b = n; 
        
        while(a<b){
            
            int x = a * b; 
            if(x==n){answer++;b--;} 
            else if(x>n)b--; 
            else if(x<n)a++; 
        }
        answer*=2; 
        if(a==b&&a*b==n)answer++; 
        return answer;
    }
}