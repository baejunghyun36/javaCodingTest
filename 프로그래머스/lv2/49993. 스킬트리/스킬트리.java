class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = skill_trees.length;
        
        int [] weight = new int [26]; 
        int w = 1; 
        for(int i = 0; i<skill.length(); i++){
            weight[skill.charAt(i)-65] = w++; 
        }
        
        for(int i =0; i<skill_trees.length; i++){
    
            String s = skill_trees[i]; 
            int seq = 1; 
            int [] visited = new int[26]; 
            for(int j= 0; j<s.length(); j++){
                char c = s.charAt(j); 
                if(weight[c-65]==0)continue;
                if(visited[c-65]==1)continue; 
                if(weight[c-65]==seq){
                    visited[c-65] = 1; 
                    seq++; 
                }
                else {
                    answer--; 
                    break; 
                }
            }
        }
        
        
        
        return answer;
    }
}