package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_카카오프렌즈컬러링북 {

	 static int [][]visited; 
	    static int [] dx = {0,0,1,-1}; 
	    static int [] dy = {1,-1,0,0}; 
	    static int M,N; 
	    public int[] solution(int m, int n, int[][] picture) {
	        int numberOfArea = 0;
	        int maxSizeOfOneArea = 0;
	        M= m; 
	        N= n; 
	        visited = new int [m][n]; 
	        
	        for(int i=0; i<m; i++){
	            for(int j=0; j<n; j++){
	                if(picture[i][j]==0)continue; 
	                if(visited[i][j]==1)continue; 
	                //System.out.println("hi"); 
	                maxSizeOfOneArea = Math.max(bfs(i,j,picture[i][j], picture),maxSizeOfOneArea) ;  
	                numberOfArea++;         
	                
	            }
	        }
	        

	        int[] answer = new int[2];
	        answer[0] = numberOfArea;
	        answer[1] = maxSizeOfOneArea;
	        return answer;
	    }
	    
	    static int bfs(int y, int x, int number, int [][] map){
	        
	        
	        Queue <int []> q = new LinkedList<>(); 
	        q.offer(new int[]{y,x}); 
	        visited[y][x]=1; 
	        int cnt = 1; 
	        while(!q.isEmpty()){
	            
	            int [] yx = q.poll(); 
	            
	            for(int i=0; i<4; i++){
	                int ny = dy[i]+yx[0]; 
	                int nx = dx[i]+yx[1]; 
	                if(nx<0||nx>=N||ny<0||ny>=M)continue; 
	                if(visited[ny][nx]==1)continue; 
	                if(map[ny][nx]!=number)continue; 
	                visited[ny][nx]=1; 
	                q.offer(new int []{ny,nx}); 
	                cnt++; 
	            }
	        }
	        
	        return cnt; 
	        
	        
	    }

}
