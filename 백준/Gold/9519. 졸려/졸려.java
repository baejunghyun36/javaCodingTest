import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());

    int k = Integer.parseInt(st.nextToken());
    String s = br.readLine();

    int cnt = 1;
    int index = s.length()-1;
    while(true){
      if(index==1)break;
      if(index%2==1) index = (s.length()-1) - (index/2);
      else if(index%2==0)index/=2;
      cnt++;
    }
    k%=cnt;
    //System.out.println(cnt);
    char [] arr = s.toCharArray();
    while(k-->0){
      int start = 0;
      int end = s.length()-1;
      //짝수
      char []temp = new char[s.length()];
      if(s.length()%2==0){
        for(int i=0; i<s.length(); i++){
          if(i%2==0) temp[start++] = arr[i];
          else temp[end--] = arr[i];
        }
      }
      //홀수
      else{
        temp[0] = arr[0];
        start = 1;
        end = s.length()-1;
        for(int i=1; i<s.length(); i++){
          if(i%2==1)temp[end--] = arr[i];
          else temp[start++] = arr[i];
        }
        //System.out.println(Arrays.toString(temp));
      }
      arr = temp;
    }
    sb.append(String.valueOf(arr));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }
}