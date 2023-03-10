import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_1599 {
  static char [] alpa = {'a', 'b', 'k', 'd', 'e','g', 'h', 'i', 'l', 'm','n','c','o','p','r','s','t','u','w','y'};
  static ArrayList<String> list;
  static int n;
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());
    list = new ArrayList<>();

    n = Integer.parseInt(st.nextToken());
    ArrayList<OrderString> answer = new ArrayList<>();
    for(int i=0; i<n; i++)list.add(br.readLine().replaceAll("ng", "c"));
    for(int i=0; i<n; i++){
      String s = list.get(i);
      String originString = "";
      for(int j=0; j<s.length(); j++){
        for(int k=0; k<alpa.length; k++){
          if(alpa[k]==s.charAt(j)){
            originString+= (char) k;
            break;
          }
        }
      }
      answer.add(new OrderString(originString, s.replaceAll("c", "ng")));
    }
    Collections.sort(answer, ((o1, o2) -> o1.originString.compareTo(o2.originString)));
    for(OrderString o : answer) sb.append(o.newString).append("\n");

    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }
  static class OrderString{

    String originString;
    String newString;

    public OrderString(String originString, String newString) {
      this.originString = originString;
      this.newString = newString;
    }
  }
}