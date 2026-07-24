class Solution {
    public long solution(int k, int d) {
        long answer = 0;
     
        int n = d / k;
        long res = n * n;
        
        for (int a = 0; a <= n; a++) {
            for (int b = 0; b <= n; b++) {
                long num = a * a + b * b; 
                
                if (num <= res) {
                    answer++; 
                }
            }
        }
        
        return answer;
    }
}