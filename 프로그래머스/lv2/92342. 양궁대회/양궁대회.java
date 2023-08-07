import java.util.*; 
class Solution {
    static int [] lion; 
    static int n; 
    static int maxScore=-1;
    static int [] minScore; 
    static int [] answer;
    static int apeechScore; 
    static int [] apeech; 
    public int[] solution(int nn, int[] info1) {
 
        //첫번째 제일 낮은 과녁 점수, 두번째는 제일 낮은 과녁 점수 개수.  
        minScore = new int[2]; 
        apeech = info1; 
        n = nn; 
        lion = new int[11]; 
        // permutation(0); 
        answer = new int[11]; 
        dfs(n, 0); 
        
        if(maxScore==-1)return new int []{-1}; 
        else{ 
            return answer;
        }
    }
    
    static void dfs(int cnt, int index){
        
        
        if(index==11||cnt==0){
            // System.out.println(cnt+" "+ index); 
          
            if(cnt!=0)lion[10]+=cnt; 
            int aSum = 0; 
            int lSum = 0; 
            
            for(int i=0; i<=10; i++){
                if(apeech[i]==lion[i]||i==10)continue; 
                if(apeech[i]<lion[i]){
                    lSum+=10-i; 
                }
                else{
                    aSum+=10-i;                     
                }
            }
            if(lSum>aSum){
                if(maxScore<=lSum-aSum){
                   
                    if(maxScore==lSum-aSum){
                        for(int i=10; i>=0; i--){
                            if(answer[i]<lion[i]){
                                answer = lion.clone(); 
                                break;
                            }
                            else if(answer[i]>lion[i])break ;
                        }   
                    }
                    else answer = lion.clone(); 
                    maxScore = lSum-aSum; 
                }
            }
            if(cnt!=0)lion[10]-=cnt; 
            return; 
        }

        
        if(cnt>apeech[index]){
            lion[index] = apeech[index]+1; 
            dfs(cnt-(lion[index]), index+1);
            lion[index] = 0; 
        }
        
        dfs(cnt, index+1); 

    }
}