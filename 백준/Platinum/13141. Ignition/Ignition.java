import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int [][] floydArr;
    static ArrayList<Edge> list;
    static final int INF = 987654321;
    //o(n^3+nm)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        floydArr = new int[n + 1][n + 1];
        list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            Arrays.fill(floydArr[i], INF);
            floydArr[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.add(new Edge(a, b, c));
            floydArr[a][b] = Math.min(floydArr[a][b], c);
            floydArr[b][a] = Math.min(floydArr[b][a], c);
        }
        floydWarshall();
        sb.append(solution());
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    //o(mn)
    static double solution(){
        double minTime = INF;
        for (int start = 1; start <= n; start++) {
            double maxTime = 0;
            for (Edge edge : list) {
                double t = Math.max(floydArr[start][edge.a], floydArr[start][edge.b])+
                        (edge.cost - (Math.max(floydArr[start][edge.a], floydArr[start][edge.b])-
                                Math.min(floydArr[start][edge.a], floydArr[start][edge.b])))/2.0;
                maxTime = Math.max(maxTime, t);
//                System.out.println(edge.a+" " + edge.b + " " + edge.cost + " "+ t);
//                System.out.println(floydArr[start][edge.a]+" "+floydArr[start][edge.b]);
//                System.out.println(t);
            }
            minTime = Math.min(minTime, maxTime);
//            System.out.println(minTime);
//            System.out.println();
        }
//        System.out.println(minTime+" kj");
        return minTime;
    }

    //o(n^3)
    static void floydWarshall (){
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (floydArr[i][j] > floydArr[i][k] + floydArr[k][j]) {
                        floydArr[i][j] = floydArr[i][k] + floydArr[k][j];
                    }
                }
            }
        }
    }

    static class Edge {

        int a;
        int b;
        int cost;

        public Edge(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
    }
}