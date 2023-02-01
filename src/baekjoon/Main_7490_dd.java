package gitRepository;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_7490_dd {

	static int level; 
	
	static StringBuilder answer; 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st = null; 
		answer = new StringBuilder(); 
		int n = Integer.parseInt(br.readLine());
		for(int t = 1; t<=n; t++) {
			
			int number = Integer.parseInt(br.readLine()); 
			
			level = number; 
			dfs(2,"1"); 
			
			answer.append("\n"); 
		}
		
		
		bw.write(answer.toString());
		bw.flush();
		bw.close();
		br.close();

	}

	static void dfs(int index, String s) {
		
		
		if(index==level+1) {
			
			String temp = s.replaceAll(" ", ""); 
			ArrayList<Character> op = new ArrayList<>(); 
			for(int i=0; i<temp.length(); i++) {
				if(temp.charAt(i)=='+'||temp.charAt(i)=='-') {
					op.add(temp.charAt(i)); 
				}
			}
			String[] num = temp.split("\\+\\-"); 
			System.out.println(num[0]);
			int sum = Integer.parseInt(num[0]); 
			for(int i=0; i<op.size(); i++) {
				if(op.get(i)=='+') {
					sum+=Integer.parseInt(num[i+1]); 
				}
				else {
					sum-=Integer.parseInt(num[i+1]); 
				}
			
			}
			if(sum==0)answer.append(s); 
		
			return; 
		}
		dfs(index+1, s+' '+index); 
		dfs(index+1, s+'+'+index); 
		dfs(index+1, s+'-'+index ); 
	
		
		
		
	}
}
