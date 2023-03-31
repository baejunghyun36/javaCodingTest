import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_13904 {


  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int [][] arr = new int[n][2];
    for(int i=0; i<n; i++){
      st = new StringTokenizer(br.readLine());
      arr[i][0] = Integer.parseInt(st.nextToken());
      arr[i][1] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr, (o1, o2)-> o2[1] - o1[1]);
    int [] score = new int[1001];

    for(int i=0; i<n; i++){

      int d = arr[i][0];
      int w = arr[i][1];
      for(int j=d; j>=1; j--) {
        if (score[j] == 0) {
          score[j] = w;
          break;
        }
      }
    }
    int answer = 0;
    for(int i=1; i<=1000; i++)  answer+=score[i];
    sb.append(answer);

    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }

}
