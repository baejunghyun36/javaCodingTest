class Solution {
    public int[] solution(int n, long left, long right) {
        long length = right-left+1; 
        int[] answer = new int[(int)length]; 
        
        int prev = 0;
        int index = 0; 
        while(left<=right){
            int y = (int)(left/(long)n); 
            int x = (int)(left%(long)n);
            int offset = y+1; 
            if(y>=x)answer[index++] = offset; 
            else answer[index++] = x-y + offset; 
            

            left++; 
        }
        
        return answer;
    }
}