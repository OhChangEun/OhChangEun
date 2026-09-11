class Solution {
    int[] cookie; 
    int n;
    
    // 2개의 연속된 구간합이 같을 때, 구간합의 최대값 리턴 
    // 1) 중심 확장법으로 길이가 같아질때까지 더해서 중간에 같아지면 그거 리턴
    public int solution(int[] cookie) {
        this.cookie = cookie; 
        this.n = cookie.length; 
        
        if (n == 1) return 0;
        
        int result = 0;
        for (int i = 0; i < n - 1; i++) {
            int maxCookie = getMaxCookie(i, i + 1);
            result = Math.max(result, maxCookie);    
        }

        return result;
    }
    
    public int getMaxCookie(int left, int right) {
        int leftSum = cookie[left];
        int rightSum = cookie[right];
        
        int max = 0; 
        while (true) {
            //print(left + ", " + right);
            //print("leftSum: " + leftSum);
            //print("rightSum: " + rightSum);
            
            if (leftSum == rightSum) 
                max = Math.max(max, leftSum);
            
            if (leftSum < rightSum) {
                if (left == 0) break; 
                left--;
                leftSum += cookie[left];
            } else {
                if (right == n -  1) break; 
                right++;
                rightSum += cookie[right];
            } 
        }
        
        return max;
    }
    
    public void print(Object o) {
        System.out.println(o);
    }
}