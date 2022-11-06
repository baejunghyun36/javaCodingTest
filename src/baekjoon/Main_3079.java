package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3079{

	static int N, M; 
	static int highNumber; 
	
	static int [] passport; 
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken()); 
		
		passport = new int[N]; 
		
		for(int i=0; i<N; i++) {
			int x = Integer.parseInt(br.readLine()); 
			passport[i] = x; 
			highNumber = Math.max(highNumber, passport[i]); 
		}
		
		long answer = binarySearch(); 
		System.out.println(answer);
	}
	
	static long binarySearch() {
		long low = 0; 
		long high = highNumber*(long)M; 
		long answer =  high; 
		while(low<=high) {
			
			long mid = (low+high)/2; 
			
			if(check(mid)) {
				high = mid-1; 
				answer = mid; 
			}
			else {
				low = mid+1; 
			}
		}
		return answer; 
	}

	static boolean check(long mid) {
		
		long sum = 0; 
		for(int i=0; i<N; i++) {
			sum+=(mid/passport[i]); 
            if(sum>=M)return true;
		}
		 
		return false; 
	}
}
