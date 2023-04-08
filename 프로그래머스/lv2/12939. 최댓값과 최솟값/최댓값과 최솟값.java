import java.util.*; 
class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] ss = s.split(" "); 
        int [] arr = new int[ss.length]; 
        for(int i=0; i<ss.length; i++){
            arr[i] = Integer.parseInt(ss[i]); 
        }
        Arrays.sort(arr); 
        answer+=arr[0]+" "+arr[arr.length-1]; 
        
        return answer;
    }
}