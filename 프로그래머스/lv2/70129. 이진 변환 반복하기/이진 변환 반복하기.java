class Solution {
    static int zeroCount; 
    static int changeCount; 
    public int[] solution(String s) {
     
        while(s.length()>1){
            String temp = ""; 
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i)=='1'){
                    temp+='1'; 
                }
                else zeroCount++; 
            }
            changeCount++; 
            s  = Integer.toBinaryString(temp.length());
        }
        
        int[] answer = {changeCount, zeroCount};
        
        return answer;
    }
}