import java.util.*; 
class Solution {
    static Set<Integer> set; 
    public int solution(int[] elements) {
        int answer = 0;
        set = new HashSet<>(); 
     
        for(int i=1; i<=elements.length; i++){
            
            int start = 1; 
            int l = i-1; 
            int sum = 0; 
            
            for(int j=0; j<=l; j++){
                sum+=elements[j]; 
            }
            int end = l; 
            start = 0; 
            set.add(sum); 
            while(start<elements.length){
                sum-=elements[start++]; 
                end++; 
                if(end==elements.length)end = 0; 
                sum+=elements[end]; 
                set.add(sum); 
            }
        }
        
        answer = set.size(); 
        
        
        return answer;
    }
}