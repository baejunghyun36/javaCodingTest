package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_17825 {

	
	static int [] dice; 
	static int [][] visited; 
	static int [][] map; 
	static int [] horseOrder; 
	static ArrayList <Horse> horseList; 
	static int answer; 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		dice = new int[10]; 
		for(int i=0; i<10; i++) dice[i] = Integer.parseInt(st.nextToken());
		
		map = new int [4][20]; 
		
		for(int i=0; i<=19; i++)map[0][i] = 2*(i+1); 
		
		map[1] = new int[] {10, 13, 16, 19, 25, 30, 35, 40}; 
		map[2] = new int[] {20, 22, 24, 25, 30, 35, 40}; 
		map[3] = new int[] {30, 28, 27, 26, 25, 30, 35, 40}; 
		
		horseOrder =new int [10]; 
		horseList = new ArrayList<>(); 
		for(int i=0; i<4; i++) horseList.add(new Horse(0, -1, false)); 
		
		
		checkOrder(0); 
		System.out.println(answer);
	}
	
	static boolean lineCheck(int line, int index) {
		
		if(line == 0 && index <=19) return true; 
		if(line == 1 && index <=7) return true; 
		if(line == 2 && index <=6) return true; 
		if(line == 3 && index <=7) return true; 
		return false; 
		
	}
	
	static boolean horseCheck(int line, int index) {
		
		if(visited[line][index]==1)return false; 		
		return true; 		
		
	}
	
	static void updateVisited(int line, int index) {
		if(map[line][index]==25) visited[1][4]=visited[2][3]= visited[3][4] = 0; 
		else if(map[line][index]==30)visited[1][5] = visited[2][4]=visited[3][5] = 0; 
		else if(map[line][index]==35)visited[1][6] = visited[2][5]=visited[3][6] = 0; 
		else if(map[line][index]==40) visited[0][19]=visited[1][7]=visited[2][6]=visited[3][7] = 0 ; 
	}
	
	static void check() {
		
		int score = 0; 
		
		for(int i=0; i<10; i++) {
		
			int horseNumber = horseOrder[i]; 
			Horse horse = horseList.get(horseNumber); 
			if(horse.finish==true)return; 
			
			int line = horse.line; 
			int index = horse.index + dice[i]; 			
			
			if(!lineCheck(line, index)) {			
				updateVisited(line, horse.index); 				 
				visited[line][horse.index] = 0; 
				horse.finish = true; 
				continue; 
			}
			
			//말이 못가
			if(!horseCheck(line, index)) return; 	
			
			if(horse.index!=-1) visited[line][horse.index] = 0; 
			
			if(line==1&&horse.index==0) visited[1][0]=visited[0][4] = 0; 			
			else if (line==2 && horse.index==0)visited[2][0]=visited[0][9] = 0; 
			else if(line==3 && horse.index==0)visited[3][0]=visited[0][14] = 0; 
			
			if(horse.index!=-1)updateVisited(line, horse.index); 
			
			if(line==0&& index == 4) {
				horse.line = 1; 
				horse.index = 0; 
				visited[1][0] = visited[0][4] = 1;
			}
			else if(line==0 && index == 9) {
				horse.line = 2; 
				horse.index = 0; 
				visited[2][0] = visited[0][9] = 1; 
			}
			else if(line ==0 && index == 14) {
				horse.line = 3; 
				horse.index = 0; 
				visited[3][0] = visited[0][14]  = 1; 
			}
			else if(map[line][index]==40) {
				horse.index = index; 
				visited[0][19]=visited[1][7]=visited[2][6]=visited[3][7] = 1 ; 
			}
			else if(map[line][index]==25) {
				horse.index = index; 
				visited[1][4]=visited[2][3]= visited[3][4] = 1; 
			}
			else if(map[line][index]==30) {
				horse.index = index; 
				visited[1][5] = visited[2][4]=visited[3][5] = 1; }
			else if(map[line][index]==35) {
				horse.index = index; 
				visited[1][6] = visited[2][5]=visited[3][6] = 1; 
						}
			else {
				visited[line][index] = 1; 
				horse.index = index; 
			}
			score += map[horse.line][horse.index]; 
		}
		answer = Math.max(score, answer); 
	}
	
	
	static void checkOrder(int level) {
		
		if(level==10) {
			visited = new int[4][20]; 
			check(); 
			for(int i=0; i<4; i++) {
				horseList.get(i).finish = false; 
				horseList.get(i).index = -1; 
				horseList.get(i).line = 0; 
			}		
			return; 
		}
		
		for(int i=0; i<4; i++) {
			horseOrder[level] = i; 
			checkOrder(level+1); 
		}
	}
	

	static class Horse{

		int line; 
		int index; 
		boolean finish;
		
		public Horse(int line, int index, boolean finish) {
			super();
			this.line = line;
			this.index = index;
			this.finish = finish;
		} 
	}
}
