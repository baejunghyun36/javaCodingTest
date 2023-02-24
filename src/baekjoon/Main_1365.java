import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1365 {

  static int n;
  static int [] arr;
  static ArrayList<Integer> list;
  static int l, h, mid;
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    arr = new int[n+1];
    list = new ArrayList<>();
    st = new StringTokenizer(br.readLine());

    for(int i=1; i<=n; i++){
      int x = Integer.parseInt(st.nextToken());
      if(list.size()==0) list.add(x);
      else if(list.get(list.size()-1)<x)list.add(x);
      else{
        l = 0;
        h = list.size()-1;
        int index = h;
        while(l<=h){
          mid = (l+h)/2;
          if(list.get(mid)>x){
            h = mid-1;
            index = mid;
          }
          else l = mid+1;
        }
        list.set(index, x);
      }
      //System.out.println(list);
    }
    //System.out.println(list);
    System.out.println(n - list.size());

    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }
}
