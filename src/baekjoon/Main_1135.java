import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1135 {

  static int n, second;
  static ArrayList<Info>[]list;
  static boolean [] visited;
  static PriorityQueue<Person> q;
  static int answer;
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    list = new ArrayList[n+1];
    visited = new boolean[n+1];
    visited[0] = true;
    q = new PriorityQueue<>();
    for(int i=0; i<=n; i++)list[i] = new ArrayList<>();
    for(int i=0; i<n; i++){
      int Boss = Integer.parseInt(st.nextToken());
      if(i==0)continue;
      list[Boss].add(new Info(0,  i));
    }

    int [] level = new int[n+1];
    for(int i=0; i<n; i++){
      level[i] = dfs(i, 0);
    }

    for(int i=0; i<n; i++){
      for(int j=0; j<list[i].size(); j++) {
        Info info = list[i].get(j);
        info.depth = level[list[i].get(j).index];
      }
    }

    for(int i=0; i<=n; i++) Collections.sort(list[i]);
    for(int i=0; i<list[0].size(); i++)q.add(new Person(list[0].get(i).index, i+1));

    second = 1;
    while(!q.isEmpty()){
      while(!q.isEmpty()&&q.peek().second==second) {
        Person p = q.poll();
        if (visited[p.index] == false) {
          visited[p.index] = true;
          int tempSecond = second+1;
          for (int i = 0; i < list[p.index].size(); i++) {
            if(visited[list[p.index].get(i).index]==true)continue;
            q.add(new Person(list[p.index].get(i).index, tempSecond++));
          }
        }

      /*
10
-1 0 0 0 2 2 3 3 3 6

      */
      }
      if(q.isEmpty())break;
      second++;
    }
    sb.append(second);
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }


  static int dfs(int cur, int level){
    if(list[cur].size()==0)return level;
    int cnt = 0;
    for(int i=0; i<list[cur].size(); i++){
      cnt = Math.max(cnt, dfs(list[cur].get(i).index, level+1));
    }
    return cnt;
  }

  static class Info implements Comparable<Info>{

    int depth;
    int index;

    public Info(int depth, int index) {
      this.depth = depth;
      this.index = index;
    }

    @Override
    public int compareTo(Info o) {
      return o.depth - this.depth;
    }
  }


  static class Person implements Comparable<Person>{
    int index;
    int second;
    public Person(int index, int second) {
      this.index = index;
      this.second = second;
    }
    @Override
    public int compareTo(Person o) {
      return this.second - o.second;
    }
  }
}
