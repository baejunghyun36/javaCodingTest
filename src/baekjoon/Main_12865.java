package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main_12865 {

	static int N; 
	static int K; 
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); 
		N = sc.nextInt(); // itemNumber
		K = sc.nextInt(); // maxSizeOfBag
		
		ArrayList <Item> itemList = new ArrayList<>(); 
		itemList.add(new Item(0,0)); // emptyItem; 
		for(int i=0; i<N; i++) {
			int w = sc.nextInt(); 
			int v = sc.nextInt(); 
			
			itemList.add(new Item(w,v)); 
		}
		
		
		int [][] dp = new int [N+1][K+1]; 
		for(int i=0; i<=N; i++)Arrays.fill(dp[i], 0);
	
		
		for(int i=1; i<=N; i++) {
			Item item = itemList.get(i); 
			for(int j=1; j<=K; j++) {
				
				if(item.w<=j) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-item.w]+item.v); 
				}
				else {
					dp[i][j] = dp[i-1][j]; 
				}
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
	
		
		System.out.println(dp[N][K]);
	}
	
	static class Item{
		int w; //weight
		int v; //value
		
		public Item(int w, int v) {
			super();
			this.w = w;
			this.v = v;
		} 
		
		
	}

}
