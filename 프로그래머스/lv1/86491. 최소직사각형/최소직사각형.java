import java.util.*; 
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        for(int i=0; i<sizes.length; i++){
            int a = sizes[i][0]; 
            int b = sizes[i][1]; 
            if(a<b){
                sizes[i][0] = b;
                sizes[i][1] = a; 
            }
        }
        int a = 0; 
        int b = 0; 
        for(int i=0; i<sizes.length; i++){
            a = Math.max(sizes[i][0], a); 
            b = Math.max(sizes[i][1], b);
        }
        
        return a*b;
    }
}