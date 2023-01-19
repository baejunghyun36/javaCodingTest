package gitRepository;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1977 {

	static  int M, N; 
	static int [][] map; 
	static int answer; 
	static int start;
	static int height; 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken()); 
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken()); 
		map = new int[M][N]; 
		start = M-1; 
		while(testCase-->0) {
			
			int m = Integer.parseInt(br.readLine()); 
			int [][] temp = new int[m][N]; 
 
			for(int i=0; i<m; i++) {
				String s = br.readLine(); 
				for(int j=0; j<s.length(); j++) {
					if(s.charAt(j)=='X')temp[i][j] = 1; 				
				}
			}
		
			if(!full(map, temp, m)) {
				sb.append(height).append(" "); 	
				start = M-1; 
				map = new int[M][N]; 
				full(map, temp, m); 
			}
		}
		sb.append(height); 
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}
	
	static boolean full (int [][] map, int [][] temp, int m) {
		for(int i=start; i>=m-1; i--) {
			boolean flag = true; 
			int index = m-1;
			out:for(int j=i; j>=i-m+1; j--) {
				for(int k=0; k<N; k++) {
					if(temp[index][k]==1&&map[j][k]==1) {
						flag = false; 
						break out; 
					}
				}
				index--; 
			}
			if(flag) {
				index = m-1; 
				for(int j=i; j>=i-m+1; j--) {
					for(int k=0; k<N; k++) {
						if(temp[index][k]==1) {
						  height = M-j; 
						  map[j][k] = 1; 								
						}
					}
					index--; 
				}
				start = i; 
				return true; 
			}
		}
		return false; 
	}
}
