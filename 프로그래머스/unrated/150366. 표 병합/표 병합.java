import java.util.*; 
class Solution {
    static String [][] map; 
    static Map<String, int[]> coordinatesOfString; 
    static ArrayList<String> answer; 
    static Map<Integer, Set<Integer>> group; 
    static int [] parent; 
    static int n; 
    static String [] parentString; 
    public String[] solution(String[] commands) {
        // String[] answer = {};
        //2시 시작 
        group = new HashMap<>(); 
        parentString = new String [2502]; 
        Arrays.fill(parentString, ""); 
        answer = new ArrayList<>(); 
        map = new String [52][52]; 
        coordinatesOfString = new HashMap<>(); 
        parent = new int [52*52]; 
        initParent(); 
        for(String cmd : commands){
            StringTokenizer st = new StringTokenizer(cmd); 
            String method = st.nextToken(); 
            String r1 = st.nextToken(); 
            String c1 = st.nextToken(); 
            if(method.equals("UPDATE")){
                String value = ""; 
                if(st.hasMoreTokens()) value = st.nextToken(); 
                if(!value.equals(""))updateToValue(Integer.parseInt(r1), Integer.parseInt(c1), value); 
                else updateToString(r1, c1); 
            }
            else if(method.equals("MERGE")){
                int r2 = Integer.parseInt(st.nextToken()); 
                int c2 = Integer.parseInt(st.nextToken()); 
                merge(Integer.parseInt(r1), Integer.parseInt(c1), r2, c2); 
            }
            else if(method.equals("UNMERGE")){
                unmerge(Integer.parseInt(r1), Integer.parseInt(c1)); 
            }
            else {
                print(Integer.parseInt(r1), Integer.parseInt(c1)); 
            }
        }
        String [] ans = new String [answer.size()]; 
        for(int i=0; i<answer.size(); i++) ans[i] = answer.get(i); 
        return ans;
    }
    static void initParent(){
        for(int i=1; i<=51*51; i++)parent[i] = i; 
    }
    static int find(int num){
        if(parent[num]==num) return num;
        return parent[num] = find(parent[num]); 
    }
    
    static void union(int a, int b){
        int parentA = find(a); 
        int parentB = find(b); 
        if(parentA!=parentB)parent[parentB] = a; 
        find(a); 
        find(b); 
        
    }
    
    static void updateToValue(int r, int c, String value){
    
       System.out.println(); 
       int index = convert(r, c); 
       int parent = find(index); 
       parentString[parent] = value; 

    }
    
    static void updateToString(String existingValue, String updatedValue ){
        for(int i=1; i<=2500; i++){
           if(parentString[i].equals(existingValue)) parentString[i] = updatedValue; 
        }        
    }
    static void merge(int r1, int c1, int r2, int c2){
        if(r1==r2&&c1==c2)return; 
        int index1 = convert(r1, c1); 
        int index2 = convert(r2, c2); 
        if(parentString[find(index1)]==""&&parentString[find(index2)]!="") union(index2, index1); 
        else {
            System.out.println("Hi"); 
            union(index1, index2);}
    }
    static void unmerge(int r, int c){
       int parentNum = find(convert(r, c)); 
       String s = parentString[parentNum]; 
       ArrayList<Integer> delete = new ArrayList<>(); 
       for(int i=1; i<=2500; i++){
           if(find(i)==parentNum) {
               // parentString[i] = "";
               delete.add(i); 
           }
       }
        for(Integer x : delete) {
            parent[x] = x; 
            parentString[x] = "";
        }
        
       parentString[convert(r,c)] = s; 
    }
    
    
    static void print(int r, int c){
        String s = parentString[find(convert(r,c))]; 
        if(s==""||s==null) answer.add("EMPTY"); 
        else answer.add(s); 
    }
    
    static int convert(int r, int c) {
        return (r-1)*50 + c; 
    }
}