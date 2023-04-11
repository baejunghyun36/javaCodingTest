import java.util.*; 
class Solution {
    static int [] visited; 
    static Queue<Integer> q; 
    static int y; 
    public int solution(int x, int y1, int n) {
        int answer = 0;
        q = new LinkedList<>(); 
        visited = new int[1000001]; 
        y = y1; 
        
        if(x==y)answer = 0; 
        else{
            
        q.add(x); 
        visited[x] = 1; 
            answer = bfs(n); 
        }
  
        return answer;
    }
    
    static int bfs(int n){
        int cnt = 0; 
        while(!q.isEmpty()){
            int size = q.size(); 
            cnt++; 
            while(size-->0){
                int x =  q.poll(); 
                int n1 = x+n; 
                int n2 = x*2; 
                int n3 = x*3; 
                if(n1==y||n2==y||n3==y)return cnt;  
                if(n1<=y&&visited[n1]==0){q.add(n1);visited[n1] = 1;}
                if(n2<=y&&visited[n2]==0){q.add(n2);visited[n2] = 1;} 
                if(n3<=y&&visited[n3]==0){q.add(n3);visited[n3] = 1;} 
            }
        }
        return -1; 
    }
}