import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1436 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    int number = Integer.parseInt(br.readLine());
    int x = 665;
    int cnt = 0;
    String answer = "";
    while(true){
      x++;
      if(Integer.toString(x).contains("666"))cnt++;
      if(cnt==number) break;
    }
    sb.append(x);
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }
}
