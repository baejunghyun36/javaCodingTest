import java.util.*; 
class Solution {
    public int solution(String s) {


		int minNumber = 987654321; 
		for(int fixLength = 1; fixLength<= s.length()/2; fixLength++) {
			Map <String, Integer> map = new HashMap <>(); 
			String [] subStringArray = s.split("(?<=\\G.{" + fixLength+ "})"); 
			//System.out.println(Arrays.toString(subStringArray));
			int cnt = 1; 
			int sum = 0; 
			for(int i=0; i<subStringArray.length; i++) {		
				
				String ss= subStringArray[i]; 
				if(map.containsKey(ss))map.put(ss, map.get(ss)+1); 
				else {
					for(String key : map.keySet()) {
						if(map.get(key)>1)sum+=map.get(key)/10+1 + key.length(); 
						else sum+= key.length(); 
					}
					map.clear();
					map.put(ss, 1); 
				}	
			}
			for(String key : map.keySet()) {
				if(map.get(key)>1)sum+=map.get(key)/10+1 + key.length(); 
				else sum+= key.length(); 
			}
			minNumber = Math.min(minNumber, sum); 
		}
	

        return minNumber; 
	
    }
}