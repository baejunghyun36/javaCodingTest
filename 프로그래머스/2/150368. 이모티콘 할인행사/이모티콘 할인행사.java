import java.util.*; 
class Solution {
    static int [] ratioArr = {10, 20, 30, 40}; 
    static int [] discount; 
    static int n; 
    static int [][] users; 
    static int [] emoticons; 
    static int signUpCnt, maxPay; 
    public int[] solution(int[][] user, int[] emoticon) {
        
        int[] answer = new int[2]; 
        discount = new int[emoticon.length]; 
        n = emoticon.length; 
        users = user; 
        emoticons = emoticon; 
        
        bruteForce(0); 
        
        answer[0] = signUpCnt; 
        answer[1] = maxPay; 
        
        return answer;
    }
    
    static void check(){
        
        int cnt = 0; 
        int sum = 0; 
        for(int i=0; i<users.length; i++){
            int ratio = users[i][0]; 
            int limit = users[i][1]; 
            int curPay = 0; 
            // System.out.println(Arrays.toString(discount)); 
            for(int j=0; j<emoticons.length; j++){
                if(ratio<=discount[j]){
                    curPay = curPay + emoticons[j]* (100-discount[j])/100; 
                }
            }
            if(limit<=curPay){
                cnt++; 
            }
            else sum+=curPay; 
        }
        if(signUpCnt<cnt){
            signUpCnt = cnt; 
            maxPay = sum; 
        }
        else if(signUpCnt==cnt&&maxPay<sum){
            maxPay = sum; 
        }
        
    }
    
    static void bruteForce(int index){
        if(index==n){
            check(); 
            return; 
        }
        
        for(int i=0; i<4; i++){
            discount[index] = ratioArr[i]; 
            bruteForce(index+1); 
        }
    }
}