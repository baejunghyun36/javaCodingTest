package swea.d4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
 
public class Solution_1218 {
 
    public static void main(String[] args) throws NumberFormatException, IOException {

         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
         
         
        for(int test =1; test<=10; test++) {
         
            Stack<Character> st = new Stack<>();
             
            int n = Integer.parseInt(br.readLine()); 
            String s = br.readLine(); 
            boolean flag = true; 
            for(int i=0; i<n; i++) {
                 
                char c = s.charAt(i); 
                if(c=='('||c=='['||c=='{'||c=='<') {
                    st.push(c); 
                }
                else {
                    char top = st.pop(); 
                     
                    if(c==')'&&top=='(')continue; 
                    else if(c==']'&&top=='[') continue; 
                    else if(c=='}'&&top=='{')continue; 
                    else if(c=='>'&&top=='<')continue; 
                    else {
                        flag=false; 
                        break; 
                    }
                }
            }
            if(!st.isEmpty()||flag==false) System.out.printf("#%d %d%n", test, 0);
            else System.out.printf("#%d %d%n", test, 1);
        }
    }
 
}