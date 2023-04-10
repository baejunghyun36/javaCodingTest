import java.util.*; 
class Solution {
    static int m, n; 
    static List<int[]> list; 
    static int [][] map;
    static int answer = 987654321;
    public int solution(int[][] beginning, int[][] target) {
     
        m = beginning.length; 
        n = beginning[0].length; 
        
        list = new ArrayList<>(); 
        
        for(int i=0; i<m; i++) list.add(new int[]{i+1, 0}); 
        for(int j=0; j<n; j++) list.add(new int[]{0, j+1});
        
        
        check (beginning, target, list, 0, 0); 
        if(answer == 987654321)answer = -1; 
        
        //1024 * 1024 == 1000 000 
        
        return answer;
    }
    

    
    static void check(int [][] b, int [][] t, List<int[]> list, int index, int count){
          
        if(index==list.size()){
            boolean flag = false; 
            out:for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(b[i][j]!=t[i][j]){
                        flag = true; 
                        break out; 
                    }
                }
            }
            if(!flag)answer = Math.min(answer, count); 
            
            return;
        } 
        // 안뒤집어
        check (b, t, list, index+1, count); 
        
        int y = list.get(index)[0];
        int x = list.get(index)[1]; 
        
        if(y>=1){
            for(int j=0; j<n; j++)t[y-1][j]^=1;
        }
        else{
            for(int i=0; i<m; i++)t[i][x-1]^=1; 
        }
        
        //뒤집어
        check(b, t, list,index+1, count+1); 
        
        if(y>=1){
            for(int j=0; j<n; j++)t[y-1][j]^=1;
        }
        else{
            for(int i=0; i<m; i++)t[i][x-1]^=1; 
        }
        
    }
}
