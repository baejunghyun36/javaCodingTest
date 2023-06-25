import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    static int n, m;
    static int [] dp;
    static Map<Integer, ArrayList<Ingredient>> map;
    static ArrayList<Ingredient> list [];
    static int [] arr, parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        dp = new int[n+1];
        list = new ArrayList [n+1];
        arr = new int[n+1];
        parent = new int[n+1];


        for(int i=0; i<=n; i++) list[i] = new ArrayList<>();
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            list[x].add(new Ingredient(y, k));
            parent[y]++;
        }

        ingredientCount();

        for(int i=1; i<=n; i++) if(list[i].size()==0) sb.append(i).append(" ").append(arr[i]).append("\n");


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void ingredientCount (){

        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        arr[n] = 1;

        while(!q.isEmpty()){
            int curNumber = q.poll();
            for(int i=0; i<list[curNumber].size(); i++){
                Ingredient next = list[curNumber].get(i);
                arr[next.number] += arr[curNumber] * next.count;
                parent[next.number]--;
                if(parent[next.number]==0)q.add(next.number);
            }
        }
    }

    static class Ingredient {

        int number;
        int count;

        public Ingredient (int number, int count){
            this.number = number;
            this.count = count;
        }

    }


}