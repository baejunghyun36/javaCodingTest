import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(br.readLine());
    long [] arr = new long[50001];
    int start = 1;
    ArrayList<Integer> answer = new ArrayList<>();
    for(int i=1; i<=50000; i++){
      arr[i] = (long)Math.pow(i, 2);
      while(start<i){
        if(arr[i]-arr[start]<n)break;
        else if(arr[i]-arr[start]>n) start++;
        else{
          answer.add(i);
          break;
        }
      }
    }
    if(answer.size()==0)sb.append(-1);
    else{
      for(int x : answer){
        sb.append(x).append("\n");
      }
    }

    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }
}