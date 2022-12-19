package programmers;

import java.util.*; 
class Solution_합승택시요금 {
    static final int INF = 987654321; 
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = INF; 
        int dist[][] = new int[n+1][n+1]; 
        for(int i=0; i<=n; i++)Arrays.fill(dist[i], INF); 
        for(int i=0; i<fares.length; i++){
            for(int j=0; j<fares[i].length; j++){
                int c = fares[i][0]; 
                int d = fares[i][1]; 
                int f = fares[i][2]; 
                dist[d][c]=dist[c][d]=f; 
            }
        }
        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(i==j) dist[i][j]=0; 
                    dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]); 
                }
            }
        }
        
        for(int i=1; i<=n; i++){
            if(dist[s][i]!=INF&&dist[i][a]!=INF&&dist[i][b]!=INF){
                answer = Math.min(answer, dist[s][i]+dist[i][a]+dist[i][b]); 
            }
        }
        
        
        
        return answer;
    }
}