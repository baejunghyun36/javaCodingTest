import java.io.*;
import java.util.*;

public class Main {

    static int n, answer;
    static int [][] inputArray, accumArray;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        inputArray = new int[n + 1][n + 1];
        accumArray = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                inputArray[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        initAccumArray();
        bruteForce();
        sb.append(answer);



        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void bruteForce(){

        for (int startRowA = 1; startRowA <= n; startRowA++) {
            for (int startColA = 1; startColA <= n; startColA++) {
                for (int endRowA = startRowA; endRowA <= n; endRowA++) {
                    for (int endColA = startColA; endColA <= n; endColA++) {
                        int sumA = convertAccumArea(startRowA, startColA, endRowA, endColA);
                        int startRowB = endRowA + 1;
                        int startColB = endColA + 1;
                        for (int endRowB = startRowB; endRowB <= n; endRowB++) {
                            for (int endColB = startColB; endColB <= n; endColB++) {
                                int sumB = convertAccumArea(startRowB, startColB, endRowB, endColB);
                                if(sumA == sumB) answer++;
                            }
                        }
                        startRowB = endRowA + 1;
                        startColB = startColA - 1;
                        for (int endRowB = startRowB; endRowB <= n; endRowB++) {
                            for (int endColB = startColB; endColB >= 1; endColB--) {
                                int sumB = convertAccumArea(startRowB, endColB, endRowB, startColB);
                                if(sumA == sumB) answer++;
                            }
                        }
                    }
                }
            }
        }
    }

    static int convertAccumArea(int startRow, int startCol, int endRow, int endCol){
        return accumArray[endRow][endCol] - accumArray[endRow][startCol - 1] - accumArray[startRow - 1][endCol] + accumArray[startRow - 1][startCol - 1];
    }

    static void initAccumArray(){

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                accumArray[i][j] = accumArray[i][j - 1] + accumArray[i - 1][j] - accumArray[i - 1][j - 1] + inputArray[i][j];
            }
        }
    }
}