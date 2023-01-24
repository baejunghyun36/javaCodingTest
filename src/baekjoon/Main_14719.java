package gitRepository;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14719 {

	static int M,N; 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken()); 
		N = Integer.parseInt(st.nextToken()); 
		
		int [][] map = new int[M][N]; 
		st = new StringTokenizer(br.readLine()); 
		
		for(int i=0; i<N; i++) {
			int h = Integer.parseInt(st.nextToken()); 
			for(int j=0; j<h; j++) {
				map[j][i] = 1; 
			}		
		}
		int cnt = 0; 
		for(int i=0; i<M; i++) {
			int start = -1; 
			for(int j=0; j<N; j++) {
				if(map[i][j]==1) {
					if(start == -1) start = j; 
					else if(start!=-1) {
						for(int k=start+1; k<j; k++) {							
							cnt++; 
						}			
						start = j; 
					}
				}
			}
		}
		
		sb.append(cnt);
		
	
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}

}
