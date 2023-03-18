package programmers;
import java.util.*;

class Solution_표현가능한이진트리 {
	static int ans = 0;
	static boolean check;
	public int[] solution(long[] numbers) {
		int[] answer = new int[numbers.length];

		for(int i=0; i<numbers.length; i++){
			long number = numbers[i];
			String bit = Long.toBinaryString(number);

			out:for(int j=0; j<=(bit.length()-1)/2; j++){
				String temp ="";
				for(int k=0; k<(bit.length()-1-2*j); k++){
					temp+="0";
				}
				temp+=bit;
				int n = 1;
				boolean flag = false;
				while(Math.pow(2,n)-1<=temp.length()){
					if(Math.pow(2,n++)-1==temp.length()){
						flag = true;
						break;
					}
				}
				if(flag==true){
					int root = temp.length()/2;
					if(temp.charAt(root)=='1'){
						check = true;
						dfs(root, temp, 0, temp.length()-1, false);
						if(check==true){
							answer[i] = 1;
							break out;
						}
					}
				}
			}
		}
		return answer;
	}
	static void dfs(int cur, String temp, int start, int end, boolean zero ){

		if(temp.charAt(cur)=='0')zero = true;
		if(zero==true&&temp.charAt(cur)=='1'){
			check = false;
			return;
		}
		if(start>=end)return;
		dfs((start+cur-1)/2, temp, start, cur-1, zero);
		dfs((cur+1+end)/2, temp, cur+1, end, zero);
	}
}