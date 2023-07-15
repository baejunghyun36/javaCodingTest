class Solution {
    String s = "aieou"; 
    public String solution(String my_string) {
        String answer = "";
        for(int i=0; i<my_string.length(); i++){
            char c = my_string.charAt(i); 
            if(!s.contains(c+""))answer+=c; 
        }
        return answer;
    }
}