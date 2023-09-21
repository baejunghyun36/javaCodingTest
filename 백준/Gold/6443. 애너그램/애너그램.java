import java.io.*;


public class Main {

    static char[] str;
    static int [] alpa;
    static StringBuilder sb;
    static int n;
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            alpa = new int[26];
            for (int j = 0; j < s.length(); j++)  alpa[s.charAt(j) - 'a']++;
            str = new char[s.length()];
            backTracking(0);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void backTracking(int index){

        if(str.length == index){
            sb.append(String.valueOf(str)).append("\n");
            return;
        }

        for (int i = 0; i < 26; i++) {
            if(alpa[i]>0){
                alpa[i]--;
                str[index] = (char) (i + 'a');
                backTracking(index+1);
                alpa[i]++;
            }
        }
    }
}