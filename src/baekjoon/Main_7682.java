package baekjoon;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_7682 {

	static final String fail = "invalid\n"; 
	static final String success = "valid\n"; 
	static String s; 
	static char [][] map; 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 
		
		int count = 0; 
		while(true) {
			count++; 
			String s = br.readLine(); 
			if(s.equals("end"))break; 
			int xCnt = 0; 
			int oCnt = 0; 
			char [] temp = s.toCharArray();
			char [][] map = new char[3][3]; 
			for(int i=0; i<9; i++) {
				if(temp[i]=='X')xCnt++; 
				else if(temp[i]=='O')oCnt++; 
			}
				
			if(xCnt-oCnt>1||oCnt-xCnt>=1)sb.append(fail); 
			else if(xCnt==5&&oCnt==4)sb.append(success); 
			else {
				boolean flag = false; 
				char c = ' '; 
				
				out:for(int i=0; i<9; i++) {		
					map[i/3][i%3] = temp[i]; 
					if(temp[i]=='.')continue; 
					if(i%3==2) {
						//가로
						if(map[i/3][0]==temp[i]&&map[i/3][1]==temp[i]) {
							if(flag) {
								flag = false; 
								break out; 
							}
							flag = true; 
							c = temp[i]; 
							map[i/3][0]=map[i/3][1] ='.'; 
						}
					}
					if(i/3==2) {
						//세로
						if(map[0][i%3]==temp[i]&&map[1][i%3]==temp[i]) {
							if(flag) {
								flag = false; 
								break out; 
							}
							flag = true; 
							c = temp[i]; 
							map[0][i%3]= map[1][i%3] = '.'; 
						}
					}
					if(i==6) {
						if(map[0][2]==temp[i]&&map[1][1]==temp[i]) {
							if(flag) {
								flag = false; 
								break out; 
							}					
							flag = true; 
							c = temp[i]; 
						}
					}
					if(i==8) {
						if(map[0][0]==temp[i]&&map[1][1]==temp[i]) {
							if(flag) {
								flag = false; 
								break out; 
							}
							flag = true;
							c = temp[i]; 
						}
					}
					
				}
				if(flag==false) {
					   sb.append(fail); 
				}
				else if(flag==true) {
			
					if(c=='X') {
						if(xCnt!=oCnt+1) {
							sb.append(fail); 
							continue; 
						}
					}
					else if(c=='O') {
						if(xCnt!=oCnt) {
							sb.append(fail); 
							continue; 
						}
					}
					sb.append(success); 
				}									
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}
	static void backTracking() {
		
		
		
		for(int i=0; i<9; i++) {
			
			
			
			
		}
		
		
		
		
		
	}
	
	
	

}
