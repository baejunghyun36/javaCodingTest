import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class Main {

  static int n;
  static int [] info;
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    info = new int[10000*13];
    n = Integer.parseInt(br.readLine());
    for(int i=0; i<n; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      String s = st.nextToken();
      String e = st.nextToken();
      int ys = Integer.parseInt(s.substring(0,4));
      int ds = Integer.parseInt(s.substring(5))-1;
      info[ys*12+ds] += 1;
      int ye = Integer.parseInt(e.substring(0,4));
      int de = Integer.parseInt(e.substring(5))-1;
      info[ye*12+de+1] += -1;

    }
    int value = 0;
    int answer = 0;
    for(int i=2000; i<10000*13; i++){
      info[i]+=info[i-1];
      if(value<info[i]){
        value = info[i];
        answer = i;
      }
    }

    sb.append(answer/12).append("-");
    if((answer%12+1)<10)sb.append("0");
    sb.append(answer%12+1);



    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();

  }
}