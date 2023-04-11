import java.util.*; 
class Solution {
    static long x=1; 
    static ArrayList<Integer> list; 
    static int n; 
    static int[] visited; 
    static boolean flag; 
    public int[] solution(int nn, long k) {
        int[] answer = {};
        list = new ArrayList<>(); 
        n = nn; 
        visited = new int[nn+1]; 
        for(int i=1; i<=n; i++)x*=i;
        cut(1, x, n, k); 

        answer = new int[nn]; 
        for(int i=0; i<n; i++){
            answer[i] = list.get(i); 
        }
        return answer;
    }
    
    static void cut (long start, long end, int level, long k){
        
        
        if(level==0){

            return;
        }

        long offset = (end -start+1)/level; 
        
        int cnt = 1; 
        
        for(int i = 1; i<=n; i++){
            if(visited[i]==1)continue; 
            long x = start+(cnt-1)*offset;
            long y = start + cnt*offset-1; 
            if(x<=k&&k<=y){
               
                list.add(i); 
                visited[i] = 1; 
                cut(x, y, level-1, k); 
            }
            cnt++;             
        }
    }
    
    
    

}