import java.util.*; 
class Solution {
    String [] word = {"aya", "ye", "woo", "ma"};
    int [] length = {3, 2, 3, 2}; 
    public int solution(String[] babbling) {
        int answer = 0;
        
        for(int i=0; i<babbling.length; i++){
            
            String s = babbling[i]; 
            String temp = ""; 
            while(true){
                boolean flag = false; 
             
                for(int j=0; j<4; j++){
                    if(temp.equals(word[j]))continue; 
                    if(s.indexOf(word[j])==0){       
                        flag = true; 
                        temp = word[j] ;
                        s = s.substring(length[j]);             
                        break; 
                    }               
                }
                if(flag==false) break; 
                if(s.length()==0)
                {
                    answer++; 
                    break; 
                }
            }
        }
        
        
        return answer;
    }
}