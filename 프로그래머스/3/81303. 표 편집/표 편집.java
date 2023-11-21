import java.util.*; 
class Solution {
    
    static Node cur; 
    static Node [] list; 
    static int [] numberOfNode; 
    static Node prev; 
    static Stack <Node> stack; 
    public String solution(int n, int k, String[] cmd) {
        StringBuilder sb = new StringBuilder(); 
        numberOfNode = new int[n];
        stack = new Stack<>(); 
        list = new Node[n];
        for(int i=0; i<n; i++){
            list[i] = new Node(i); 
        }
        list[0].right = list[1];  
        for(int i=1; i<n-1; i++){
            list[i].left = list[i-1]; 
            list[i].right = list[i+1]; 
        }
        list[n-1].left = list[n-2]; 
        cur = list[0]; 
        for(int i=0; i<k; i++) cur = cur.right; 
        for(int i=0; i<cmd.length; i++){
            String [] c = cmd[i].split(" "); 
            // System.out.println(cur.number+" "+c[0]); 
            if(c[0].equals("D")){
                int value = Integer.parseInt(c[1]); 
                down(value); 
            }
            else if(c[0].equals("C")){
                remove(); 
            }
            else if(c[0].equals("U")){
                int value = Integer.parseInt(c[1]); 
                up(value); 
                
            }
            else if(c[0].equals("Z")){
                rollback(); 
            }
        }
        while(!stack.isEmpty()){
            Node temp = stack.pop(); 
            numberOfNode[temp.number] = 1; 
        }
   
        for(int i=0; i<n; i++){
            if(numberOfNode[i]==1) sb.append('X'); 
            else sb.append('O'); 
        }
        return sb.toString();
    }
    static void up(int offset){
        for(int i=0; i<offset; i++){
            if(cur.left!=null) cur = cur.left; 
        }
    }
    static void down(int offset){
        for(int i=0; i<offset; i++){
            if(cur.right!=null) cur = cur.right; 
        }
    }
    
    static void remove(){
        // prev = cur; 
        stack.add(cur); 
        
        Node left = cur.left; 
        Node right = cur.right; 
        
        if(left==null) {
            right.left = null; 
            cur = right; 
        }
        else if(right == null){
            left.right = null; 
            cur = left; 
        }
        else {
            left.right = right; 
            right.left = left; 
            cur = right; 
        }
    }
    static void rollback(){
      
        Node node = stack.pop(); 
        Node left = node.left; 
        Node right = node.right; 
        if(left!=null)left.right = node; 
        if(right!=null) right.left = node; 
    }
    
    static class Node {
        
        int number; 
        Node left; 
        Node right; 
        public Node (int number){
            this.number = number; 
        }
        
    }
}