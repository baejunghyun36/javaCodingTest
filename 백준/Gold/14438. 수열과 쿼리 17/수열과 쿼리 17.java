import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int [] segementTree;
    static int [] info;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        segementTree = new int[n * 4];
        info = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            info[i] = Integer.parseInt(st.nextToken());
        }
        m = Integer.parseInt(br.readLine());
        initSegement(1, 1, n);
        info[0] = 1987654321;
        segementTree[0] = info[0];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int check = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(check==2){
                sb.append(info[find(a, b, 1, 1, n)]).append("\n");
            }
            else{
                update(a, b, 1, n, 1);
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static int initSegement(int index, int start, int end){
        if(start==end) return segementTree[index] = start;
        int leftIndex = initSegement(index * 2, start, (start + end) / 2);
        int rightIndex = initSegement(index * 2 + 1, (start + end) / 2 + 1, end);
        if(info[leftIndex]<=info[rightIndex])return segementTree[index] = leftIndex;
        else return segementTree[index] = rightIndex;
    }

    static int find(int rangeS, int rangeE, int index, int l, int r){

        if(r<rangeS||l>rangeE) return 0;
        if (rangeS<=l&&r<=rangeE) {
            return segementTree[index];
        }
        int leftIndex = find(rangeS, rangeE, index * 2, l, (l + r) / 2);
        int rightIndex = find(rangeS, rangeE, index * 2 + 1, (l + r) / 2 + 1, r);
        if(info[leftIndex]<=info[rightIndex])return leftIndex;
        else return rightIndex;
    }

    static int update(int a, int b, int s, int e, int index){

        if(s>a||e<a) return segementTree[index];
        if(s==e&&a==s){
            info[a] = b;
            segementTree[index] = a;
            return a;
        }
        int leftIndex = update(a, b, s, (s+e)/2, index*2);
        int rightIndex = update(a, b, (s + e) / 2 + 1, e,  index * 2 + 1);
        if(info[leftIndex]<=info[rightIndex])return segementTree[index] = leftIndex;
        else return segementTree[index] = rightIndex;
    }
}