import java.util.*; 
class Solution {
    
    static int [] dx = {0, 1, -1}; 
    static int [] dy = {1, 0, -1}; 
    static int [][] arr; 
    static int n; 
    static int number = 1; 
    public int[] solution(int nn) {
        int[] answer = {};
        n = nn; 
        arr = new int[n+3][n+3];
        arr[n+1][1] = arr[n][n+1] = 1; 
        dfs(0, 1, 0, n); 
        List <Integer> answerList = new ArrayList<>(); 
       
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                answerList.add(arr[i][j]);
            }
        }
        
        answer = new int[answerList.size()]; 
        int index = 0; 
        for(int x : answerList){
            answer[index++] = x; 
        }
        
        return answer;
    }
    
    static void dfs(int y, int x, int index, int cnt){

        while(cnt-->0){
            for(int i=0; i<cnt+1; i++){
                y+=dy[index]; 
                x+=dx[index]; 
                arr[y][x] = number++; 
            }
            index = (index+1)%3;    
        }
     
    }
}


