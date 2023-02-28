import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1225 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());

    String s1 = st.nextToken();
    String s2 = st.nextToken();
    long answer = 0;
    for(int i = 0; i<s1.length(); i++){
      for(int j=0; j<s2.length(); j++){
        answer+=(s1.charAt(i)-'0')*(s2.charAt(j)-'0');
      }
    }
    sb.append(answer);

    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }

}
