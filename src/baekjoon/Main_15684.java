package baekjoon;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15684 {

    static int M, N; 
    static int [][] map; 
    static int possibleRow; 
    static ArrayList <int []> list; 
    static int answer; 
    static boolean flag; 
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        StringBuilder sb = new StringBuilder(); 
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); 
        int fixRow = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken()); 
        map = new int[M+1][N+1]; 
        possibleRow = (N-1)*M-fixRow;
        for(int i=0; i<fixRow; i++) {
            st = new StringTokenizer(br.readLine()); 
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken()); 
            map[y][x] = 1; 
        }
        
        list = new ArrayList<>(); 
        for(int i=1; i<=M; i++) {
            for(int j=1; j<=N; j++) {
                if(map[i][j]==0)list.add(new int[] {i,j}); 
            }
        }        
        for(int i=0; i<=list.size(); i++) comb(0, i, 0, new int [i]); 
        
        sb.append(answer); 
        
        bw.write(sb.toString()); 
        bw.flush();
        bw.close();
        br.close();
    }
    
    
    static boolean ladderStart() {
      
        for(int i=1; i<=N; i++) {
            int y = 1; 
            int x = i; 
            
            while(y!=M) {
                
                if(map[y][x]==1) x++; 
                if(map[y][x-1]==1)x--; 	
                y++;          
         
            }
            
            if(x!=i)return false; 
            
        }
        return true;
        
    }
    
    static void init(int [] order, int size) {
        for(int i=0; i<size; i++ ) {            
            int y = list.get(order[i])[1]; 
            int x = list.get(order[i])[0]; 
            map[y][x] = 0; 
        }
    }
    
    
    static void check(int [] order, int size) {
        
        for(int i=0; i<size; i++ ) {            
            int y = list.get(order[i])[1]; 
            int x = list.get(order[i])[0]; 
            map[y][x] = 1; 
        }
        for(int i=0; i<M; i++) {
        	for(int j=0; j<N-1; j++) {
        		if(map[i][j]==1&&map[i][j+1]==1) {
        			init(order, size); 
        			return; 
        		}
        	}
        }
        if(ladderStart()) {
        	flag=true;
        };    
   
        init(order, size); 
    }
    
    static void comb(int start, int level, int cnt, int [] order) {
        
        if(cnt==level) {
            //System.out.println(Arrays.toString(order));
            check(order, cnt); 
            if(flag==true) {
            	answer = level; 
            	return; 
            }
          
            return; 
        }
        if(cnt==list.size())return; 
        
        for(int i=start; i<list.size(); i++    ) {
            order[cnt] = i; 
            if(!flag)comb(i, level, cnt+1, order);                    
        }
    }

}