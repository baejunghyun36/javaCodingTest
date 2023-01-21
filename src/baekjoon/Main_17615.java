package gitRepository;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_17615 {

	static int N; 
	static int answer = 987654321; 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st = null; 
		N = Integer.parseInt(br.readLine()); 
		 
		
		char [] s1 = br.readLine().toCharArray(); 
		char [] s2 = new char[s1.length]; 
		for(int i=0; i<s2.length; i++) s2[i] = s1[s2.length-1-i]; 
		
		
		int a = check(s1); 
		int b = check(s2); 
		
		
		sb.append(Math.min(a, b)); 
		
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}

	static int check (char [] s) {
		
		int rcnt =0; 
		int bcnt = 0; 
		int indexR = s.length-1;  
		int indexB = s.length-1;  		
		while(indexR>=0&&s[indexR]=='R')indexR--; 
		while(indexB>=0&&s[indexB]=='B')indexB--; 		
		for(int i=indexR; i>=0; i--)if(s[i]=='R')rcnt++; 		
		for(int i=indexB; i>=0; i--)if(s[i]=='B')bcnt++; 
		return Math.min(rcnt, bcnt);
		
	}
}
