package programmers;

import java.util.Arrays;

public class Solution_불량사용자 {

	static String[]	userId; 
	static String[] bannedId; 
	static int cnt; 
	static int [] visited;
	static int n; 
	static int []overlap; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		userId = new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}; 
		bannedId = new String[] {"fr*d*", "abc1**"}; 
		cnt = 0; 
		n = bannedId.length; 
		overlap = new int [1<<8]; 
		visited = new int [userId.length]; 
		backTracking(0, 0 ); 
		System.out.println(cnt);
	}
	static void backTracking(int level, int bit) {
		
		if(level == n) {
			if(overlap[bit]==0) {
				overlap[bit] = 1; 
				cnt++; 
				
			}	
			return ; 
		}
		
		int [][] x = new int[5][5]; 
		for(int i=0; i<4; i++)Arrays.fill(x[i], 1);
		
		
		String bId = bannedId[level]; 
		
		for(int i=0; i<userId.length; i++) {
			
			if(visited[i]==1)continue; 
			String uId = userId[i]; 
			boolean flag = true; 
			for(int j=0; j<bId.length(); j++) {
				char c = bId.charAt(j); 
				if(c=='*')continue; 
				if(uId.length()<=j||c!=uId.charAt(j)) {
					flag = false; 
					break; 
				}
			}
			if(flag==true&&uId.length()==bId.length()) {
				visited[i] = 1; 
				System.out.print(uId+" ");
				backTracking(level+1, bit|(1<<i)); 
				visited[i] = 0; 
			}
		}
	}
}
