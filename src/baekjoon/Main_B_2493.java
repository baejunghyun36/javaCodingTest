package baekjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;


//웅렬 조교 코드 도움 받음. 
public class Main_B_2493 {
	public static void main(String[] args) throws Exception
	{
		BufferedReader	br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter	bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder	sb = new StringBuilder();
		StringTokenizer	st;
		Stack<int[]>	stack = new Stack<>();
		int				n = Integer.parseInt(br.readLine());
		int				temp;
		int[]			offset = {0, 2100000000};
		stack.push(offset);
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= n; i++)
		{
			temp = Integer.parseInt(st.nextToken());
			while (stack.peek()[1] < temp)
				stack.pop();
			sb.append(stack.peek()[0]);
			int[]	arr = {i, temp};
			stack.push(arr);
			sb.append(' ');
		}
		
		sb.deleteCharAt(sb.lastIndexOf(" "));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
