package sw_ability_test;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_5215_햄버거다이어트 {

	static int TC,N,MaxCal;
	static int[][] Arr;
	static int[][] dp;
    static int max;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input/5215.txt"));
		Scanner sc = new Scanner(System.in);
		
		TC = sc.nextInt();
        for(int t=1;t<=TC;t++) {
        	
        	N = sc.nextInt();       // 재료수
        	MaxCal = sc.nextInt();  // 제한 칼로리
        	
    		Arr = new int[N+1][2];
    		dp = new int[N+1][MaxCal+1];
        	
    		for(int i=1; i< Arr.length ;i++) {
    			Arr[i][0] = sc.nextInt(); //  V
    			Arr[i][1] = sc.nextInt(); //  W
    		}
			
    		for (int i = 1; i <= N; i++) {
    			for (int w = 1; w <= MaxCal; w++) {
    				if(Arr[i][1] < w ){	
    					dp[i][w] = Math.max(dp[i-1][w], Arr[i][0]+dp[i-1][w-Arr[i][1]]);
    				}else{
    					dp[i][w] =  dp[i-1][w];
    				}
    			}
    		}
        	System.out.printf("#%d %d%n",t,dp[N][MaxCal]);
        }
	}

	private static void f(int now ,int score , int sum) { 
		if(sum > MaxCal) {return;}
		
		if(now == N) {
		    max = Math.max(max, score);
			return;
		}
		// 원소 선택
		f(now+1 , score+Arr[now][0],sum+Arr[now][1]);

		// 원소 미선택
		f(now+1,score,sum );
	}
	
	private static int f_bit() {
		int maxP = 0;
		for (int i = 0; i < (1 << N); i++) {  //부분집합의 갯수 2^N
			int sumP = 0;
			int sumC = 0;
			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) > 0) { //i 선택여부 확인 
					int tempCal = sumC + Arr[j][1];
					int tempSum = sumP + Arr[j][0];
					if (tempCal > MaxCal) {
						break;
					} else {
						sumP = tempSum;
						sumC = tempCal;
					}
				}
			}
			if (maxP < sumP) {
				maxP = sumP;
			}
		}
		return maxP;
	}
	
}
/*
1
5 1000
100 200
300 500
250 300
500 1000
400 400

 */
