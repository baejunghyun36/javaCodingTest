import java.util.*; 
class Solution {
    
    static Map<String, ArrayList<Integer>> map;  
    static int check = 0;
    static String [][] type = {
        {"cpp", "java", "python"},
        {"backend", "frontend"},
        {"junior", "senior"}, 
        {"chicken", "pizza"}
                         };
    public int[] solution(String[] info, String[] query) {
        int[] answer = {};
        //info = 50000
        //query = 100000
        // 언어3, 직군2, 경력 2, 푸드 2 -> 총 9가지. 
        
        answer = new int [query.length]; 
        map = new HashMap<>(); 
        String [] tmp = new String [info.length]; 
        int index =0 ; 
        for(int i=0; i<info.length; i++){
            String s = info[i]; 
            
            StringTokenizer st = new StringTokenizer(s); 
            String str = ""; 
            for(int j=0; j<4; j++){
                str += st.nextToken(); 
            }
            int score = Integer.parseInt(st.nextToken()); 
            tmp[index++] = str; 
            ArrayList<Integer> list = map.get(str); 
            if(list==null)list = new ArrayList<>(); 
            list.add(score); 
            map.put(str, list); 
        }
        for(String s : map.keySet()){
            ArrayList<Integer> t = map.get(s); 
            Collections.sort(t); 
            map.put(s, t); 
        }
        
        index = 0; 
        for(String s : query){
            StringTokenizer st = new StringTokenizer(s); 
            String [] str = new String [5]; 
            int i = 0; 
            check = 0; 
            while(st.hasMoreTokens()){
                String ss = st.nextToken();
                if(ss.equals("and"))continue; 
                str[i++] = ss; 
            }
            int value = Integer.parseInt(str[4]); 
            // System.out.println("value : " + value); 
            dfs(str, "", value, 0); 
            // System.out.println();             
            answer[index++] = check; 
        }
        
        
        return answer;
    }
    static void dfs(String [] str, String s , int value, int index){
        if(index==4){
            ArrayList<Integer> arr = map.get(s); 
            if(arr==null)return; 
            // System.out.println(arr); 
            int l = 0; 
            int r = arr.size()-1; 
            int record = arr.size(); 
            while(l<=r){
                int mid = (l+r)/2; 
                int cmp = arr.get(mid); 
                if(cmp>=value){
                    record = mid; 
                    r = mid-1;
                }
                else {
                    l = mid+1;  
                }
            }
            // System.out.println(arr.size()-record); 
            check += arr.size()-record; 
            return;  
        }
        if(str[index].equals("-")){
            String [] ss =  type[index]; 
            for(int i=0; i<ss.length; i++){
                dfs(str, s+ss[i], value, index+1); 
            }
        }
        else {
              dfs(str, s+str[index], value, index+1); 
        }
        
    }
    


}
