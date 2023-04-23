class Solution {
    public int solution(int num1, int num2) {
        int answer = 0;
        double x = (double)num1/num2; 
        x*=1000; 
        
        return (int) x;
    }
}