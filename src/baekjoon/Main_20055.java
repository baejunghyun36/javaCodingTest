package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_20055 {

	static int [] belt; 
	static int [] robot; 
	static int N, K, start, finish; 
	static int zeroCount; 
	static int cnt; 

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		N = Integer.parseInt(st.nextToken()); 
		K = Integer.parseInt(st.nextToken()); 
		st = new StringTokenizer(br.readLine()); 

		belt = new int [2*N]; 
		robot = new int [N]; 
		
		for(int i=0; i<N*2; i++) {
			belt[i] = Integer.parseInt(st.nextToken()); 
		}
		
		while(++cnt>0) {
			
			//System.out.println(Arrays.toString(belt));
		

			/* 1. 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.  */ 
			rotate(); 
			
	        /* 2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다.
			-> 로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.*/			
			move(); 
			
			/* 3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다. */
			addRobot(); 
			
			/* 4. 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.*/
			if(zeroCount>=K) break; 
			


		}
		
		System.out.println(cnt);
		br.close();

	}
	
	static void addRobot() {
	
		if(belt[0]> 0) {
			belt[0] --; 
			robot[0] = 1; 
			if(belt[0]==0)zeroCount++; 
		}
	}

	static void move() {		
		
		for(int i=N-1; i>0; i--) {
			if(belt[i]>0&&robot[i]==0&&robot[i-1]==1) {
				belt[i]--; 
				robot[i] = robot[i-1]; 
				robot[i-1] = 0; 
				if(belt[i]==0)zeroCount++; 
			}
		}
		if(robot[N-1]==1) robot[N-1] = 0; 
	}
	
	static void rotate() {
		
		int temp = belt[2*N-1]; 
		for(int i=2*N-1; i>0; i--) belt[i] = belt[i-1]; 
		belt[0] = temp; 

		for(int i=N-1; i>0; i--)robot[i] = robot[i-1]; 
		robot[0] = 0; 
	
		if(robot[N-1]==1) robot[N-1] = 0; 
		
	
	}
}
