package gitRepository;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_디스크컨트롤러 {

	public static void main(String[] args) {
		
		int [][] jobs = new int [][] {{1,2}, {2,3},{2,1}, {3,4}};
		
		Arrays.sort(jobs, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {			
				
				if(o1[0]==o2[0]) {
					return o1[1] - o2[1];  
				}
				return o1[0] - o2[0]; 
	
			}
		});
	
		
		for(int i=0; i<jobs.length; i++) {
			System.out.println(jobs[i][0]+" "+jobs[i][1]);
		}
		
		

	}

}
