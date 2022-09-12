package programmers;


import java.util.*; 

class Solution_K진수에서소수개수구하기 {

    public int solution(int n, int k) {
    	
    	
        int result = 0; 
		StringBuilder sb = new StringBuilder(); 
		while(n>0) {			
			sb.append(n%k); 
			n = n/k; 			
		}	
		sb.reverse(); 
		String s = sb.toString(); 

		List <String> arr = new ArrayList<>(); 
		String temp = ""; 
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i)!='0')temp+=s.charAt(i); 
			else if(s.charAt(i)=='0'){
				if(temp!="") arr.add(temp); 			
				temp = ""; 
			}
		}
		if(temp!="") arr.add(temp );         
		for(int i=0; i<arr.size(); i++) {
			String ss = arr.get(i); 	
	        long sum = Long.valueOf(ss); 
			if(check(sum)) result++; 			
		}	
        return result; 
	}
	
	static boolean check (long number) {
	
        System.out.println(number); 
		if(number <=1) return false; 
		else if(number == 2) return true; 
        else {
        	for(long i=2; i<=(int)Math.sqrt(number); i++) {
                if(number%i== 0 ) {
                    return false; 
                }
	    	}
        }
		return true; 
	}
}