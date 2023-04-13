import java.util.*; 

class Solution {
    static Map<String, Integer> map; 
    static int end; 
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        map = new HashMap<>(); 
        int start = 0; 
        end = 9; 
        for(int i=0; i<=9; i++){
            map.put(discount[i], map.getOrDefault(discount[i], 0)+1); 
        }
        
        int cnt = 0; 
        
        while(true){
            boolean flag = false; 
            for(int i = 0; i<want.length; i++){
                if(map.getOrDefault(want[i],0)!=number[i]){
                    flag = true; 
                    break; 
                }
            }
            if(flag==false)cnt++; 
            if(end+1==discount.length)break; 
            map.put(discount[end+1], map.getOrDefault(discount[end+1], 0)+1); 
            map.put(discount[start], map.get(discount[start])-1);
            end++; 
            start++; 
            //cnt++; 
        }
        
        return cnt;
    }
}