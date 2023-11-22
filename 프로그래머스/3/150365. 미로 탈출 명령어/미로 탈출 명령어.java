import java.util.*; 
class Solution {
    //dlru
    static int [] dy = {1, 0,0,-1}; 
    static int [] dx = {0, -1, 1, 0}; 
    static int [][][] visited; 
    static Queue<Node> q; 
    static Map<Integer, Character> dir; 
    static int m, n, startY, startX, endY, endX, k; 
    public String solution(int M, int N, int Y, int X, int r, int c, int K) {
        String answer = "";
        m = M; 
        n = N; 
        startY = Y-1; 
        startX = X-1; 
        endY = r-1; 
        endX = c-1; 
        dir = new HashMap<>(); 
        dir.put(0, 'd'); 
        dir.put(1, 'l'); 
        dir.put(2, 'r'); 
        dir.put(3, 'u'); 
        k = K; 
        q = new LinkedList<>(); 
        visited = new int[k+1][m+1][n+1]; 
        visited[0][startY][startX] = 1; 
        q.add(new Node(startY, startX, 0, ""));     
        answer = bfs();
        
        return answer;
    }
    
    static String bfs(){
        
        while(!q.isEmpty()){
            Node node = q.poll(); 
            int y = node.y; 
            int x = node.x; 
            // System.out.println(y+" " + x + " " + node.s);
            if(node.k==k&&y==endY&&x==endX) return node.s; 
            
            for(int i=0; i<4; i++){
                int nx = dx[i] + x; 
                int ny = dy[i] + y; 
                if(ny<0||ny>=m||nx<0||nx>=n)continue; 
                if(node.k>=k)continue; 
                if(visited[node.k+1][ny][nx]==1)continue; 
                q.add(new Node (ny, nx, node.k+1, node.s+dir.get(i))); 
                visited[node.k+1][ny][nx] = 1; 
            }
        }
        return "impossible"; 
    }
    
    static class Node {
        int y; 
        int x; 
        int k; 
        String s; 
        
        public Node (int y, int x, int k, String s){
            this.y = y; 
            this.x = x; 
            this.k = k; 
            this.s = s; 
        }
    }
}