import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_4716 {
  static int N;
  static int leftRoom, rightRoom;
  static ArrayList<Team> list;
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();


    while(true){
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      leftRoom = Integer.parseInt(st.nextToken());
      rightRoom = Integer.parseInt(st.nextToken());
      if(N==0&&leftRoom==0&&rightRoom==0)break;
      list = new ArrayList<>();
      for(int i=0; i<N; i++){
        st = new StringTokenizer(br.readLine());
        int number = Integer.parseInt(st.nextToken());
        int leftDist = Integer.parseInt(st.nextToken());
        int rightDist = Integer.parseInt(st.nextToken());
        Team team = new Team(number, leftDist, rightDist, Math.abs(leftDist - rightDist));
        list.add(team);
      }

      Collections.sort(list);
      int answer = 0;
      for(int i=0; i<list.size(); i++){
        Team team = list.get(i);
        // System.out.println(team.number);
        String temp = "";
        temp = team.leftDist < team.rightDist ? "left" : "right";
        while(team.number-->0){
          if(temp.equals("right")){
            {
              if(rightRoom>0){
                answer+=team.rightDist;
                rightRoom--;
              }
              else {
                answer+=team.leftDist;
                leftRoom--;
              }
            }
          }
          else{
            if(leftRoom>0){
              answer+=team.leftDist;
              leftRoom--;
            }
            else {
              answer+=team.rightDist;
              rightRoom--;
            }
          }
        }
      }
      sb.append(answer).append("\n");
    }

    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }

  static class Team implements Comparable<Team>{

    int number;
    int leftDist;
    int rightDist;
    int diff;

    public Team(int number, int leftDist, int rightDist, int diff) {
      this.number = number;
      this.leftDist = leftDist;
      this.rightDist = rightDist;
      this.diff = diff;
    }

    @Override
    public int compareTo(Team o) {
      return o.diff - this.diff;
    }
  }
}
