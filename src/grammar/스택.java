package grammar;

import java.util.Stack;

public class 스택 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		Stack<Integer> st= new Stack<>(); 
		
		st.add(1); 
		st.add(2); 
		
		st.size();//크기  
		
		int x= st.pop(); //스택 탑 부터 빼
		int y= st.pop(); 
		
		st.peek(); 
		
		System.out.println(st.size());

	}

}
