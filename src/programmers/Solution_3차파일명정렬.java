package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_3차파일명정렬 {

	static List <Node> list; 
	public static void solution(String[] files) {
		// TODO Auto-generated method stub
		System.out.println(1);

list = new ArrayList<>(); 
		
		for(int i=0; i<files.length; i++) {
			StringBuilder sb = new StringBuilder(); 
			String head=""; 
			String number = ""; 
			String tail = ""; 
			boolean flag = true; 
			for(int j=0; j<files[i].length(); j++) {
				if(flag==true&&files[i].charAt(j)>='0'&&files[i].charAt(j)<='9') {
					//숫자를 처음 만났을 때 
					head = sb.toString(); 
					sb.setLength(0);
					sb.append(files[i].charAt(j)); 
					flag = false; 
				}
			    else if(flag==true) {
					sb.append(files[i].charAt(j)); 
					//System.out.println(sb.toString());
				}
			
				else if(flag==false&&files[i].charAt(j)>='0'&&files[i].charAt(j)<='9') {
					//숫자를 합할 때 
					sb.append(files[i].charAt(j)); 
					//System.out.println(sb.toString());
				}
				else if(flag==false) {
					//System.out.println(sb.toString());
                    flag = true; 
					number = sb.toString();				
					sb.setLength(0);
					sb.append(files[i].substring(j, files[i].length())); 
					break; 
				}			
			}           
            if(flag==false&&!sb.toString().isEmpty()) {
                    number = sb.toString(); 
             }            
            
			sb.setLength(0);			
			list.add(new Node(files[i], head.toUpperCase(), Integer.parseInt(number))); 
			Collections.sort(list);		
            
		}
    
        String [] answer = new String[list.size()]; 
		for(int i=0; i<list.size(); i++) {
			answer[i] = list.get(i).s; 
		}
        
		
	//	System.out.println(s);
	}

	static class Node implements Comparable <Node>{
		
		String s;
		String upperString; 
		int number; 
		
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			if(this.upperString.equals(o.upperString)) {
				return this.number - o.number; 
			}
			return this.upperString.compareTo(o.upperString); 			
		}

		public Node(String s, String upperString, int number) {
			super();
			this.s = s;
			this.upperString = upperString;
			this.number = number;
		}
	}
}
