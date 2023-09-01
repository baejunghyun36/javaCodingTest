import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Integer> dynamicList;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        dynamicList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(dynamicList.size()==0)dynamicList.add(num);
            else binarySearchUsingDynamicList(num);
        }
        sb.append(n - dynamicList.size());
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }


    static void binarySearchUsingDynamicList(int num){

        int l = 0;
        int h = dynamicList.size()-1;
        while (l <= h) {
            int mid = (l+h)/2;
            int midNumber = dynamicList.get(mid);
            if(midNumber<num) l = mid+1;
            else if(midNumber>num) h = mid-1;
        }
        if(l==-1) dynamicList.set(0, num);
        else if(l== dynamicList.size()) dynamicList.add(num);
        else dynamicList.set(l, num);
    }
}