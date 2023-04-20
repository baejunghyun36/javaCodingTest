class Solution {
int solution(int a, int b) {
    int answer = 0;
    String s = a+""+b; 
    return Math.max(Integer.parseInt(s), a*b*2); 
    }
}