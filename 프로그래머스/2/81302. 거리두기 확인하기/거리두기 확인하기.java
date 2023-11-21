import java.util.*; 
class Solution {
    static char [][] map; 
    static int limit = 2; 
    static int [] dx = {0,0,1,-1}; 
    static int [] dy = {1, -1, 0, 0}; 
    static int n=5; 
    static int [][] visited; 
    static Queue <int[]> q; 
    public int[] solution(String[][] places) {

        int[] answer = new int[places.length]; 
        map = new char[5][5];
        for(int i=0; i<places.length; i++){
     
            for(int j=0; j<places[i].length; j++){
                map[j] = places[i][j].toCharArray(); 
                System.out.println(Arrays.toString(map[j])); 
            }
            System.out.println(); 
            out:for(int j=0; j<5; j++){
                for(int k=0; k<5; k++){
                    if(map[j][k]=='P'){
                        visited = new int[5][5]; 
                        q = new LinkedList<>(); 
                        q.add(new int[]{j, k, 0}); 
                        visited[j][k] = 1; 
                        if(bfs()==false){
                            answer[i] = 0; 
                            break out; 
                        } 
                    }
                }
                answer[i] = 1; 
            }
        }
        return answer;
    }
    static boolean bfs(){
        
        while(!q.isEmpty()){
            
            int [] info = q.poll(); 
 
            
            if(info[2]==2)return true; 
            for(int i=0; i<4; i++){
                int nx = info[1]+dx[i]; 
                int ny = info[0]+dy[i];
                if(ny<0||ny>=n||nx<0||nx>=n)continue; 
                if(visited[ny][nx]==1)continue; 
                if(map[ny][nx]=='X')continue; 
                if(map[ny][nx]=='P') {
                    return false;
                }
                visited[ny][nx] = 1; 
                q.add(new int []{ny, nx, info[2]+1}); 
            }
        }
        return true; 
    }
}