import java.util.*; 
class Solution {
    
    static int [] discount; 
    static int totalPlus; 
    static int totalCost; 
    static int [] percent = {40, 30, 20, 10}; 
    static int [][] users; 
    static int []emoticons; 
    public int[] solution(int[][] u, int[] e) {
        int[] answer = new int [2];
        users = u; 
        emoticons = e; 
        discount = new int [emoticons.length]; 
        brute(0); 
        answer[0] = totalPlus; 
        answer[1] = totalCost; 
        
        return answer;
    }
    static void check(){
        
        int plusCount = 0; 
        int checkCost = 0; 
        for(int i=0; i<users.length; i++){
            int userPercent = users[i][0];
            int userCost = users[i][1]; 
            int temp = 0; 
            boolean flag = true; 
            for(int j=0; j<discount.length; j++){
                if(userPercent>discount[j])continue; 
                else{
                    int cost = emoticons[j]*(100-discount[j])/100; 
                    temp+=cost; 
                    if(temp>=userCost){
                        plusCount++; 
                        flag = false; 
                        break; 
                    }
                }
            }         
            if(flag) checkCost+=temp; 
        }
        if(totalPlus<plusCount){
            totalPlus = plusCount; 
            totalCost = checkCost; 
        }
        else if(totalPlus==plusCount){
            if(totalCost<checkCost)totalCost = checkCost; 
        }
        return; 
    }
    
    static void brute(int level){
        if(level==discount.length){
            check(); 
            return; 
        }

            for(int j=0; j<4; j++){
                discount[level] = percent[j]; 
                brute(level+1); 
            }
    
    }
}