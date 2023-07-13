import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class Main {

    static int n;
    static int [][] map;

    static int whiteCnt=1, blackCnt=1;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<int []>whiteList = new ArrayList<>();
        ArrayList<int []>blackList = new ArrayList<>();
        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1){
                    if(i%2==0){
                        if(j%2==0) whiteList.add(new int[]{i, j});
                        else blackList.add(new int[]{i, j});
                    }
                    else{
                        if(j%2==1) whiteList.add(new int[]{i, j});
                        else blackList.add(new int[]{i, j});
                    }
                }
            }
        }

        while(true){
            flag = false;
            comb(0, 0, blackCnt, new int [blackCnt][2], blackList);
            if(!flag)break;
            blackCnt++;
        }

        while(true){
            flag = false;
            comb(0, 0, whiteCnt, new int [whiteCnt][2], whiteList);
            if(!flag)break;
            whiteCnt++;
        }

        sb.append(blackCnt + whiteCnt -2);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void comb(int start, int cnt, int limitCount, int [][] selectList, ArrayList<int[]> list){

        if(cnt == limitCount){
            flag = true;
            return;
        }
        for(int i=start; i<list.size(); i++){
            if(flag)return;
            int curY = list.get(i)[0];
            int curX = list.get(i)[1];
            boolean trueOrFalse = false;
            for(int j=0; j < cnt; j++){
                int nextY = selectList[j][0];
                int nextX = selectList[j][1];
                if(Math.abs(curY - nextY)==Math.abs(curX - nextX)) {
                    trueOrFalse = true;
                }
            }
            if(!trueOrFalse){
                selectList[cnt][0] = list.get(i)[0];
                selectList[cnt][1] = list.get(i)[1];
                comb(i+1, cnt+1, limitCount, selectList, list);
            }
        }
    }

}