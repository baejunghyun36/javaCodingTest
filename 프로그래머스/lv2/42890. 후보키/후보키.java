import java.util.*; 
class Solution {
    static boolean []willUse; 
    static int col; 
    static String [][] db; 
    static int answer = 0; 
    static ArrayList<boolean[]> list; 
    public int solution(String[][] relation) {
        answer = 0;
        list = new ArrayList<>(); 
        
        col = relation[0].length; 
        db = relation; 
        willUse = new boolean [col]; 
        func(0, 0); 
      
        for(int i=0; i<list.size(); i++){
           // System.out.println(list); 
            boolean[] v = list.get(i); 
            boolean flag = false; 
            out:for(int j=0; j<list.size(); j++){
               if(i==j)continue; 
               boolean[] vv = list.get(j);
               int cnt = 0; 
               int t = 0; 
               for(int k=0; k<col; k++)if(vv[k]==true)cnt++; 
               for(int k=0; k<col; k++){
                   if(v[k]==true&&v[k]==vv[k]){
                      t++; 
                   }
               }
                if(t==cnt){
                    flag=true; 
                    break; 
                }
            } 
            if(flag==false)answer++; 
           
        }
        return answer;
    }
    
    static void func(int index, int cnt){
        
        if(index==col){
            Map<String, Integer> map = new HashMap<>(); 
            String ss = ""; 
            for(int i=0; i<db.length; i++){
                String s = ""; 
                for(int j=0; j<col; j++){
                    if(willUse[j]==true)s+=db[i][j]; 
                }
                if(map.get(s)==null){
                    map.put(s, 1); 
                }
                else return; 
            }
            boolean [] bb = new boolean [col];
            for(int i=0; i<col; i++){
                bb[i] = willUse[i]; 
            }
            list.add(bb); 
            return; 
        }        
        //사용할 때 
        willUse[index] = true; 
        func(index+1, cnt+1); 
        willUse[index] = false; 
        func(index+1, cnt); 
        return;    
    }
    
}