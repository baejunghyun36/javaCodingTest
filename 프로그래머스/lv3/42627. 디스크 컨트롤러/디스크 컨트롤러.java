import java.util.*; 
class Solution {
    static PriorityQueue <Job> pq; 
    public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, (o1, o2) -> {
            if(o1[0]==o2[0])return o1[1] - o2[1]; 
            return o1[0]-o2[0]; 
        });
        pq = new PriorityQueue<>((o1, o2)->{
            return o1.workingTime - o2.workingTime; 
        }); 
        
        int finishTime = jobs[0][0] + jobs[0][1]; 
        int time = finishTime - jobs[0][0]; 
        int index = 1; 
        while(true){
            while(index<jobs.length){
                if(finishTime>=jobs[index][0]){
                    pq.add(new Job(jobs[index][0], jobs[index][1])); 
                    index++; 
                }
                else break; 
            }
            
            if(pq.isEmpty()){
               if(index==jobs.length)break; 
               finishTime = jobs[index][0] + jobs[index][1];
               time += finishTime - jobs[index][0]; 
               index++; 
            }
            else{
                Job job = pq.poll(); 
                finishTime += job.workingTime; 
                time+= finishTime - job.startTime; 
            }
        }
        return time/jobs.length;
    }
    
    static class Job  {
        
        int startTime; 
        int workingTime; 
        
        public Job (int st, int wt){
            this.startTime = st; 
            this.workingTime = wt; 
        }
        
      
        
    }
    

}