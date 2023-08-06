class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] answer = {};

        int [] ans = new int [num_list.length - n+1]; 
        for(int i=n-1; i<num_list.length; i++){
            ans[i-n+1] = num_list[i]; 
        }
        return ans;
    }
}