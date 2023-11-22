import java.util.*; 
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
   
        ArrayList<Integer> list = new ArrayList<>(); 
        Map <String, Integer> monthOfType = new HashMap<>(); 
        for(String s : terms){
            String []term = s.split(" "); 
            monthOfType.put(term[0], Integer.parseInt(term[1])); 
        }
        StringTokenizer st = new StringTokenizer(today, "."); 
        int ty = Integer.parseInt(st.nextToken()); 
        int tm = Integer.parseInt(st.nextToken()); 
        int td = Integer.parseInt(st.nextToken()); 
        for(int i=0; i<privacies.length; i++){
            String [] info = privacies[i].split(" "); 
            st = new StringTokenizer(info[0], "."); 
            int y = Integer.parseInt(st.nextToken()); 
            int m = Integer.parseInt(st.nextToken()); 
            int d = Integer.parseInt(st.nextToken()); 
            String type = info[1]; 
      
            y += monthOfType.get(type)/12; 
            m+= monthOfType.get(type)%12; 
            if(m>=13) {
                y++; 
                m = m - 12; 
            }
            d-=1; 
            if(d<1){
                m--; 
                d = 28;
                if(m==0) m= 12; 
            }
            if(ty>y)list.add(i+1); 
            else if(ty==y&&tm>m) list.add(i+1);  
            else if(ty==y&&tm==m&&td>d)list.add(i+1);  
        }
        Collections.sort(list); 
        int [] answer = new int [list.size()]; 
        for(int i=0; i<answer.length; i++){
            answer[i] = list.get(i); 
        }
        
        return answer;
    }
}