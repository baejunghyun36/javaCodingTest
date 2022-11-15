package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1027 {

    static int N; 
    static int answer; 
    static int [] building; 
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        N = Integer.parseInt(br.readLine()); 
        building = new int[N+1]; 
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        for(int i=1; i<=N; i++) building[i] = Integer.parseInt(st.nextToken()); 
        for(int i=1; i<=N; i++) {
            int sum = 0; 
            int l = i-1; 
            int r = i+1; 
            if(i==5)System.out.println(left(l, building[i], i));
            if(i==5)System.out.println(right(r, building[i], i));
            
            sum+=left(l, building[i], i); 
            sum+=right(r, building[i], i); 
            answer = Math.max(answer,  sum); 
        }

    //    System.out.println((double)(y-tempY)/(double)(x-tempX) );
        System.out.println(answer);
        
    }
    static int left(int l, int y, int x) {
        double c = Double.MAX_VALUE;  
        int cnt = 0 ; 
        for(int i = l; i>=1; i--) {
            double cc = 0;
            int tempY = building[i]; 
            int tempX = i; 
            cc = (double)(y-tempY)/(double)(x-tempX); 
            //System.out.println(cc);
            if(c>cc) {
                cnt++; 
                c = cc; 
            }
        }
        
        return cnt; 
    }
    static int right(int r, int y, int x) {
        double c = -Double.MAX_VALUE;  
        //System.out.println(c);
        int cnt = 0 ; 
        for(int i = r; i<=N; i++) {
            double cc = 0;
            int tempY = building[i]; 
            int tempX = i; 
            cc = (double)(y-tempY)/(double)(x-tempX); 
            if(c<cc) {
                if(x==5) {
                    //System.out.println(cc);
                }
                cnt++; 
                c = cc; 
            }
        }
        return cnt; 
    }
}
