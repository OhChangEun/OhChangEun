import java.util.*;

class Solution {
    final long BLOCK = 10_000_000;
    
    public int[] solution(long begin, long end) {
        
        // 등장할 때마다 카운트하는게 아니라 
        // 2k, 3k, 4k... 가 등장하면 해당 등장한 값으로 치환을 하는게 맞다...
        // 천만까지 10억개의 숫자에 기록을 할 때, 해당 숫자에 남는 최소 숫자 배열을 리턴하면 된다 
        // 해당 수의 약수 중 자기 자신을 제외한 가장 큰 수를 리턴하면 된다. 
       	int len = (int)(end - begin + 1);
        
        int[] answer = new int[len];
        for (long num = begin; num <= end; num++) {
            answer[(int)(num - begin)] = getBlock(num);  
        }
        
        return answer;
    }
    
    public int getBlock(long num) {
        if (num == 1) return 0; 
        
        long sqrt = (long)Math.sqrt(num);
        
        int res = 1; 
        // 소수가 아닌 숫자의 약수 후보 중에서 
        for (long left = 2; left <= sqrt; left++) {
            // 만약 얘가 소수(1과 자신외에 나누어떨어지는게 없는 친구)면 1로만 나타내기  
            // 나누어 떨어지면서 
            // 왼쪽 약수가 BLOCK 보다 작으면
            if (num % left == 0) {
                long right = num / left; 
                //print(left + ": " + right);  

                // 오른쪽 숫자가 천만보다 작은 숫자라면 
                if (right <= BLOCK) {
                    return (int)right; 
                }
                res = (int)left; // !!짝이 중간에 잘리는 경우!!
            } 
        }
        
        return res;
    }
    
    public void print(Object o) {
        System.out.println(o);
    }
}