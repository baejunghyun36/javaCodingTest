package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//분할정복
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_B_2493 {
   static int map[][];
   //static StringBuilder sb = new StringBuilder();
   public static void main(String[] args) throws Exception {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      map = new int[n][n];

      for(int i=0; i<n; i++) {
         String str = sc.next(); //새로 한 줄 입력받기
         for(int j=0; j<n; j++) {
            map[i][j] = str.charAt(j)- '0'; //map에 숫자 저장
         }
      }
      
      quad(0, 0, n); // 
   
   }
   
   private static void quad(int x, int y, int n) {
      
      if(n==1) {
         System.out.print(map[x][y]);
         return; 
      }
      
      int checkzero=0; 
      int checkone=0; 
      for(int i=x; i<x+n; i++) {
         for(int j=y; j<y+n; j++) {
            if(map[i][j]==0)checkzero=1; 
            if(map[i][j]==1)checkone=1; 
         }
      }
      
      if(checkzero==1&&checkone==0) {
         System.out.print(0);
         return; 
      }
      if(checkzero==0&&checkone==1) {
         System.out.print(1);
         return; 
      }
      
      n/=2; 
      
      System.out.print("(");
      quad(x,y,n); 
      quad(x,y+n, n); 
      quad(x+n,y,n); 
      quad(x+n, y+n, n); 
      System.out.print(")");
      
      
      
   }
      
}