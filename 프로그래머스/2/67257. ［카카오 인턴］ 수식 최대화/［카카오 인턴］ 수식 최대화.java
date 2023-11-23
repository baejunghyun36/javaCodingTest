import java.util.*; 
class Solution {
    static ArrayList<Integer> numberList; 
    static ArrayList<Character> opList; 
    static String op = "-*+";
    static char [] prtOp; 
    static int [] visited; 
    static long answer; 
    public long solution(String expression) {
  
        prtOp = new char[3]; 
        visited = new int[3]; 
        int idx = 0; 
        
        numberList = new ArrayList<>(); 
        opList = new ArrayList<>(); 
        for(int i=0; i<expression.length(); i++){
            char ch = expression.charAt(i); 
            if(op.contains(ch+"")){
                numberList.add(Integer.parseInt(expression.substring(idx, i))); 
                opList.add(ch); 
                idx = i+1; 
            }
        }
        numberList.add(Integer.parseInt(expression.substring(idx))); 
        createSeq(0);

        return answer;
    }
    
    static void createSeq(int level){
        if(level==3) {
            
            ArrayList<Long> numberTemp = new ArrayList<>(); 
            ArrayList<Character> opTemp = new ArrayList<>(); 
            for(int i=0; i<numberList.size(); i++) numberTemp.add((long)numberList.get(i)); 
            for(int i=0; i<opList.size(); i++) opTemp.add(opList.get(i)); 
            for(int i=0; i<3; i++){
                char ch = prtOp[i]; 
                for(int j=0; j<opTemp.size(); j++){
                    if(opTemp.get(j)==ch){
                        if(ch=='+') numberTemp.set(j, numberTemp.get(j)+numberTemp.get(j+1)); 
                        if(ch=='-') numberTemp.set(j, numberTemp.get(j)-numberTemp.get(j+1)); 
                        if(ch=='*') numberTemp.set(j, numberTemp.get(j+1)*numberTemp.get(j)); 
                        // System.out.println(numberTemp.get(j)+ " " + numberTemp.get(j)+numberTemp.get(j+1)); 
                        numberTemp.remove(j+1); 
                        opTemp.remove(j); 
                        j--; 
                    }
                }
            }
            System.out.println(""); 
            answer = Math.max(answer, Math.abs(numberTemp.get(0))); 
            return; 
        }
        for(int i=0; i<3; i++){
            if(visited[i]==0){
                visited[i] = 1; 
                prtOp[level] = op.charAt(i);  
                createSeq(level+1); 
                visited[i] = 0; 
            }
        }
    }
}