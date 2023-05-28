import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int n = sc.nextInt(); 
		int test = sc.nextInt(); 
		int [] arr = new int[n+1]; 
		for(int i=1; i<=n; i++) arr[i] = sc.nextInt(); 
		int [] dp = new int[n+1]; 
		for(int i=1; i<=n; i++) dp[i] = arr[i]+dp[i-1]; 
		for(int i=0; i<test; i++) {
			int a = sc.nextInt(); 
			int b = sc.nextInt(); 
			System.out.println(dp[b]-dp[a-1]);
		}
	}
}
