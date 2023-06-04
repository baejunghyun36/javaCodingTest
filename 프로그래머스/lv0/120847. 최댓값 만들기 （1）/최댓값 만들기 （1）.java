import java.util.*; 
class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        Arrays.sort(numbers); 
        int a = numbers.length-1; 
        int b = numbers.length-2; 
        return numbers[a]*numbers[b]; 

    }
}