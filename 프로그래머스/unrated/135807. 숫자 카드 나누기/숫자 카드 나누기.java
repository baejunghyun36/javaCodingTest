
import java.util.*; 
class Solution {
    static int answer = 0; 
    static ArrayList<Integer> list; 
    public int solution(int[] arrayA, int[] arrayB) {
        
        Arrays.sort(arrayA); 
        Arrays.sort(arrayB); 
        
        list = new ArrayList<>(); 
        list.add(arrayA[0]); 
        
        func(arrayA, arrayB); 
        
        list = new ArrayList<>(); 
        list.add(arrayB[0]); 
        func(arrayB, arrayA); 
        
        return answer;
    }
    

    
    
    static void func(int []a, int []b){
        
        for(int i=list.get(0)/2; i>=2; i--){
            if(a[0]%i==0)list.add(i); 
        }
        for(int j=0; j<list.size(); j++){
            int x = list.get(j); 
            boolean flag = false; 
            for(int i=0; i<a.length; i++){
                if(a[i]%x!=0){
                    flag = true; 
                    break; 
                }
            }    
           if(flag==true){
                continue; 
            }
            for(int i=0; i<b.length; i++){
                if(b[i]%x==0){
                    flag = true; 
                    break; 
                }
            }
            if(flag==true){
                continue; 
            }
            answer = Math.max(answer, x); 
            return;             
        }
        
    
    }
    
    
    
}


    // while(x>=1){
    //         boolean flag = false; 
    //         for(int i=0; i<a.length; i++){
    //             if(a[i]%x!=0){
    //                 flag = true; 
    //                 break; 
    //             }
    //         }
    //         if(flag==true){
    //             x/=2; 
    //             continue; 
    //         }
    //         for(int i=0; i<b.length; i++){
    //             if(b[i]%x==0){
    //                 flag = true; 
    //                 break; 
    //             }
    //         }
    //         if(flag==true){
    //             x/=2; 
    //             continue; 
    //         }
    //         answer = Math.max(answer, x); 
    //         return; 
    //     }

