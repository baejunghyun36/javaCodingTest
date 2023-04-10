import java.util.*;
class Solution {
    static int playTime, advTime; 
    static int sum [] ; 

    public String solution(String play_time, String adv_time, String[] logs) {
        sum = new int[360001]; 
        String [] t = play_time.split(":"); 
        int h = Integer.parseInt(t[0]); 
        int m = Integer.parseInt(t[1]); 
        int s = Integer.parseInt(t[2]); 
        playTime = cal(h, m, s);
        String[] temp = adv_time.split(":"); 
        h = Integer.parseInt(temp[0]); 
        m = Integer.parseInt(temp[1]); 
        s = Integer.parseInt(temp[2]); 
   
        advTime = cal(h, m, s); 

        for(int i=0; i<logs.length; i++){
            String[] startEnd = logs[i].split("-"); 
            String[] start = startEnd[0].split(":"); 
            String[] end = startEnd[1].split(":"); 
            int sh = Integer.parseInt(start[0]); 
            int sm = Integer.parseInt(start[1]); 
            int ss = Integer.parseInt(start[2]); 
            
            int eh = Integer.parseInt(end[0]); 
            int em = Integer.parseInt(end[1]); 
            int es = Integer.parseInt(end[2]);   
            int si =  cal(sh, sm, ss); 
            int ei = cal(eh, em, es); 
            sum[si] +=1; 
            sum[ei] -=1; 
        }

        int start = 0; 
        int end = advTime - 1; 
        long answer = 0; 
        for(int i=1; i<sum.length; i++)sum[i]+=sum[i-1]; 
        for(int i=0; i<=end; i++){
           answer+=sum[i];  
        }
        int second = 0;
        long tmp = answer; 
        while(end < playTime){
            tmp += sum[++end];
            tmp -= sum[start++]; 
            
            if(answer < tmp){
                answer = tmp; 
                second = start; 
            }
        }

        return stringTime(second); 
    }
    
    static String stringTime(int x){
        int hh = x/3600; 
        x = x%3600; 
        int mm = x/60; 
        x = x%60; 
        int ss = x; 
        String h= String.valueOf(hh); 
        String m = String.valueOf(mm); 
        String s = String.valueOf(ss); 
        if(h.length()==1)h = "0"+h; 
        if(m.length()==1)m = "0"+m; 
        if(s.length()==1)s = "0"+s; 
        return h+":"+m+":"+s; 
    }
    

    
    static int cal(int h, int m, int s){
        return s+m*60+h*3600; 
    }
}