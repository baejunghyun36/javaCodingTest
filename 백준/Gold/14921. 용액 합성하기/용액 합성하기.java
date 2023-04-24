import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {


  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int [] arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<n; i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }
    int s = 0;
    int e = n-1;
    int answer = 300000000;
    while(s<e){

      if(Math.abs(arr[s]+arr[e])<Math.abs(answer)){answer = arr[s]+arr[e];}
      if(arr[s]+arr[e]<=0)s++;
      else e--;


    }

    sb.append(answer);


    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }

}