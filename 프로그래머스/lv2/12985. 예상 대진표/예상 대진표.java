import java.util.*; 
class Solution
{
    static Queue<Integer> q; 
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        q = new LinkedList<>(); 
        
        for(int i=0; i<n; i++){
            q.add(i+1); 
        }
        
        int round = 1; 
        out:while(q.size()>1){
            int size = q.size()/2; 
            while(size-->0){
                //System.out.println(size); 
                int aa = q.poll(); 
                int bb = q.poll(); 
           
                if(aa==a&&bb==b||aa==b&&bb==a)break out; 
                if(aa==a||bb==a)q.add(a); 
                else if(bb==b||aa==b)q.add(b); 
                else q.add(aa);   
            }                
            round++; 

        }

        return round;
    }
}