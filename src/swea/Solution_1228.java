package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_1228 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st ; 
		
		for (int testCase = 1; testCase<=10; testCase++) {
			
			LinkedList<Integer> list = new LinkedList<>(); 

			int initNumber = Integer.parseInt(br.readLine()); // 초기 리스트 값
			st =  new StringTokenizer(br.readLine(), " "); 
			for(int i=0; i<initNumber; i++) list.add(Integer.parseInt(st.nextToken())); 
	
			int n = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine(), " "); 
			for(int i=0; i<n; i++) {
				String s = st.nextToken(); 
				int index = Integer.parseInt(st.nextToken()); 
				int subNumber = Integer.parseInt(st.nextToken()); 
				for(int j=0; j<subNumber; j++) {
					list.add(index++, Integer.parseInt(st.nextToken())); 
				}			
				
			}
			
			//StringBuilder
			sb.append("#"); 
			sb.append(testCase); 
			sb.append(" "); 
			for(int i=0; i<10; i++) {
				sb.append(list.get(i)); 
				sb.append(" "); 
			}
			sb.append("\n"); 
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close(); 
	}

}
