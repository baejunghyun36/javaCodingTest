import java.util.*;
class Solution {
    static int [] answer; 
    static int [][] board; 
    static int n; 
    public int[] solution(int[][] arr) {
        answer = new int [2];
        board = arr;
        n = arr.length; 
        dfs(0, 0, n); 
        
        return answer;
    }
    static void dfs(int y, int x, int offset){
        
        int number = board[y][x];
        boolean flag = false;
        if(offset==1){
            answer[number]++; 
            return; 
        }
           
        out:for(int i=y; i<y+offset; i++){
            for(int j=x; j<x+offset; j++){
                if(number!=board[i][j]){
                    flag = true; 
                    break out; 
                }
            }
        }
        offset/=2; 
 
        if(flag){
            dfs(y, x, offset); 
            dfs(y, x+offset, offset); 
            dfs(y+offset, x, offset); 
            dfs(y+offset, x+offset, offset); 
        }
        
        else answer[number]++; 
    }
}