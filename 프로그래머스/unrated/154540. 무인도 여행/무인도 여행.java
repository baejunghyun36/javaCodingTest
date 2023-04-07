import java.util.*; 
class Solution {
    static int [][] visited; 
    static int m, n; 
    static int [] answer; 
    static Queue<int[]> q; 
    static int []dx = {0,0,1,-1}; 
    static int []dy = {1,-1,0,0}; 
    static char[][] map; 
    static ArrayList<Integer> list; 
    public int[] solution(String[] maps) {
        
        int[] answer = {};
        list = new ArrayList<>(); 
        m = maps.length; 
        n = maps[0].length(); 
        q = new LinkedList<>();
        map = new char[m][n]; 
        visited = new int[m][n]; 
        for(int i=0; i<m; i++)map[i] = maps[i].toCharArray(); 
        for(int i=0; i<m; i++){
            String s = maps[i]; 
            
            for(int j=0; j<n; j++){
                if(s.charAt(j)!='X'&&visited[i][j]==0){
                    System.out.println("호출"); 
                    visited[i][j] = 1;
                    q.add(new int[]{i, j}); 
                    int x = bfs()+map[i][j]-'0';                 
                    if(x!=0)list.add(x); 
                    
                }    
            }
        }        
        if(list.size()==0) answer = new int[]{-1};         
        else{
            Collections.sort(list); 
            answer = new int[list.size()]; 
            for(int i=0; i<list.size(); i++){
                System.out.println(list.get(i));
                answer[i] = list.get(i); 
            }
        }
        Arrays.sort(answer); 
        return answer;
    }
    static int bfs(){
        int area = 0; 
        while(!q.isEmpty()){
            int [] yx = q.poll(); 
            for(int i=0; i<4; i++){
                int ny = dy[i]+yx[0]; 
                int nx = dx[i]+yx[1];              
                if(ny<0||ny>=m||nx<0||nx>=n)continue; 
                if(visited[ny][nx]==1||map[ny][nx]=='X')continue;
                area+=map[ny][nx]-'0'; 
                visited[ny][nx] =1; 
                q.add(new int []{ny, nx}); 
            }
        }
 
        return area; 
        
        
    }
}