package gitRepository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_9527 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader (new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		long start = Long.parseLong(st.nextToken()); 
		long end = Long.parseLong(st.nextToken()); 
		int answer = 0; 
		for(long i=start; i<=end; i++) {
			answer+=Long.bitCount(i); 
		}
		sb.append(answer); 
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
