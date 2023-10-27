import java.io.*;
import java.util.*;

public class Main {

    static String vowel = "AIEOU";
    static char[] alpaArr;
    static long answer;
    static long [][][]dp;
    static List<Integer> underBarList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        alpaArr = br.readLine().toCharArray();
        sb.append(dfs(0, 0, 0, false));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    
    static long dfs(int index, int consonantCnt, int vowelCnt, boolean isL){
        if(consonantCnt==3||vowelCnt==3) return 0;
        if(index==alpaArr.length){
            if(isL) return 1;
            else return 0;
        }
        long count = 0;
        if (alpaArr[index] == '_') {
            //모음 선택할 때
            count+= dfs(index+1, 0, vowelCnt+1, isL)*5;
            count+= dfs(index+1, consonantCnt+1, 0, isL)*20;
            count+= dfs(index+1, consonantCnt+1, 0, true);
        } else if (vowel.contains(alpaArr[index] + "")) {
            //모음;
             count += dfs(index + 1, 0, vowelCnt + 1, isL);
        } else {
            //자음
            if(alpaArr[index]=='L') count += dfs(index + 1, consonantCnt + 1, 0, true);
            else count += dfs(index + 1, consonantCnt + 1, 0, isL);
        }
        return count;
    }
}