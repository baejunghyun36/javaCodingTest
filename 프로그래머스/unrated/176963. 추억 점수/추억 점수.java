import java.util.*; 
class Solution {
    static Map <String, Integer> map; 
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int [photo.length];
        map = new HashMap<>(); 
        for(int i=0; i<name.length; i++){
            map.put(name[i], yearning[i]); 
        }
        
        for(int i = 0; i<photo.length; i++){
            int sum = 0; 
            for(int j=0; j<photo[i].length; j++){
                if(map.get(photo[i][j])!=null)sum+=map.get(photo[i][j]); 
            }
            answer[i] = sum; 
        }
        
        return answer;
    }
}