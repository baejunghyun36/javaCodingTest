import java.util.*; 
class Solution {
    static int [][] key; 
    static int [][] lock; 
    static int m, n; 
    static int vacantSpace; 
    public boolean solution(int[][] k, int[][] l) {
        boolean answer = true;
         
        key = k; 
        lock = l; 
        
        m = k.length; 
        n = lock.length; 
        
        lock = new int[n+m*2-2][n+m*2-2]; 
        for(int i=m-1; i<m-1+n; i++){
            for(int j=m-1; j<m-1+n; j++){
                lock[i][j] = l[i-m+1][j-m+1]; 
                if(lock[i][j]==0){
                    lock[i][j] = 1234567; 
                    vacantSpace++; 
                }
            }
        }
        
        // n = lock.length; 
        n = lock.length; 

        
        for(int i=0; i<4; i++){
           if(check())return true;  
            rotate(); 
        }
        
        return false;
    }
    
    
    static void rotate(){
        
        int [][] temp = new int [m][m]; 
        for(int i=0; i<m; i++){
            for(int j=m-1; j>=0; j--){
                temp[i][m-1-j] = key[j][i]; 
            }
        }
        key = temp; 
    }
    
    static boolean check(){
        //m은 키 길이
        //n은 자물쇠 길이
        
        for(int i=0; i<n-m+1; i++){
            for(int j=0; j<n-m+1; j++){
                int cnt = 0; 
                out:for(int k=i; k<i+m; k++){
                    for(int l=j; l<j+m; l++){
                        if(lock[k][l]==1&&key[k-i][l-j]==1)break out; 
                        if(lock[k][l]==1234567&&key[k-i][l-j]==1)cnt++;  
                    }
                }
                if(cnt==vacantSpace){
     
                    return true; 
                }
            }
        }
        return false; 
    }
    
}