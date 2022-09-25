package grammar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 배열정렬 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] arr = new int [3]; 
		arr[0] = 2; 
		arr[1] = 1; 
		arr[2] = 3; 
		
		Arrays.sort(arr);
		
		System.out.println(Arrays.toString(arr));
		
		Integer[] arr2 = {1,2,3}; 
		Arrays.sort(arr2, Collections.reverseOrder());
		
		System.out.println(Arrays.toString(arr2));
		
	}

}
