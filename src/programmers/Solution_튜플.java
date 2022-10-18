package programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution_튜플 {

	public static void main(String[] args) {
        
        String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
  
        
        Set<String> set = new HashSet<>(); 
        String[] arr = s.replaceAll("[{]"," ").replaceAll("[}]", " ").trim().split(" , ");
        Arrays.sort(arr,(a,b)->{return a.length() - b.length();});
        int [] answer = new int[arr.length]; 
        int idx = 0; 
        for(String s1 : arr) {
        	for(String s2 : s1.split("[,]")) {
        		System.out.println(set.add(s2));
        		//if(set.add(s2))answer[idx++] = Integer.parseInt(s2); 
        	}
        }
        System.out.println(Arrays.toString(answer));
        
        
        
        
//        String ss = s.substring(1, s.length()-1); 
//       // System.out.println(ss); 
//        StringTokenizer st = new StringTokenizer(ss,"{"); 
//        ArrayList <Node> list = new ArrayList<>(); 
//        while(st.hasMoreTokens()){
//             String temp = st.nextToken(); 
//             //System.out.println(temp);
//             StringTokenizer t = new StringTokenizer(temp, "}"); 
//             String tt = t.nextToken(); 
//             //System.out.println(tt);
//             list.add(new Node(tt)); 
//        }
//        ArrayList <Integer> result = new ArrayList<>(); 
//        Collections.sort(list);
//        Map <String, Integer> map = new HashMap<>(); 
//        for(Node n : list) {
//        	st = new StringTokenizer(n.s, ","); 
//        	while(st.hasMoreTokens()) {
//        		ss = st.nextToken();
//        		//System.out.println(ss);
//        		if(map.get(ss)==null) {
//        			map.put(ss, 1); 
//        			result.add(Integer.parseInt(ss)); 
//        		}
//        	}
//        	
//        	//System.out.println(n.s);
//        }
//        int [] answer = new int [result.size()]; 
//        for(int i=0; i<result.size(); i++) {
//        	answer[i] = result.get(i); 
//        }
//        System.out.println(Arrays.toString(answer));
        
	}
	
	/*static class Node implements Comparable <Node> {
		String s;

		public Node(String s) {
			super();
			this.s = s;
		} 
	
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return s.length() - o.s.length();
		}
		
	}*/

}
