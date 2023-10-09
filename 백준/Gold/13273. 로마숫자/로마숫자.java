import java.io.*;
import java.util.StringTokenizer;
import java.util.*;

public class Main {

    static Map <String, String> map;
    static String [] example = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        map = new HashMap<>();

        for(int i=1; i<=3999; i++){
            int offset = 0;
            sb = new StringBuilder();
            String s1 = "";
            String s2 = "";
            String s3 = "";
            int number = i;
            String temp = "";
            while(number!=0){
                temp = example[number%10];
                if(offset==1){
                    for(int j = 0; j<temp.length(); j++) {
                        if(temp.charAt(j)=='I')s1+='X';
                        else if(temp.charAt(j)=='V')s1+='L';
                        else s1+='C';
                    }
                }
                else if(offset==2){
                    for(int j = 0; j<temp.length(); j++) {
                        if(temp.charAt(j)=='I')s2+='C';
                        else if(temp.charAt(j)=='V')s2+='D';
                        else s2+='M';
                    }
                }
                else if(offset==3){
                    for(int j = 0; j<temp.length(); j++) s3+='M';
                }

                offset++;
                number/=10;
            }
            sb.append(s3).append(s2).append(s1).append(example[i%10]);
            map.put(i+"", sb.toString());
            map.put(sb.toString(), i+"");

        }

        sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for(int i=0; i<testCase; i++) sb.append(map.get(br.readLine())).append("\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}