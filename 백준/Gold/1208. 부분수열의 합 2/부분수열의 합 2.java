import java.io.*;
import java.util.*;

public class Main {



    static ArrayList<Integer> partSequenceA, partSequenceB;
    static Map<Integer, Integer> partSeuquenceBMap;
    static int n, s;
    static long answer; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        ArrayList<Integer>subA = new ArrayList<>();
        ArrayList<Integer>subB = new ArrayList<>();
        partSequenceA = new ArrayList<>();
        partSequenceB = new ArrayList<>();
        partSeuquenceBMap = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            if(i<=n/2){
                subA.add(Integer.parseInt(st.nextToken()));
            }
            else{
                subB.add(Integer.parseInt(st.nextToken()));
            }
        }

        partSequenceMethod(0, 0, subA, partSequenceA, false, false);
        partSequenceMethod(0, 0, subB, partSequenceB, false, true);

        twoPointCalculate();
        sb.append(answer);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }


    static void partSequenceMethod(int index, int sum, ArrayList<Integer> sub, ArrayList<Integer> partSequence, boolean isSum, boolean isB){

        if(index==sub.size()){
            if(isSum){
                partSequence.add(sum);
                if(isB)partSeuquenceBMap.put(sum, partSeuquenceBMap.getOrDefault(sum, 0)+1);
            }
            return;
        }
        partSequenceMethod(index + 1, sum + sub.get(index), sub, partSequence, isSum|true, isB);
        partSequenceMethod(index + 1, sum, sub, partSequence, isSum|false, isB);
    }


    static void twoPointCalculate(){

        for (int i = 0; i < partSequenceA.size(); i++) {
            int x = partSequenceA.get(i);
            if(x==s)answer++;
            int y = s-x;
            answer += partSeuquenceBMap.getOrDefault(y,0);
        }
        answer+=partSeuquenceBMap.getOrDefault(s,0);

    }

}