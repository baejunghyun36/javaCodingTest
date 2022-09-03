package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution_3234{
 
//  static int n; 
//  static int [] info; 
//  static int [] visited; 
    static int result;  
    public static void main(String[] args) throws IOException {
         
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        StringBuffer sb = new StringBuffer(); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        int testCase = Integer.parseInt(st.nextToken()); 
        for(int t = 1; t<=testCase; t++) {
             
            st = new StringTokenizer(br.readLine()); 
            int n = Integer.parseInt(st.nextToken()); 
            int []info = new int [n]; 
            int []visited = new int[n]; 
            result =0; 
             
            st = new StringTokenizer(br.readLine()); 
            for(int i=0; i<n; i++) {
                info[i] = Integer.parseInt(st.nextToken()); 
            }
            Arrays.sort(info);
            dfs(0, 0, 0, n, info, visited); 
            sb.append("#").append(t).append(" ").append(result).append("\n"); 
        }
        System.out.println(sb.toString());
    }
     
    static void dfs(int level, int leftSum, int rightSum, int n, int []info, int []visited) {
         
         
        if(level==n) {
            result++; 
            return; 
        }
         
        for(int i=0; i<n; i++) {
             
            if(visited[i]==1)continue; 
            if(leftSum==0) {
                visited[i]=1; 
                dfs(level+1, leftSum+info[i], rightSum, n, info, visited);
                visited[i]=0; 
            }
            else {
                visited[i]=1; 
                dfs(level+1, leftSum+info[i], rightSum, n, info, visited); 
                visited[i]=0; 
                if(leftSum>=rightSum+info[i]) {
                    visited[i]=1;
                    dfs(level+1, leftSum, rightSum+info[i], n, info, visited); 
                    visited[i]=0; 
                }
            }       
        }
    }
 
}