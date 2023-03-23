import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_12886 {

  static int [][] visited;
  static int [] arr;
  static int answer;
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());

    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    arr = new int[3];
    visited = new int[1001][1001];

    dfs(a,b,c);
    sb.append(answer);

    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }
  static void dfs(int a, int b, int c){

    if(a==b&&b==c){
      answer = 1;
      return;
    }

    arr[0] = a;
    arr[1] = b;
    arr[2] = c;

    Arrays.sort(arr);

    if(visited[arr[0]][arr[1]]==1)return;
    visited[arr[0]][arr[1]] = 1;
    if(answer==0&&arr[0]!=arr[1])dfs(arr[0]*2, arr[1]-arr[0], arr[2]);
    if(answer==0&&arr[0]!=arr[2])dfs(arr[0]*2, arr[1], arr[2]-arr[0] );
    if(answer==0&&arr[1]!=arr[2])dfs(arr[0], arr[1]*2, arr[2]-arr[1]);
  }
}

