import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<Clova> clovaList;
    static ArrayList<int[]> xList[];
    static ArrayList<int[]> yList[];
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
            xList[x].add(new int[]{y, i});
            yList[y].add(new int[]{x, i});
            clovaList.add(new Clova(y, x));
        }

        for(int i=0; i<200002; i++){
            Collections.sort(xList[i], (o1, o2)->o1[0]-o2[0]);
            Collections.sort(yList[i], (o1, o2)->o1[0]-o2[0]);
        }

        String dir = br.readLine();
        cur = new Clova(100000, 100000);

        for(int i=0; i<dir.length(); i++){
            char d = dir.charAt(i);
            int index = 0;
            if(d=='U') cur.y = xList[cur.x].get(binarySearch(cur.y, xList[cur.x])+1)[0];
            else if(d=='D') cur.y = xList[cur.x].get(binarySearch(cur.y, xList[cur.x])-1)[0];
            else if(d=='L') cur.x = yList[cur.y].get(binarySearch(cur.x, yList[cur.y])-1)[0];            
            else cur.x = yList[cur.y].get(binarySearch(cur.x, yList[cur.y])+1)[0];
            
        }
        sb.append((cur.x-100000)+" "+(cur.y-100000));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static int binarySearch (int value, ArrayList<int[]> list){

        int l = 0;
        int h = list.size()-1;
        while(l<=h){
            int mid = (l+h)/2;
            if(list.get(mid)[0]==value) return mid;            
            else if(list.get(mid)[0]>value)  h = mid-1;            
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