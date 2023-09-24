import java.io.BufferedReader;

import java.io.InputStreamReader;

import java.util.HashMap;

import java.util.Stack;

public class Main {

		static int [] arr; 

	static Stack <Info> stack, calStack; 

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] input = br.readLine().toCharArray();

		arr = new int[input.length]; 

		for(int i=0; i<arr.length; i++) {

			if(input[i]=='(')arr[i] = 2; 

			if(input[i]==')')arr[i] = -2; 

			if(input[i]=='[')arr[i] = 3; 

			if(input[i]==']')arr[i] = -3; 

		}

		stack = new Stack<>(); 

		calStack = new Stack<>(); 

		boolean flag = true; 

		stack.add(new Info(0,0)); 

		for(int i=0; i<arr.length; i++) {

			if(arr[i]>0) stack.add(new Info(stack.size(), arr[i])); 

			else {

				if(stack.peek().cost+arr[i]==0) {

					int sum = 0; 

					while(!calStack.isEmpty()&&stack.peek().level<calStack.peek().level) {

						sum+= calStack.pop().cost; 

					}

					if(sum==0) sum = 1; 

					calStack.add(new Info(stack.peek().level, stack.pop().cost*sum));	

				}

				else {

					flag = false; 

					break; 

				}

			}

		}

		if(!flag||stack.size()>1) System.out.println(0); 

		else {

			int answer = 0; 

			while(!calStack.isEmpty()) answer+=calStack.pop().cost; 

			System.out.println(answer); 

		}

	}//main

	

	static class Info {

		int level; 

		int cost; 

		public Info(int level, int cost) {

			this.level = level; 

			this.cost = cost; 

		}

	}

	

}//class