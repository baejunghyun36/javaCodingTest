package grammar;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 리스트 {
	
	
	public static void main(String[] args) {
		
		
		List<Integer> list = new ArrayList<>(); 
		List<Integer> list2 = new LinkedList<>(); 
		
		list.add(1); 
		list.add(2); 
		list.get(0); 
		list.remove(0); 
		System.out.println(list.get(0));
		
		list2.add(1); 
		list2.add(2); 
		list2.remove(0);
		System.out.println(list2.get(0));
	}

}
