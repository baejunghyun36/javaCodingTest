import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2954 {
  static String vowel = "aieou";
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    String s = br.readLine();
    for(int i=0; i<s.length(); i++){
      if(vowel.contains(s.charAt(i)+"")){
        sb.append(s.charAt(i));
        i+=2;
      }
      else sb.append(s.charAt(i));
    }
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }

}
