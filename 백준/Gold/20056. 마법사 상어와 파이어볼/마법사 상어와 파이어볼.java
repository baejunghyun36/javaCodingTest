import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static int n, m, k;
    static Map <int[], ArrayList<FireBall>> map;
    static int [][] board;
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static List<FireBall> fireBallList;
    static int prevY, prevX, totalZ, totalS, total, odd, even, prevD;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        board = new int [n+1][n+1];
        fireBallList = new ArrayList<>();

        for(int i =0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            fireBallList.add(new FireBall(y, x, z, d, s));
        }

        while(k-->0){
            for (int i = 0; i < fireBallList.size(); i++) {
                FireBall fb = fireBallList.get(i);
               // System.out.println(fb.y+" "+ fb.x + " " + fb.d + " " + fb.s);
                int ny = fb.y + dy[fb.d] * (fb.s % n);
                int nx = fb.x + dx[fb.d] * (fb.s % n);
                //System.out.println(ny+" "+ nx);

                if(ny<=0)ny+=n;
                else if(ny>n)ny-=n;
                if(nx<=0)nx+=n;
                else if(nx>n)nx-=n;

                fb.y = ny;
                fb.x = nx;

               // System.out.println(ny+" "+ nx);
               // System.out.println();
            }

            Collections.sort(fireBallList, (o1, o2)->{
               if(o1.x==o2.x)return o1.y - o2.y;
               return o1.x - o2.x;
            });

            fireBallList.add(new FireBall(0, 0, 0, 0, 0));
            List<FireBall> temp = new ArrayList<>();
            prevY = prevX = totalZ = totalS = total = odd = even = 0;
            prevY = fireBallList.get(0).y;
            prevX = fireBallList.get(0).x;
            totalZ = fireBallList.get(0).z;
            totalS = fireBallList.get(0).s;
            prevD = fireBallList.get(0).d;
            total = 1;
            if(fireBallList.get(0).d%2==1)odd++;
            else even++;
//            System.out.println(prevY+" " + prevX + " "+ totalZ + " " + totalS + " " + prevD);
            for (int i = 1; i < fireBallList.size(); i++) {
                FireBall fb = fireBallList.get(i);
//                System.out.println(fb.y+" "+ fb.x+ " " +fb.z + " " + fb.s + " " + fb.d );
                if (prevY != fb.y || prevX != fb.x) {
                    if(total<2){
                        temp.add(new FireBall(prevY, prevX, totalZ, prevD, totalS));
                    }
                    else if (totalZ/5 == 0) {
                    }
                    else {
                        if (odd == 0 || even == 0) for (int j = 0; j <= 6; j += 2) temp.add(new FireBall(prevY, prevX, totalZ / 5, j, totalS / total));
                        else for (int j = 1; j <= 7; j += 2) temp.add(new FireBall(prevY, prevX, totalZ / 5, j, totalS / total));
                    }
                    total = totalZ = totalS = odd = even = 0;
                }
                totalZ += fb.z;
                totalS += fb.s;
                total++;
                if(fb.d%2==1)odd++;
                else even++;
                prevY = fb.y;
                prevX = fb.x;
                prevD = fb.d;
            }
            fireBallList = temp;
//            System.out.println("\nlist");
//            for(FireBall f : fireBallList) {
//                System.out.println(f.y+" "+ f.x+ " " +f.z + " " + f.s + " " + f.d );
//            }
//            System.out.println();
        }

        int answer = 0;
//        System.out.println("----------------");
        for(FireBall f : fireBallList) {
//            System.out.println(f.z + " " + f.y+" "+ f.x);
            answer += f.z;
        }
        sb.append(answer);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    static class FireBall {
        int y;
        int x;
        int z;
        int d;
        int s;

        public FireBall (int y, int x, int z, int d, int s){
            this.y = y;
            this.x = x;
            this.z = z;
            this.d = d;
            this.s = s;
        }
    }
}