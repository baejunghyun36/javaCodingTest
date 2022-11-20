package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_14499 {

    static int M,N; 
    static int Y,X;  
    static int [][] map; 
    static int n; 
    static LinkedList <Integer> width, length; //가로 , 세로
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringBuilder sb = new StringBuilder(); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        
        M = Integer.parseInt(st.nextToken()); 
        N = Integer.parseInt(st.nextToken()); 
        Y = Integer.parseInt(st.nextToken()); 
        X = Integer.parseInt(st.nextToken()); 
        n = Integer.parseInt(st.nextToken()); 
        
        map = new int[M][N]; 
        
        width = new LinkedList<>(); 
        length = new LinkedList<>(); 
        
        for(int i=0; i<4; i++) {
            width.add(0);
            length.add(0); 
        }
        
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine()); 
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }
        
        st = new StringTokenizer(br.readLine()); 
        while(n-->0) {
            //동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4
            int dir = Integer.parseInt(st.nextToken()); 
            if(dir==1&&X+1>=N)continue; 
            else if(dir==2&&X-1<0)continue; 
            else if(dir==3&&Y-1<0)continue; 
            else if(dir==4&&Y+1>=M)continue; 
            if(dir==1) {
                int x = width.remove(3); 
                width.add(0, x);
                X++; 
                check(1); 
            }
            else if(dir==2) {
                int x = width.remove(0); 
                width.add(x);                 
                X--; 
                check(1);     
            }
            else if(dir==3) {
                int x = length.remove(0); 
                length.add(x); 
                Y--; 
                check(2);     
            }
            else {
                int x = length.remove(3); 
                length.add(0,x); 
                Y++; 
                check(2);
            }
            
            if(map[Y][X]!=0) {
                width.set(2, map[Y][X]); 
                length.set(2, map[Y][X]); 
                map[Y][X] =0; 
            }
            else map[Y][X] = width.get(2); 
            sb.append(length.get(0)).append("\n"); 
        }
        
        System.out.println(sb.toString());
    }

    static void check(int select) {
        if(select==1) {
            length.set(0, width.get(0)); 
            length.set(2, width.get(2)); 
        }
        else {
            width.set(0, length.get(0)); 
            width.set(2, length.get(2)); 
        }        
    }
}