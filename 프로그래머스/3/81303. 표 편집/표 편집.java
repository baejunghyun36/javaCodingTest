import java.util.*; 
class Solution {
    static Stack <Node> remove; 

    static int n, k; 
    static String [] cmd; 
    static Node cur; 
    static Node [] list; 
    public String solution(int nn, int kk, String[] c) {
        String answer = "";
        n = nn; 
        k = kk; 
        cmd = c; 
        list = new Node[n]; 
        remove = new Stack<>(); 
        for(int i=0; i<n; i++){
            list[i] = new Node(i); 
            if(i==n)cur = list[i]; 
        }
        list[0].next = list[1]; 
        list[n-1].prev = list[n-2]; 
        for(int i=1; i<n-1; i++){
            list[i].prev = list[i-1]; 
            list[i].next = list[i+1];
        }
        cur = list[k]; 
        
        cmdCall(); 
        char [] arr = new char[n]; 
        Arrays.fill(arr, 'O'); 
        while(!remove.isEmpty()){
            arr[remove.pop().number]='X'; 
        }
        StringBuilder sb = new StringBuilder(); 
        for(int i=0; i<n; i++){
            sb.append(arr[i]); 
            // answer+=arr[i]; 
        }
        return sb.toString();
    }

 
 
    static void cmdCall(){
        
        // cmd.length
        for(int i=0; i<cmd.length; i++){
         
            String s = cmd[i]; 
            if(s.charAt(0)=='D'){
                int move = Integer.parseInt(s.substring(2));
                while(move-->0)cur = cur.next; 
            }
            else if(s.charAt(0)=='U'){
                int move = Integer.parseInt(s.substring(2)); 
               while(move-->0)cur = cur.prev; 
            }
            else if(s.charAt(0)=='C'){
                // Node temp = new Node(cur.number); 
                // temp.prev = cur.prev; 
                // temp.next = cur.next; 
                remove.add(cur);
                
                if(cur.prev!=null&&cur.next==null){
                    cur.prev.next = null;
                    cur = cur.prev; 
                }
                else if(cur.prev==null&&cur.next!=null){
                    cur.next.prev = null; 
                    cur = cur.next; 
                }
                else if(cur.prev!=null&&cur.next!=null){
                    cur.prev.next = cur.next; 
                    cur.next.prev = cur.prev;
                    cur = cur.next;              
                }

         
            }
            else if(s.charAt(0)=='Z'){
                Node node = remove.pop(); 
                if(node.prev!=null) node.prev.next = node; 
                if(node.next!=null) node.next.prev = node; 
            }
        }
    }
    
    static class Node {
        int number; 
        Node prev; 
        Node next; 
        
        public Node (int number){
            this.number = number; 
        }
        
    }
    
}