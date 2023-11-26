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

    static boolean isFailCheck(int number){
        for (int i = 0; i < n; i++) {
            if(number<info[i]) return true;
        }
        return false;
    }


    static void binarySearch(){
        int l = 1;
        int h = 30000;
        while (l <= h) {
            int mid = (l+h)/2;
            if(isFailCheck(mid)){
                l = mid+1;
                continue;
            }
            int sum = 0;
            int cnt = 0;
            ArrayList<Integer> temp = new ArrayList<>();
            int group = 1;
            boolean chk = false;
            for (int i = 0; i < n; i++) {
                if (n - i == m - group) {
                    temp.add(cnt);
                    for (int j = i; j < n; j++) {
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

            if(group > m) {
                l = mid+1;
                continue;
            }

            if(!chk)temp.add(cnt);
            if(group==m){
                for (int i = 0; i < m; i++) answer[i] = temp.get(i);
                minNumber = mid;
                h = mid-1;
            }
        }
    }
}