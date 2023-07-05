import java.io.*;
import java.util.*;


public class Main {

    static int [] teamA;
    static int [] teamB;
    static int [] visitedA;
    static int [] visitedB;
    static int n, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        teamA = new int [n];
        teamB = new int [n];
        visitedA = new int[n];
        visitedB = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)teamA[i] = (Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) teamB[i] = (Integer.parseInt(st.nextToken()));

        Arrays.sort(teamA);
        Arrays.sort(teamB);

        for(int i=0; i<n; i++){
            for(int j=n-1; j>=0; j--){
                if(visitedB[j]==1)continue;
                if(teamA[i]>teamB[j]){
                    answer+=2;
                    visitedA[i]=visitedB[j]=1;
                    break;
                }
            }
        }

        for(int i=0; i<n; i++){
            if(visitedA[i]==1)continue;
            for(int j=n-1; j>=0; j--){
                if(visitedB[j]==1)continue;
                if(teamA[i]==teamB[j]){
                    answer+=1;
                    visitedA[i]=visitedB[j]=1;
                    break;
                }
            }
        }

        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}