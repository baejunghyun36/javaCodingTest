class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        
        if(num_list.length>=11){
            int sum = 0; 
            for(int i=0; i<num_list.length; i++){
            sum+=num_list[i]; 
                answer = sum; 
        }
        }
        else{
            int sum = 1; 
                    for(int i=0; i<num_list.length; i++){
            sum*=num_list[i]; 
                        
        }         answer = sum; 
        }

        
        return answer;
    }
}