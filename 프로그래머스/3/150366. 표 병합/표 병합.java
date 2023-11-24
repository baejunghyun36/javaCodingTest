import java.util.*; 
class Solution {

    static int r1, c1, r2, c2; 
    static int [] parent; 
    static String [] str; 
    String v1, v2; 
    public String[] solution(String[] commands) {
        String[] answer = {};
        ArrayList<String> list = new ArrayList<>(); 
        parent = new int[2501];
        str = new String[2501]; 
        for(int i=0; i<=2500; i++) {
            parent[i] = i; 
            str[i] = ""; 
        }
        for(String cmd : commands){
            String [] s = cmd.split(" ");  
            if(s[0].equals("PRINT")){
                r1 = Integer.parseInt(s[1])-1; 
                c1 = Integer.parseInt(s[2])-1; 
                String ss = str[toIndex(r1, c1)]; 
                if(ss.equals("")) list.add("EMPTY"); 
                else list.add(ss); 
            }
            else if(s[0].equals("UNMERGE")){
                r1 = Integer.parseInt(s[1])-1; 
                c1 = Integer.parseInt(s[2])-1; 
                String ss = str[toIndex(r1, c1)]; 
                int root = find(toIndex(r1, c1)); 
                for(int i=0; i<=2500; i++){
                    if(find(i)==root){
                        parent[i] = i; 
                        str[i] = ""; 
                    }
                }
                str[toIndex(r1, c1)] = ss;  
            }
            
            else if(s[0].equals("MERGE")){
                r1 = Integer.parseInt(s[1])-1; 
                c1 = Integer.parseInt(s[2])-1; 
                
                r2 = Integer.parseInt(s[3])-1; 
                c2 = Integer.parseInt(s[4])-1; 
                // if(r1==r2&&c1==c2) continue; 
                
                union(toIndex(r1, c1), toIndex(r2, c2)); 
                int root = find(toIndex(r1, c1)); 
                String temp = ""; 
                if(!str[toIndex(r1, c1)].equals("")) temp = str[toIndex(r1, c1)]; 
                else temp = str[toIndex(r2, c2)]; 
                for(int i=0; i<=2500; i++){
                    if(root== find(i)){
                        str[i] = temp; 
                    }
                }
                
            }        
            else if(s[0].equals("UPDATE")){
                if(s.length==3){
                    v1 = s[1]; 
                    v2 = s[2]; 
                    update(v1, v2); 
                }
                else{
                    r1 = Integer.parseInt(s[1])-1; 
                    c1 = Integer.parseInt(s[2])-1;  
                    v1 = s[3];  
                    update(r1, c1, v1); 
                }
            }
            
                //             for(int i=0; i<4; i++){
                //     for(int j=0; j<4; j++){
                //         if(str[toIndex(i, j)]=="") System.out.print("        "); 
                //         else  System.out.print(str[toIndex(i, j)]+"  "); 
                //     }
                //     System.out.println(); 
                // }
                //  System.out.println(); 
        }
        answer = new String[list.size()]; 
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i); 
        }

        
        return answer;
    }
    
    static int find (int a){
        if(parent[a]==a) return a; 
        return parent[a] = find(parent[a]); 
    }
    
    static void union(int a, int b){
        
        int pa = find(a); 
        int pb = find(b); 
        
        if(pa<=pb) {
            parent[pb] = pa;
        }
        else {
            parent[pa] = pb; 
       
        }
    }

    static void update(int r, int c, String v){
        
        int root = find(toIndex(r, c)); 
    
        for(int i=0; i<=2500; i++){
            if(find(i)==root){
               str[i]  = v; 
            }
        }
    }
    
    static void update(String v1, String v2){
        for(int i=0; i<=2500; i++){
            if(str[i].equals(v1)) str[i] = v2; 
        }
    }
    
    static int toIndex(int r, int c){
        return r*50 + c; 
    }
}