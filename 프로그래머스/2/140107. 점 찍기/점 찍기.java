class Solution {
    public long solution(int k, int d) {
        long answer = 0;
    
        long total = 1L * d * d; 
        for (int a = 0; a <= d; a += k) {
            double bMax = Math.sqrt(total - 1L * a * a); 
            
            int b = (int)bMax;
            answer = answer + (b / k) + 1;
        }
        
        return answer;
    }
    
    public void print(Object o) {
        System.out.println(o);
    }
}