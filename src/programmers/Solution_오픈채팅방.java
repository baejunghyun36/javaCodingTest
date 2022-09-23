package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution_오픈채팅방 {

	static Map <String, String> map;
	static LinkedList<Node> list; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ArrayList<String> ss = new ArrayList<>(); 
         
		list = new LinkedList<>(); 
		map = new HashMap<>(); 
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"}; 
		for(int i=0; i<record.length; i++) {
			String []temp = record[i].split(" ");
			if(temp[0].equals("Enter")) {
				list.add(new Node(1, temp[1])); 
				map.put(temp[1], temp[2]); 
			}
			else if(temp[0].equals("Leave")){
				list.add(new Node(0, temp[1])); 
			}
			else {
				map.put(temp[1], temp[2]); 
			}
			
		}
		for(Node node : list) {
			if(node.enter==1) {
				ss.add(map.get(node.id)+"님이 들어왔습니다."); 
			}
			else {
				ss.add(map.get(node.id)+"님이 나갔습니다."); 
			}
		}
		
        String[] answer = new String[ss.size()];
        for(int i=0; i<ss.size(); i++) {
        	answer[i] = ss.get(i); 
        	System.out.println(answer[i]);
        }
        
		
		
	}

	
	
	static class Node {
		
		int enter; 
		String id;
		public Node(int enter, String id) {
			super();
			this.enter = enter;
			this.id = id;
		} 
		
		
	}
}
