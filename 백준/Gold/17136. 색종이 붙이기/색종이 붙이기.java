import java.io.*;
import java.util.*;

public class Main {

    static int [][] map;
    static int [] paper;
    static final int n = 10;
    static boolean flag;
    static int answer=987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        map = new int[n][n];
        paper = new int[6];
        for(int i=1; i<=5; i++)paper[i] = 5;
        for(int i=0; i<10; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }
        backTracking(0, 0, 0);
        if(answer==987654321) sb.append(-1);
        else sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void backTracking(int cnt, int y, int x){

//        System.out.println(y+" "+ x);
        if(y==n&&x==0){
            answer = Math.min(answer, cnt);
            return;
        }
        if(answer<=cnt) return;
        if(x==n) backTracking(cnt, y+1, 0);
        else{
            if(map[y][x]==0) backTracking(cnt, y, x+1);
            else{
                for (int k = 5; k >=1 ; k--) {
                    if(paper[k]==0)continue;
                    int i = y;
                    int j = x;
                    if(map[i][j]==1&&i+k-1<n&&j+k-1<n) {
                        int oneCnt = 0;
                        for (int row = i; row < i + k; row++) {
                            for (int col = j; col < j + k; col++) {
                                if (map[row][col] == 1) oneCnt++;
                            }
                        }
                        if (oneCnt == k * k) {
                            for (int row = i; row < i + k; row++) {
                                for (int col = j; col < j + k; col++) {
                                    map[row][col] = 0;
                                }
                            }
                            paper[k]--;
                            backTracking(cnt + 1, i, j + 1);
                            for (int row = i; row < i + k; row++) {
                                for (int col = j; col < j + k; col++) {
                                    map[row][col] = 1;
                                }
                            }
                            paper[k]++;
                        }
                    }
                }
            }
        }
    }
}