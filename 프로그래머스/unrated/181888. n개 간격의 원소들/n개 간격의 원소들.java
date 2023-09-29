import java.util.*; 
class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] answer = {};
        ArrayList<Integer> list =new ArrayList<>();
        for(int i=0; i<num_list.length; i+=n){
            list.add(num_list[i]); 
        }
        answer = new int[list.size()]; 
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i); 
        }
        return answer;
    }
}