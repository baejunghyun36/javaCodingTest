package programmers;
import java.util.*; 

class Solution_거리두기확인하기 {
    static int [] dx = {0,0,-1,1}; 
    static int [] dy = {1,-1,0,0}; 
  
    static int [][] visited; 
    static int [][] map; 
    static Queue <int[]> q; 
     
    public int[] solution(String[][] places) {
        
        int[] answer = new int [places.length];

        for(int room = 0; room<5; room++){
    
            map = new int [5][5]; 
            List <int []> list = new ArrayList<>(); 
      
            for(int i=0; i<places[room].length; i++){
                String s = places[room][i]; 
                for(int j=0; j<5; j++){
                    if(s.charAt(j)=='P'){
                        map[i][j] = 1; 
                        list.add(new int []{i,j});                                  
                    }
                    else if(s.charAt(j)=='O')map[i][j]= 0; 
                    else map[i][j] = -1; 
                }
                //System.out.println(Arrays.toString(map[i])); 
            }
            if(list.size()==0)answer[room]=1; 
            for(int i=0; i<list.size(); i++){
                q = new LinkedList<>(); 
                int [] yx = list.get(i); 
                visited = new int [5][5]; 
                q.offer(list.get(i)); 
                visited[yx[0]][yx[1]]=1; 
                if(bfs())answer[room] = 1;                 
                else {answer[room] = 0; break;  }
            }
        }
        
        return answer;
    }
    
    static boolean bfs(){        
        int cnt = 0; 
        
        while(!q.isEmpty()){     
            cnt++; 
            if(cnt==3)break; 
            int size = q.size(); 
            while(0<size--){
                int [] yx = q.poll(); 
                int y = yx[0]; 
                int x = yx[1]; 
                for(int i=0; i<4; i++){
                    int nx = x + dx[i]; 
                    int ny = y + dy[i];                    
                    if(nx<0||nx>=5||ny<0||ny>=5)continue; 
                    if(visited[ny][nx]==1)continue; 
                    if(map[ny][nx]==-1)continue; 
                    if(map[ny][nx]==1)return false; 
                    visited[ny][nx]=1; 
                    q.add(new int []{ny,nx});                     
                }
            }
        }
        return true;         
    }
}