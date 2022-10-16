package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_15961 {
	
    static int n, d, k, c;
    static int[] arr, visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        visited = new int[d + 1];
        System.out.println(function());
    }

    static int function() {
       
        int slide = 0; 
        int chance;
     
        for (int i = 0; i < k; i++) {
            if (visited[arr[i]] == 0) slide++;            
            visited[arr[i]]++;
        }
        
        chance = slide;
        for (int i = 1; i < n; i++) {
        
            if (chance <= slide) {
                if (visited[c] == 0) chance = slide + 1;
                else chance = slide;                
            }
            visited[arr[i - 1]]--;
            if (visited[arr[i - 1]] == 0) slide--;
            if (visited[arr[(i + k - 1) % n]] == 0) slide++;
            
            visited[arr[(i + k - 1) % n]]++;
        }
        return chance;
    }
}