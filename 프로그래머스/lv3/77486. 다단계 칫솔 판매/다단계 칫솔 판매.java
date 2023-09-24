import java.util.*; 
class Solution {
    static Map<String, Integer> map;
    static int [] parent; 
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int [enroll.length+1]; 
        map = new HashMap<>(); 
        int index = 1; 
        for(int i=0; i<enroll.length; i++){
            map.put(enroll[i], index++); 
        }
        parent = new int [map.size()+1]; 
        
        for(int i=0; i<referral.length; i++){
            String s = referral[i]; 
            if(s.equals("-"))continue; 
            parent[i+1] = map.get(s); 
        }
        for(int i=0; i<seller.length; i++){
            
            String s = seller[i]; 
            int cur = map.get(s); 
         
            int cost = amount[i]*100; 
            while(true){
                if(parent[cur]==0){
                    answer[cur] += cost-cost/10; 
                    break;                     
                }
                else{
                    answer[cur] += cost - cost/10; 
                    cost/=10;                     
                }
                cur = parent[cur]; 
               
            }           
        
        }
        int [] arr = new int [enroll.length]; 
        for(int i=0; i<enroll.length; i++){
            arr[i] = answer[i+1]; 
        }
        
        return arr;
    }
}