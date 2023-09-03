import java.io.*;
import java.util.*;

public class Main {

    static int roomCnt;
    static int initAtack;
    static ArrayList<Room> roomList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        roomCnt = Integer.parseInt(st.nextToken());
        initAtack = Integer.parseInt(st.nextToken());
        roomList = new ArrayList<>();
        for (int i = 0; i < roomCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            roomList.add(new Room(t, a, h));
        }
        sb.append(binarySearch());
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static long binarySearch(){

        long l = 1;
        long h = Long.MAX_VALUE-1;
        long answer = h;
        while (l <= h) {
            long mid = (l+h)/2;
            if(war(mid)){
                answer = mid;
                h = mid - 1;
            }
            else l = mid +1;
        }
        return answer;
    }

    static boolean war (long mhp) {
        long atk = initAtack;
        long chp = mhp;
        for (int i = 0; i < roomCnt; i++) {
            Room room = roomList.get(i);
            if (room.t == 1) {
                long monsterAtk = room.a;
                long monsterHp = room.h;
                long aCount = monsterHp/atk;
                if(monsterHp%atk!=0)aCount++;
                long mCount = chp/monsterAtk;
                if(chp%monsterAtk!=0)mCount++;
                if (aCount <= mCount) chp-= monsterAtk * (aCount-1);
                else return false;
            }
            else{
                chp = Math.min(mhp, chp + room.h);
                atk += room.a;
            }
        }
        return true;
    }

    static class Room {
        int t;
        int a;
        int h;

        public Room(int t, int a, int h) {
            this.t = t;
            this.a = a;
            this.h = h;
        }
    }
}