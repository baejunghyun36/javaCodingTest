package programmers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_14510 {

	static ArrayList <Tree> treeList; 
	static int testCase; 
	static int N; 
	static int result; 
	static int maxTree; 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st = null; 
		
		testCase = Integer.parseInt(br.readLine()); 
		for(int t = 1; t<=testCase; t++) {
			result = 0; 
			
			N = Integer.parseInt(br.readLine()); 
			treeList = new ArrayList<>(); 
			st = new StringTokenizer(br.readLine()); 
			for(int i=0; i<N; i++) {
				treeList.add(new Tree(Integer.parseInt(st.nextToken()))); 
			}
			Collections.sort(treeList);
		
			maxTree = treeList.get(N-1).h; 
			result = check(); 
			
			sb.append("#").append(t).append(" ").append(result).append("\n"); 
		}
		bw.write(sb.toString()); 
		bw.flush();
		bw.close();
		br.close(); 
	}
	static int check() {
		
		int day = 0 ; 
		int index = N-2; 
		
		while(true) {
			while(index>=0 && treeList.get(index).h==maxTree)index--; 
			if(index==-1)break; 
			
			day++; 
			Tree tree = treeList.get(index);
			
			if(day%2==1) { 						
				if(index==0&&tree.h+1==maxTree-1)continue; 
				else if(tree.h+1==maxTree) index--;				
				else tree.h+=1; 				
			}
			else {			
				if(tree.h+2==maxTree) index--;				 
				else if(tree.h+2<maxTree)tree.h+=2; 				
				else if(tree.h+2>maxTree) {
				  int k = index; 
				  while(k>=0&&treeList.get(k).h+2>maxTree)k--; 				
				  if(k!=-1) treeList.get(k).h+=2; 				  
				}
			}
		}	
		return day; 		
	}
	static class Tree implements Comparable<Tree>{
		
		int h;

		public Tree(int h) {
			super();
			this.h = h;
		} 
		
		public int compareTo(Tree o) {			
			return this.h - o.h; 
		}
		
	}
}
