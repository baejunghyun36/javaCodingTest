package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_2632 {
	static int reqSize; 
	static int pizzaA, pizzaB;
	static LinkedList<Integer> listA; 
	static LinkedList<Integer> listB; 
	static int [] aInfo;
	static int [] bInfo; 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st = null; 
		
		reqSize = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine()); 
		
		pizzaA = Integer.parseInt(st.nextToken()); 
		pizzaB = Integer.parseInt(st.nextToken()); 
		
		listA = new LinkedList<>(); 
		listB = new LinkedList<>(); 
		
		aInfo = new int [1000001]; 
		bInfo = new int [1000001]; 
		
		
		
		int sumA = 0;
		int sumB = 0; 
		int num = 0 ; 
		for(int i=0; i<pizzaA; i++) {
			num = Integer.parseInt(br.readLine()); 
			sumA+=num; 
			listA.add(num); 
			
		}		
		for(int i=0; i<pizzaB; i++) {
			num = Integer.parseInt(br.readLine()); 
			sumB+=num; 
			listB.add(num); 
		}		
		bInfo[0] = aInfo[0] = 1; 
		aInfo[sumA] = 1; 
		bInfo[sumB] = 1; 
		
		fillA(); 
		fillB(); 
		
		int answer = 0; 
		
		for(int i=0; i<=reqSize; i++) {
			//0~7까지 
			answer+= aInfo[i] * bInfo[reqSize-i]; 
		}
		
		sb.append(answer); 
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}
	
	static void fillA() {
		for(int i=0; i<pizzaA; i++) {
			int sum = 0; 
			for(int j=0; j<pizzaA-1; j++) {
				sum+=listA.get(j); 
				aInfo[sum]++; 
			}
			int x = listA.remove(0); 
			listA.add(x); 			
		}
	}
	
	static void fillB() {
		for(int i=0; i<pizzaB; i++) {
			int sum = 0; 
			for(int j=0; j<pizzaB-1; j++) {
				sum+=listB.get(j); 
				bInfo[sum]++; 
			}
			int x = listB.remove(0); 
			listB.add(x); 			
		}
	}

	
}
