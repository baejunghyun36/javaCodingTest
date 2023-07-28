import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int [] moneyPerDay;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        moneyPerDay = new int[n];

        for(int i=0; i<n; i++){
            moneyPerDay[i] = Integer.parseInt(br.readLine());
        }
        sb.append(binarySearch(1, 2000000000));
        //1,000,000,000
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    static int binarySearch (int s, int e){

        int answer = e;
        while(s<=e){
            int mid = (s+e)/2;
            int money = mid;
            int day = 1;
            boolean flag = false;
            for(int i=0; i<n; i++){
                if(money-moneyPerDay[i]>=0){
                    money -= moneyPerDay[i];
                }
                else{
                    money = mid - moneyPerDay[i];
                    if(money<0) {
                        flag = true;
                        break;
                    }
                    day++;
                }
            }
            if(flag){
                s = mid+1;
                continue;
            }
            //현재 돈으로 m번 인출 전에 끝남. k원 줄여줘.
            if(day<=m){
                answer = mid;
                e = mid - 1;

            }
            //현재 돈으로 m번 인출 이상 끝남. 일단 저장.
            else {
                s = mid +1;

            }

        }

        return answer;


    }


}