package programmers;

import java.util.Arrays;

public class Solution_최소직사각형  {
    static int answer; 
    static int [][] info; 
    static int maxWidth, maxHeight; 

    public int solution(int[][] sizes) {
        maxWidth = 0; 
        maxHeight = 0; 
        info = sizes; 
        Arrays.sort(info); 
        answer = 987654321; 
     //  dfs(0, info[0][0], info[0][1]); 
        return answer;
    }
    
    	
}