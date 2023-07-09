import java.io.*;
import java.util.*;

public class Main {

    static int n, m;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());


        List<String> backList = new LinkedList<>();
        List<String> frontList = new LinkedList<>();
        List<String> temp = new LinkedList<>();

        String cur = "init";

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        while(m-->0){

            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if (s.equals("B")) {
                if(backList.size()!=0){
                    frontList.add(0, cur);
                    cur = backList.remove(backList.size() - 1);
                }
            }
            else if (s.equals("F")) {
                if (frontList.size() != 0) {
                    backList.add(cur);
                    cur = frontList.remove(0);
                }
            }
            else if(s.equals("C")){
                if(backList.size()==0)continue;
                temp = new LinkedList<>();
                temp.add(backList.get(0));
                for (int i = 1; i < backList.size(); i++) {
                    if (!temp.get(temp.size() - 1).equals(backList.get(i))) {
                        temp.add(backList.get(i));
                    }
                }
                backList = temp;
            }
            else{
                String x = st.nextToken();
                frontList.clear();
                if(!cur.equals("init")) backList.add(cur);
                cur = x;
            }
        }

        sb.append(cur).append("\n");
        if(backList.size()==0) sb.append(-1);
        else for (int i = backList.size()-1; i >=0; i--) sb.append(backList.get(i)).append(" ");
        sb.append("\n");
        if (frontList.size() == 0)  sb.append(-1);
        else for (int i = 0; i < frontList.size(); i++) sb.append(frontList.get(i)).append(" ");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}