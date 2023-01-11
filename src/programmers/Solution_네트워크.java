package gitRepository;

class Solution_네트워크 {
    
    static int [] visited; 
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new int[n+1]; 
        for(int i=0; i<computers.length; i++){
            
            for(int j=0; j<computers[i].length; j++ ){

                if(visited[i]==0){
                    answer++; 
                    dfs(computers, i); 
                }
            }
        }
        
        return answer;
    }

    static void dfs(int [][] computers, int a){
        visited[a]=1; 
        for(int i=0; i<computers.length; i++){
            if(computers[a][i]==1&&visited[i]==0){               
                visited[i]=1; 
                dfs(computers, i);
            }
        }
    }

}