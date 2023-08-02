import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int [] nextAlpa;
    static int [] reverseAlpaIndex;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        String t = br.readLine();
        n = s.length();
        nextAlpa = new int[26];
        reverseAlpaIndex = new int[n];
        Arrays.fill(nextAlpa, -2);
        Arrays.fill(reverseAlpaIndex, -2);
        int answer = 0;
        for(int i = s.length()-1; i>=0; i--){
            int index = s.charAt(i)-'a';
            if(nextAlpa[index]!=-2)reverseAlpaIndex[i] = nextAlpa[index];
            nextAlpa[index] = i;
        }
    
        out:while(true){
            int check = -1;
            for (int i = 0; i < t.length(); i++) {
                int index = t.charAt(i) - 'a';
                if(nextAlpa[index]==-2)break out;
                while(check>nextAlpa[index]&&nextAlpa[index]!=-2){
                    nextAlpa[index] = reverseAlpaIndex[nextAlpa[index]];
                    if(nextAlpa[index]==-2)break out;
                }
                check = nextAlpa[index];
                nextAlpa[index] = reverseAlpaIndex[nextAlpa[index]];
            }
            answer++;
        }

        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}