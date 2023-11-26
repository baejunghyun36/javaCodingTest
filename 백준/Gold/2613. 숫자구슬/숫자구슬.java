import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int [] info;
    static int [] answer;
    static int minNumber;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        info = new int[n];
        answer = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) info[i] = Integer.parseInt(st.nextToken());
        binarySearch();
        sb.append(minNumber+"\n");
        for (int i = 0; i < m; i++) {
            sb.append(answer[i]+" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    static void binarySearch(){
        int l = 1;
        int h = 2000000000;

        while (l <= h) {
            int mid = (l+h)/2;
            int sum = 0;
            int cnt = 0;
            ArrayList<Integer> temp = new ArrayList<>();
            boolean flag = false;
            int group = 1;
            boolean chk = false;
            out:for (int i = 0; i < n; i++) {
                if(info[i] > mid) {
                    flag = true;
                    break;
                }
                if (n - i == m - group) {
                    temp.add(cnt);
                    for (int j = i; j < n; j++) {
                        if(info[j] > mid) {
                            flag = true;
                            break out;
                        }
                        temp.add(1);
                    }
                    group = m;
                    chk = true;
                    break;
                }

                if(sum+info[i]<=mid){
                    sum+=info[i];
                    cnt++;
                }
                else{
                    temp.add(cnt);
                    sum = info[i];
                    group ++;
                    cnt = 1;
                }
            }
            if(flag||group > m) {l = mid+1; continue;}
            if(!chk)temp.add(cnt);
            if(group==m){
                for (int i = 0; i < m; i++) answer[i] = temp.get(i);
                minNumber = mid;
                h = mid-1;
            }
            else if(group < m) h = mid -1;
        }
    }
}