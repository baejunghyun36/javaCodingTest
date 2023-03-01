import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1781 {
  static int [] score;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());


    int n = Integer.parseInt(st.nextToken());
    score = new int[n+1];
    Arrays.fill(score, -1);
    int [][] arr = new int[n][2];
    for(int i=0; i<n; i++){
      st = new StringTokenizer(br.readLine());
      arr[i][0] = Integer.parseInt(st.nextToken());
      arr[i][1] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr, (o1, o2)-> o2[1] - o1[1]);
    int answer = 0;
    for(int i=0; i<n; i++){
      if(isPossible(arr[i][0])){
        check(arr[i][0]);
        //System.out.println(arr[i][0]+" "+ arr[i][1]);
        answer+=arr[i][1];
      }
    }
    sb.append(answer);
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }
  static boolean isPossible (int index){

    if(index==0)return false;
    if(score[index]==-1)return true;
    return isPossible(score[index]);
  }
  static int check(int index){

    if(score[index]==-1){
      score[index] = index-1;
      return index-1;
    }
    return score[index] = check(score[index]);
  }
}