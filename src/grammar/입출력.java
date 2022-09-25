package grammar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 입출력 {

	public static void main(String[] args) throws IOException {
	
		System.setIn(new FileInputStream("input.txt"));
		
		StringBuilder sb = new StringBuilder(); 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
	
		
		
		
		
		bw.write(sb.toString()); 
		bw.flush();
		br.close();
		br.close();	
		
	}

}
