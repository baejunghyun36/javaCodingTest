package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer; 



public class Main_1030 {
	
	    static int s,N,K,R1,R2,C1,C2,sSize;    
	    static char[][] arr= new char[51][51];
	    
	    public static void main(String[] args) throws IOException {
	      
	    	
	    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
    	    StringBuilder sb = new StringBuilder();
	    	StringTokenizer st = new StringTokenizer(br.readLine());
	    	

	    	
	        s = Integer.parseInt(st.nextToken()); // 시간
	        N = Integer.parseInt(st.nextToken()); // 자르는 개수 
	        K = Integer.parseInt(st.nextToken()); // 가운데 KxK
	        R1 = Integer.parseInt(st.nextToken());
	        R2 = Integer.parseInt(st.nextToken());
	        C1 = Integer.parseInt(st.nextToken());
	        C2 = Integer.parseInt(st.nextToken());

	       
	        divide(0,0,(int)Math.pow(N,s),false); // 0, 0 , N^s 매개변수 전달   
	  
	        for(int i=0; i<=R2-R1; i++){
	            for(int j=0; j<=C2-C1; j++){
	                sb.append(arr[i][j]);
	            }
	            sb.append("\n");
	        }
	        
	        bw.write(sb.toString());
	        bw.flush();
	        bw.close();
	        br.close(); 
	    }
	    
	    static void divide(int x, int y, int size, boolean isBlack){
	        if(x > C2 || x+size <= C1|| y > R2 || y+size <= R1) return;
	        if(size==1){
	            arr[y-R1][x-C1] = isBlack? '1': '0'; // 블랙이면 1을 넣고 블랙이 아니면 0 을 넣어 
	            return;
	        }
	        int nSize = size/N; // 분할 사이즈 
	        int blackStart = (N-K)/2; // 블랙은 
	        int blackEnd = N-blackStart;
	        for(int i=0; i<N; i++){
	            int nY = y+nSize*i;
	            for(int j=0; j<N; j++){
	                int nX = x+nSize*j;
	                
	                divide(nX,nY,nSize, isBlack || (i >= blackStart && i < blackEnd) && (j >= blackStart && j < blackEnd));
	            }
	        }
	    }
}
