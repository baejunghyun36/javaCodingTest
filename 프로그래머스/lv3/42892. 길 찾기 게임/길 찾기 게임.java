
import java.util.*; 
class Solution {
    
    static Set<Integer> set = new HashSet<>(); 
    static Node [] list; 
    static ArrayList<Integer> height; 
    static PriorityQueue<Node> inorderQueue; 
    static int [] inorderArray; 
    static ArrayList<Integer> post;
    static ArrayList<Integer> pre; 
    public int[][] solution(int[][] nodeinfo) {
        
        int[][] answer = new int [2][nodeinfo.length]; 
        post = new ArrayList<>(); 
        pre = new ArrayList<>(); 
        inorderArray = new int [nodeinfo.length]; 
        list = new Node[nodeinfo.length+1]; 
        set = new HashSet<>(); 
        inorderQueue = new PriorityQueue<>((o1, o2)-> o1.x - o2.x); 
        for(int i=0; i<nodeinfo.length; i++){
            list[i+1] = new Node(i+1, nodeinfo[i][1], nodeinfo[i][0]); 
            inorderQueue.add(list[i+1]); 
            set.add(nodeinfo[i][1]); 
        }
        
        height = new ArrayList<>(); 
        for(int x : set){
            height.add(x); 
        }
        Collections.sort(height, (o1, o2)-> o2-o1); 
        initInorder(); 
        dfs(0, nodeinfo.length-1, 0); 
        for(int i=0; i<pre.size(); i++){
            answer[0][i] = pre.get(i); 
            answer[1][i] = post.get(i); 
        }
        
        return answer;
    }
    static void dfs(int s, int e, int indexH){
        if(e<s)return; 
        int h = height.get(indexH); 
        int mid = 0; 
        int number = 0; 
        for(int i=s; i<=e; i++){
            number = inorderArray[i]; 
            if(list[number].y == h){
                mid = i; 
                pre.add(number); 
                break; 
            }
        }

        dfs(s, mid-1, indexH+1); 
        dfs(mid+1, e, indexH+1); 
        post.add(number); 
    }
    
    static void initInorder(){
        
        int index = 0; 
        while(!inorderQueue.isEmpty()){
            inorderArray[index++] = inorderQueue.poll().number; 
        }
        System.out.println(Arrays.toString(inorderArray)); 
        
        
    }
    static class Node {
        int number; 
        int y; 
        int x; 
        
        public Node(int number, int y, int x){
            this.number = number; 
            this.y = y; 
            this.x = x; 
        }
        
    }
}