import java.io.*;
import java.util.StringTokenizer;

public class Main_4659 {
    static String vowel = "aioeu";
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        //StringTokenizer st = new StringTokenizer(br.readLine());

        //Vowel 모음  consonant 자음

        while(true){
            String s = br.readLine();
            if(s.equals("end"))break;
            int seqAlpa = 0;
            char prevAlpa = 'A';
            boolean check1 = false;
            boolean check2 = true;
            boolean check3 = true;
            int vowelCnt = 0;
            int consonantCnt = 0;
            for(int i=0; i<s.length(); i++){
                char c = s.charAt(i);
                if(check1==false&&vowel.contains(c+""))check1= true;
                if(vowel.contains(c+"")){vowelCnt++; consonantCnt = 0; }
                else {consonantCnt++; vowelCnt=0;}
                if(vowelCnt==3||consonantCnt==3){
                    check2 = false;
                    break;
                }
                if(c==prevAlpa&&!(c=='o'||c=='e')){
                    check3 = false;
                    break;
                }
                prevAlpa = c;
            }
            if(check1&&check2&&check3)sb.append("<").append(s).append(">").append(" is acceptable.").append("\n");
            else sb.append("<").append(s).append(">").append(" is not acceptable.").append("\n");
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
