package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_J_1828 {

	public static void main(String[] args) {

		int n; 
		Scanner sc = new Scanner(System.in); 
		
		n = sc.nextInt(); 
		
		Temp []temp = new Temp[n]; 
		
		for(int i=0; i<n; i++) temp[i] = new Temp(sc.nextInt(), sc.nextInt()); 
	
		Arrays.sort(temp);
		
		int endIndex = temp[0].high;		
		int refCnt = 1; 
		
		for(int i=1; i<n; i++) {
			if(temp[i].low>endIndex) {
				refCnt++; 
				endIndex = temp[i].high; 
			}
			else if(endIndex>temp[i].high) {
				endIndex= temp[i].high; 
			}
		}
		
		System.out.println(refCnt);


	}
	static class Temp implements Comparable<Temp>{
		
		int low; 
		int high;
		
		public Temp(int low, int high) {
			this.low = low;
			this.high = high;
		}
		@Override
		public int compareTo(Temp o) {
			if(this.low==o.low)return this.high-o.high; 
			return this.low-o.low; 
		} 
	}
}



