import java.util.*; 
class Solution {
    static Map <String, Character> map; 
    public int solution(String s) {
        String answer = "";
        int start = 0; 
        boolean flag = false; 
        StringBuilder sb = new StringBuilder(); 
        init(); 
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                if(flag == true){
                    sb.append(map.get(s.substring(start, i))); 
                }
                flag  = false; 
                sb.append(s.charAt(i)); 
            }
            else{
                if(flag == false){
                    start = i; 
                    flag = true; 
                }    

                else if(map.getOrDefault(s.substring(start, i+1), '*')!='*'){
                    sb.append(map.get(s.substring(start, i+1))); 
                    flag = false; 
                }
            }

        }
        
    
        return Integer.parseInt(sb.toString()); 
    }
    static void init(){
        map = new HashMap<>(); 
        map.put("zero", '0'); 
        map.put("one", '1'); 
        map.put("two", '2'); 
        map.put("three", '3'); 
        map.put("four", '4'); 
        map.put("five", '5'); 
        map.put("six", '6'); 
        map.put("seven", '7'); 
        map.put("eight", '8'); 
        map.put("nine", '9'); 
        
    }
}