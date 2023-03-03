import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17087 {

  static int n;
  static int subin;


  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    subin = Integer.parseInt(st.nextToken());
    int [] brother = new int[n];
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<n; i++){
      brother[i] = Math.abs(subin - Integer.parseInt(st.nextToken()));
    }
    Arrays.sort(brother);
    int answer = brother[0];
    for(int i=1; i<n; i++) {
      answer = gcd(answer, brother[i]);
    }


    sb.append(answer);
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }

  static int gcd(int a, int b) {
    while(b > 0) {
      int temp = a;
      a = b;
      b = temp%b;
    }
    return a;
  }
}
