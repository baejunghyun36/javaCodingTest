import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n,l,r,x, answer;
    static int [] isSelected;
    static int [] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        list = new int[n];
        isSelected = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        subset(0);
        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    static void check(){

        int minNumber = 987654321;
        int maxNumber = -1;
        int cnt = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            if(isSelected[i]==1){
                cnt++;
                sum += list[i];
                minNumber = Math.min(list[i], minNumber);
                maxNumber = Math.max(list[i], maxNumber);
            }
        }

        if(l<=sum&&sum<=r&&maxNumber-minNumber>=x&&cnt>=2) answer++;
    }

    static void subset(int index){

        if (index == n) {
            check();
            return;
        }

        isSelected[index] = 1;
        subset(index + 1);
        isSelected[index] = 0;
        subset(index + 1);
    }
}