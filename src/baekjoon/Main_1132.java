//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.util.HashMap;
//import java.util.Map;
//
//public class Main_1132 {
//
//  static int N;
//  static String[] info;
//  static long [] alpa;
//  static Map<Character, Long> map;
//  public static void main(String[] args) throws IOException {
//
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//    StringBuilder sb = new StringBuilder();
//
//    N = Integer.parseInt(br.readLine());
//    info = new String[N];
//    alpa = new long[10];
//    map = new HashMap<>();
//    for(int i=0; i<N; i++){
//      info[i] = br.readLine();
//      for(int j=0; j<info[i].length(); j++){
//        long location = 1;
//        for(int k=0; k<info[i].length()-j-1; k++){
//          location*=10;
//        }
//        map.put(info[i].charAt(j), map.getOrDefault(info[i].charAt(j), 0L)+location);
//      }
//    }
//    for (long x : map.keySet()) {
//      System.out.println(x);
//    }
//
//    bw.write(sb.toString());
//    bw.flush();
//    bw.close();
//    br.close();
//  }
//
//}
