package swea.d2;
import java.util.*;

//1959. 두 개의 숫자열
class Solution_1959 {

	public static void main(String args[]) throws Exception{
		
		
		Scanner sc = new Scanner(System.in); 
		int T; 
		T = sc.nextInt(); 
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n, m;  
			n = sc.nextInt(); 
			m = sc.nextInt(); 
			int a[] = new int[n]; 
			int b[] = new int[m]; 
			for(int i=0; i<n; i++)a[i] = sc.nextInt(); 
			for(int i=0; i<m; i++)b[i] = sc.nextInt(); 
			int sum, max = 0; 
			for(int k=0; k<n-m+1; k++) {
				sum=0; 
				for(int i=0; i<m; i++)sum+=a[i+k]*b[i]; 
				if(sum>max)max = sum; 
			}
			
			for(int k=0; k<m-n+1; k++) {
				sum=0; 
				for(int i=0; i<n; i++)sum+=a[i]*b[i+k]; 
				if(sum>max)max = sum; 
			}
			System.out.format("#%d %d\n", test_case, max); 
		}
	}
}