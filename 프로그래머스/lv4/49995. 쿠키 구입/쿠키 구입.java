import java.util.*; 
class Solution {
    static int [] sum; 
    static int maxValue = 0; 
    static int n; 
    public int solution(int[] cookie) {
        int answer = -1;
        n = cookie.length; 
        accumulatedSumInit(cookie); 
        for(int m = 1; m<=n-1; m++){
            
            for(int j=1; j<=m; j++){
                int leftSum = sum[m] - sum[j-1]; 
               // System.out.println(leftSum+ " " + j + " ~ " + m ); 
                if(maxValue>leftSum)break; 
                if(binarySearch(m+1, n, leftSum, m)){
                    maxValue = leftSum;    
                } 
            }
        }
        answer = maxValue; 
        return answer;
    }
    static boolean binarySearch(int l, int r, int leftSum, int m){
        
        while(l<=r){
            int mid = (l+r)/2;
            int tempSum = sum[mid] - sum[m]; 
            if(tempSum==leftSum)return true; 
            if(tempSum>leftSum)r = mid-1; 
            
            else l = mid+1; 
            
        }
        return false; 
    }
  
    
    static void accumulatedSumInit(int [] cookie){
        sum = new int[cookie.length+1];
        for(int i=1; i<=cookie.length; i++){
            sum[i] = sum[i-1] + cookie[i-1]; 
        }
    }
}