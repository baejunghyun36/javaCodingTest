import java.util.*; 
class Solution {
    static Queue <int []> q; 
    static ArrayList<Integer> yList; 
    public double[] solution(int k, int[][] ranges) {
        
        ArrayList<Double> answerList = new ArrayList<>(); 
        int cnt = 0; 
        yList = new ArrayList<>(); 
        while(k!=1){
            yList.add(k); 
            if(k%2==0) k/=2; 
            else k = k*3+1;      
            cnt++; 
        }
        yList.add(1); 
        for(int i=0; i<ranges.length; i++){
            int start = ranges[i][0]; 
            int end = ranges[i][1]; 
            if(end<=0) end = yList.size()-1+ranges[i][1]; 
            if(start>end) answerList.add(-1.0); 
            else{
                int prevY = yList.get(start); 
                double area = 0; 
                for(int x = start+1; x<=end; x++){
                    int y = yList.get(x); 
                    area += Math.min(y, prevY); 
                    area += (Math.max(y, prevY) - Math.min(y, prevY))/2.0; 
                    prevY = y; 
                }
                answerList.add(area); 
            }
        }
        
        double []answer = new double[answerList.size()]; 
        for(int i=0; i<answerList.size(); i++) answer[i] = answerList.get(i); 
        return answer;
    }
    

}