import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<Clova> clovaList;
    static ArrayList<Integer> xList[];
    static ArrayList<Integer> yList[];
    static Clova cur;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        clovaList = new ArrayList<>();
        xList = new ArrayList[200002];
        yList = new ArrayList[200002];

        for(int i=0; i<200002; i++){
            xList[i] = new ArrayList<>();
            yList[i] = new ArrayList<>();
        }

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())+100000;
            int y = Integer.parseInt(st.nextToken())+100000;
            xList[x].add(y);
            yList[y].add(x);
        }

        for(int i=0; i<200002; i++){
            Collections.sort(xList[i]);
            Collections.sort(yList[i]);
        }

        String dir = br.readLine();
        cur = new Clova(100000, 100000);

        for(int i=0; i<dir.length(); i++){
            char d = dir.charAt(i);
            if(d=='U') cur.y = xList[cur.x].get(binarySearch(cur.y, xList[cur.x])+1);
            else if(d=='D') cur.y = xList[cur.x].get(binarySearch(cur.y, xList[cur.x])-1);
            else if(d=='L') cur.x = yList[cur.y].get(binarySearch(cur.x, yList[cur.y])-1);
            else cur.x = yList[cur.y].get(binarySearch(cur.x, yList[cur.y])+1);
        }
        sb.append((cur.x-100000)+" "+(cur.y-100000));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static int binarySearch (int value, ArrayList<Integer> list){

        int l = 0;
        int h = list.size()-1;
        while(l<=h){
            int mid = (l+h)/2;
            if(list.get(mid)==value) return mid;
            else if(list.get(mid)>value)  h = mid-1;
            else l = mid+1;
        }
        return 1;
    }

    static class Clova {
        int y;
        int x;

        public Clova(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}