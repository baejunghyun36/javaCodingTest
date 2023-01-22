package gitRepository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10836 {

	
	static int M, N; 
	static int [][] map; 
	static int [] grow; 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		StringBuilder sb = new StringBuilder(); 
		M = Integer.parseInt(st.nextToken()); 
		N = Integer.parseInt(st.nextToken()); 
		map = new int[M][M]; 
		grow = new int [M*2]; 
		
		for(int i=0; i<M; i++) {
			Arrays.fill(map[i],  1);
		}
		Arrays.fill(grow, 1);
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()); 
			int zero = Integer.parseInt(st.nextToken());
			int one = Integer.parseInt(st.nextToken()); 
			int two = Integer.parseInt(st.nextToken()); 
			for(int j=zero; j<zero+one; j++) {
				grow[j]++; 
			}
			for(int j=zero+one; j<2*M; j++) {
				grow[j]+=2; 
			}
		}
		int index = M-1;
		boolean flag = false; 
		for(int i=0; i<2*M-1; i++) {
			if(flag==false) {
				map[index][0] = grow[i]; 
				index--; 
				if(index==0)flag=true; 
			}
			else {
				map[0][index] = grow[i]; 
				index++; 
			}
		}
		for(int i=1; i<M; i++) {
			for(int j=1; j<M; j++) {
				map[i][j] = map[i-1][j]; 
			}
		}
		for(int i=0; i<M; i++) {
			for(int j=0; j<M; j++) {
				sb.append(map[i][j]).append(" "); 
			}
			sb.append("\n"); 
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
