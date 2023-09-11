class Solution
{
    public int solution(String s)
    {
        int answer = 1;
        int n = s.length(); 

        //odd
        for(int mid=1; mid<s.length()-1; mid++){
            int cnt = 0; 
            int start= mid-1; 
            int end = mid +1; 
            while(start>=0&&end<n&&s.charAt(start)==s.charAt(end)){
                cnt++; 
                start--; 
                end++; 
            }
            answer = Math.max(cnt*2+1, answer); 
        }
        //even 
        for(int i=0; i<n-1; i++){
            int start = i; 
            int end = i+1;
            int cnt = 0; 
            while(start>=0&&end<n&&s.charAt(start)==s.charAt(end)){
                cnt ++; 
                start--; 
                end++; 
            }
            answer = Math.max(answer, cnt*2); 
        }
        

        return answer;
    }
}