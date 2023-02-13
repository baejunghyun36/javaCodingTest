import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_2831 {

  static int n;
  static ArrayList<Integer> man;
  static ArrayList<Integer> woman;
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = null;


    n = Integer.parseInt(br.readLine());

    man = new ArrayList<>();
    woman = new ArrayList<>();
    st = new StringTokenizer(br.readLine());
    for(int j=0; j<n; j++) man.add(Integer.parseInt(st.nextToken()));
    st = new StringTokenizer(br.readLine());
    for(int j=0; j<n; j++) woman.add(Integer.parseInt(st.nextToken()));

    Collections.sort(man);
    Collections.sort(woman, Collections.reverseOrder());

    int cnt = 0;
    int start = 0;
    for(int i=0; i<n; i++){

      if(man.get(i)<0){
        //작은 여자를 원해
        while(start<n&&woman.get(start)>0){
          if(woman.get(start)<man.get(i)*-1){
            start++;
            cnt++;
            break;
          }
          else start++;
        }
      }
      else{
        //큰 여자를 원해
        while(start<n&&woman.get(start)>0)start++;
        while(start<n&&woman.get(start)<0){
          if(woman.get(start)*-1>man.get(i)){
            start++;
            cnt++;
            break;
          }
          else start++;
        }
      }
    }
    sb.append(cnt);
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }
}
