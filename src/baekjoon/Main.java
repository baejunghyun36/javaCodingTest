package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static int N, K, W, V; 
	static int [][] dp; 
	static int [][] items; 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//N 개수 
		//K 버틸 수 있는 무게 
		//W 무게 
		//V 가치 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		N = Integer.parseInt(st.nextToken()); 
		K = Integer.parseInt(st.nextToken()); 
		
	
		dp = new int [N+1][K+1]; 
		items = new int [N+1][K+1]; 
		
		ArrayList <Item> itemList = new ArrayList<>(); 
		itemList.add(new Item(0,0)); 
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine()); 
			items[i][0] = Integer.parseInt(st.nextToken()); 
			items[i][1] = Integer.parseInt(st.nextToken()); 
			itemList.add(new Item(items[i][0], items[i][1])); 
		}
		//Collections.sort(itemList);
		for(int i=1; i<=N; i++) {
			Item item = itemList.get(i); 
			for(int j=1; j<=K; j++) {
				
				if(item.w>j) dp[i][j] = dp[i-1][j]; 
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-item.w]+item.v); 
				}
			}
		}
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=K; j++) {
				System.out.print(dp[i][j]+" ");
			}System.out.println();
		}
		
		System.out.println(dp[N][K]);
		
	}

	static class Item implements Comparable <Item>{
		
		int w; 
		int v;
		public Item(int w, int v) {
			super();
			this.w = w;
			this.v = v;
		}
		@Override
		public int compareTo(Item o) {
			// TODO Auto-generated method stub
			if(this.w == o.w)return this.v - o.v; 
			return this.w - o.w; 
		} 
		
		
		
		
	}
}
