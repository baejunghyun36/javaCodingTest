import java.util.*; 
class Solution {
    public int[] solution(int n) {
        
        ArrayList<Integer> list = new ArrayList<>(); 
        
        for(int i=1; i<=n; i++){
            if(i%2==1)list.add(i); 
        }
        int [] answer = new int [list.size()]; 
        int i= 0; 
        for(int x : list){
            answer[i++] = x; 
        }
        return answer;
    }
}