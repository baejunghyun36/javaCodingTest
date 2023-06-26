import java.io.*;
import java.util.*;

public class Main {

    static Map <String, String> map;
    static String [][] info = {
            {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
            {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
            {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
            {"", "M", "MM", "MMM"}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = null;

        map = new HashMap<>();

        for(int i=3999; i>=1; i--){
            sb = new StringBuilder();
            String number = String.valueOf(i);
            int length = number.length();
            for(int j = number.length(); j>=1; j--){
                int index = Integer.parseInt(number.charAt(length-j)+"");
                sb.append(info[j-1][index]);
            }
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