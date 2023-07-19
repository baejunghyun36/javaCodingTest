import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static Map <Integer, String> candidateNumberToName;
    static List<Integer> [] userSelections;
    static double [] percentageList;
    static Candidate[] candidateList;
    static boolean [] removeList;
    static boolean [] removeUserList;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        userSelections = new LinkedList[1001];
        candidateList = new Candidate[n + 1];
        candidateNumberToName = new HashMap<>();
        removeList = new boolean[n+1];

        for(int i=1; i<= n; i++){
            String name = br.readLine();
            candidateList[i] = new Candidate(i, 0);
            candidateNumberToName.put(i, name);
        }
        for(int i=1; i<=1000; i++)  userSelections[i] = new LinkedList<>();
        String line;

        while((line = br.readLine()) != null && line.length() > 0) {
            st = new StringTokenizer(line); // 각 줄에는 투표 내역이 입력된다.
            for(int i=0; i<n; i++) userSelections[m+1].add(Integer.parseInt(st.nextToken()));
            m++;
        }
        removeUserList = new boolean[n + 1];
        System.out.println(calculateVotingPercentage());
    }

    static String calculateVotingPercentage(){

        while(true){
            percentageList = new double[n + 1];
            for(int i=1; i<=m; i++){
                while(removeList[userSelections[i].get(0)]==true) userSelections[i].remove(0);
                percentageList[userSelections[i].get(0)]++;
            }
            ArrayList<Candidate> temp = new ArrayList<>();
            for(int i=1; i<=n; i++){
                if(removeList[i]==true)continue;
                percentageList[i]*=100;
                percentageList[i]/=m;
                temp.add(new Candidate(i, percentageList[i]));
            }
            Collections.sort(temp);
            double minPercent = temp.get(temp.size()-1).percent;
            int index = temp.size()-1;
            if(temp.get(0).percent == temp.get(index).percent){
                index = 0;
                String s = "";
                while(index<temp.size()){
                    s+=candidateNumberToName.get(temp.get(index).number) + " ";
                    index++;
                }
                return s;
            }
            else if(temp.get(0).percent>=50) return candidateNumberToName.get(temp.get(0).number);
            while (index>=0&&minPercent == temp.get(index).percent) {
                removeList[temp.get(index).number] = true;
                index--;
            }
        }
    }

    static class Candidate implements Comparable<Candidate>{

        int number;
        double percent;

        public Candidate(int number, double percent) {
            this.number = number;
            this.percent = percent;
        }

        public int compareTo(Candidate candidate) {
            return Double.compare(candidate.percent, this.percent);
        }
    }
}
