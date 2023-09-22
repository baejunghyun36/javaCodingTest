import java.io.*;
import java.util.*;

public class Main {

    //아따 취한디
    static int n;
    static boolean flag;
    static int [] visited;
    static Room [] roomList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while (true) {

            n = Integer.parseInt(br.readLine());
            if(n == 0 )break;

            flag = false;
            roomList = new Room[n + 1];
            visited = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String type = "";
                ArrayList<Integer> temp = new ArrayList<>();
                int cost = 0;
                int cnt = st.countTokens();

                for (int j = 0; j < cnt; j++) {
                    if(j==0) type = st.nextToken()+"";
                    else if(j==1) cost = Integer.parseInt(st.nextToken());
                    else if(j==cnt -1) break;
                    else  temp.add(Integer.parseInt(st.nextToken()));
                }

                roomList[i] = new Room(type, cost, temp);
            }
            if(roomList[1].type.equals("T")) System.out.println("No");
            else{
                int money = 0;
                if(roomList[1].type.equals("L")) money = roomList[1].cost;
                visited[1] = 1;
                mazeRunner(1, 1, money);
                if(flag==false) System.out.println("No");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void mazeRunner(int number, int cnt, int money){

        if(flag) return;

        if(number==n){
            System.out.println("Yes");
            flag = true;
            return;
        }

        ArrayList<Integer> doorsOfRoom = roomList[number].doorsOfRoom;
        int m = money;

        for (int x : doorsOfRoom) {
            if(visited[x]==1)continue;
            Room next = roomList[x];
            if(next.type.equals("T")&& m - next.cost <0)continue;
            if(next.type.equals("T")&& m - next.cost >=0) m -= next.cost;
            if(next.type.equals("L")||next.type.equals("E")) m = Math.max(m, next.cost);
            visited[x] = 1;
            mazeRunner(x, cnt+1,  m);
            visited[x] = 0;
        }
    }

    static class Room {
        String type;
        int cost;
        ArrayList <Integer> doorsOfRoom;

        public Room(String type, int cost, ArrayList<Integer> doorsOfRoom) {
            this.type = type;
            this.cost = cost;
            this.doorsOfRoom = doorsOfRoom;
        }
    }
}