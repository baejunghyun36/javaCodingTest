import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1098 {

  static int n, m;
  static int[] crainList;
  static int[] boxList;
  static PriorityQueue<Crain> q;
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    crainList = new int [n];


    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) crainList[i] = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(br.readLine());

    boxList = new int[m];
    q = new PriorityQueue<>();

    st = new StringTokenizer(br.readLine());
    for(int i=0; i<m; i++) boxList[i] = Integer.parseInt(st.nextToken());

    Arrays.sort(crainList);
    Arrays.sort(boxList);

    int index = n-1;
    int answer = 1;

    /* 민정님 보세여
    * 먼저 크레인과 박스를 정렬을 해.
    * 나는 오름차순으로 했고 뒤에서부터 탐색을 할거야. (내림차순 문법 까먹어서..)
    * 무게제한이 가장 큰 크레인 인덱스를 index 변수에 담고 있고, 박스는 무거운 애들부터 꺼낼거야.
    * */
    for(int i=m-1; i>=0; i--){
      /*먼저 박스 무게순대로 딱 한 번 for 문 돌아. 그리고 입력문이 다음과 같이 들어왓다고 볼게
       * 크레인 개수는 3개, 무게 제한은 각각 : 2 8 11
       * 박스 개수는 3개, 무게는 : 3 9 10
       * 그럼 첫번째 박스는 10이 나왔겠지?
       */
      if(index>=0&&boxList[i]<=crainList[index]){
        /*
        * 현재 무게 10인 박스가 크레인에 담을 수 있는지 보는거야.
        * 현재 크레인은 세번째(index) 무게제한 11인 크레인을 바라보고 있어
        * 만약 위의 조건식이 만족됐다? 그러면 우선순위 큐에다가 현재 크레인의 정보를 넣어(cnt =1) .
        * 크레인 정보를 cnt만 넣었는데 왜그런거냐면,
        * 현재 로직에선 크기가 가장 큰 순서대로 박스를 뽑아서 그 박스를 옮길 수 있는 크레인을 위 조건식에서 판단하기 때문에
        * 굳이 무게제한이 몇 인 크레인이다를 명시할 필요없이 cnt만 기록해주면 현재 큐에는 박스를 옮길 수 있는 크레인들만 존재한다라는 의미이고,
        * 그 크레인은 현재 cnt만큼 박스를 옮겼어라는 의미야. 그래서 최초 큐에 넣을 때 현재 박스를 옮겼다 의미로 1을 넣는거야.
        * 그리고 무게제한이 낮은 다음 크레인을 가리키도록 해. 다음 크레인은 무게제한 8인 놈이야 (index--)
        * 참고로, 우선순위 큐는 cnt(배로 옮기는 횟수)가 낮은 값을 우선순위로 두고 있어.
         * 만약 큐에 크레인이 여러개 있다면 박스를 옮긴 횟수가 가장 적은 애를 우선순위로 두니까 크레인들이 공평하게 박스를 옮기겟지?
         */
        q.add(new Crain(1));
        index--;
        /* 조건식 끝나서 이제 for문 다시 돌리면 이제 박스 9가 나올 차례야 */
      }
      else{
        /*
        * 박스 9가 나왔는데 크레인 무게제한은 지금 8이잖아 그러면 박스를 못옮기지?
        * 근데 아까 큐에 넣었던 크레인을 쓰는거야. 큐에 넣었던 크레인은 모든 박스를 다 옮길 수 있잖아
        * 그러면 아까 큐에 넣었던 놈의 cnt를 하나 증가시켜주면 돼
        * */
        if(q.isEmpty()){
          //만약에 큐가 현재 비어있다는 것은 현재 박스를 옮길 수 있는 크레인은 존재하지 않다는 의미니까 바로 종료
          answer = -1;
          break;
        }
        Crain c = q.poll();
        c.cnt++;
        answer = Math.max(answer, c.cnt);
        q.add(c);
      }
    }


    sb.append(answer);
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }
  static class Crain implements Comparable <Crain> {

    int cnt;

    public Crain(int cnt) {
      this.cnt = cnt;
    }

    @Override
    public int compareTo(Crain o) {
      return this.cnt - o.cnt;
    }
  }

}
