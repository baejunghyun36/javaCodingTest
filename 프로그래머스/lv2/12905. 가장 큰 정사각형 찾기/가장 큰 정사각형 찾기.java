import java.util.*; 
class Solution
{
    static int answer; 
    static int m, n; 
    public int solution(int [][]board)
    {
        m = board.length; 
        n = board[0].length; 
        if(m==1||n==1)return 1; 

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
              if(board[i][j] !=0) board[i][j] = Math.min(board[i-1][j-1],Math.min(board[i-1][j],board[i][j-1]))+1;         
              answer = Math.max(answer, board[i][j]);
            }
        }
        
        return (int)Math.pow(answer, 2); 
    }
}