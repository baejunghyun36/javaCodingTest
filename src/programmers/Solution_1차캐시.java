package programmers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution_1차캐시 {
	
	static Map <String, Integer> map ; 
	static int number ;
    static LinkedList<Node> list; 
    public int solution(int cacheSize, String[] cities) {
        
       	list = new LinkedList<>(); 
		number = 0; 
		map = new HashMap<>(); 
		
		int answer = 0; 
     

		for(int i=0; i<cities.length; i++) {
			//q.add(new Node(cities[i], number++)); 
			String key = cities[i].toUpperCase(); 
            
			if(map.get(key)!=null) {
				Node node = null; 
				for(int j=0; j<list.size(); j++) {
					if(list.get(j).s.equals(key)) {
						node = list.get(j); 
						node.num = number++; 
						list.remove(j);                      
                        break; 
					}
				}
				list.add(node); 
				answer+=1; 				
			}
			else {
                if(map.size()==cacheSize){
                     map.put(cities[i].toUpperCase(), 1); 
                     list.add(new Node(cities[i].toUpperCase(), number++)); 				
                     Node s = list.get(0);
                     list.remove(0); 
                     map.remove(s.s); 
                     answer+=5; 
                }
                else{
                    map.put(cities[i].toUpperCase(),1); 
                    list.add(new Node(cities[i].toUpperCase(), number++)); 
                    answer+=5; 
                }
              
			}
		}
		
		return answer; 
		
	}
	
	static class Node {
		
		String s; 
		int num;
		
		public Node(String s, int num) {
			super();
			this.s = s;
			this.num = num;
		}

	
	}

}
