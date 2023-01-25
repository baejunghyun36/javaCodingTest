package gitRepository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2110 {

	
	static int n, m; 
	static int [] info ;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		n = Integer.parseInt(st.nextToken()); 
		m = Integer.parseInt(st.nextToken()); 
		info = new int[n]; 
		for(int i=0; i<n; i++) {
			info[i] = Integer.parseInt(br.readLine()); 
		}
		Arrays.sort(info);
		
		int l = 0; 
		int h = 1000000000; 
		
		int answer = 0; 
		while(l<=h) {
			int mid = (l+h)/2; 
			if(check(mid)) {
				answer = mid; 
				l = mid +1; 
			}
			else {
				
				h = mid-1; 
			}
		}
		sb.append(answer); 
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	}
	static boolean check(int mid) {
		//공유기 거리 = mid 
		int start = info[0];
		int cnt = 1; 
	
		for(int i=1; i<n; i++) {
			if(info[i]>=start+mid) {
				start = info[i]; 
				cnt++; 
			}
		}	
		//System.out.println(mid+" 일 때 공유기 수 : "+ cnt);
		if(cnt>=m) return true; //거리 늘려 
		else return false; // 거리 줄여 
	}
}
