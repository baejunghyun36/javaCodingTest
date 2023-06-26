import java.io.*;
import java.util.*;


public class Main {

    static int n, x, y;
    static double r, d;
    static List<Point> pointList;
    static int [] visited;
    static double answer;
    static Queue <Point> q;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        q = new LinkedList<>();
        pointList = new ArrayList<>();
        visited = new int [n+1];


        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int xx = Integer.parseInt(st.nextToken());
            int yy = Integer.parseInt(st.nextToken());

            pointList.add(new Point(yy, xx));
        }

        r = Math.pow(r, 2);



        for(int i=0; i<n; i++){

            Point point = pointList.get(i);
            double c = Math.pow(Math.abs(y-point.y),2) + Math.pow(Math.abs(x - point.x),2);
            if(c<=r){
                visited[i]=1;
                q.add(point);
            }
        }


        while(!q.isEmpty()){

            int size = q.size();
            answer += d*size;
            d /= 2;

            while(size-->0){
                Point curPoint = q.poll();
                for(int i=0; i<n; i++){
                    if(visited[i] == 1)continue;
                    Point nextPoint = pointList.get(i);
                    double c = Math.pow(Math.abs(curPoint.y-nextPoint.y),2) + Math.pow(Math.abs(curPoint.x - nextPoint.x),2);
                    if(c<=r){
                        visited[i]=1;
                        q.add(nextPoint);
                    }
                }
            }
        }

        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class Point {

        int y;
        int x;

        public Point (int y, int x){
            this.y = y;
            this.x = x;
        }
    }
}