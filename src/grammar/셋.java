package grammar;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class 셋 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Set<Integer> set = new HashSet<>(); 
		
		set.add(3); 
		set.add(2); 
		set.add(1); 
		set.add(3); 
		set.add(2); 
		set.add(1); 
		
		Iterator it = set.iterator(); 
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println();
		System.out.println("사이즈"+set.size());
		System.out.println();
		
		set.remove(1); 
		set.remove(2); 
		
		it = set.iterator(); 
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println();
		System.out.println("사이즈 : "+set.size());
		System.out.println();
	}

}
