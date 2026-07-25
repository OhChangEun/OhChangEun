class Solution {
    final long BLOCK = 10_000_000;
    public int[] solution(long begin, long end) {
       	int len = (int)(end - begin + 1);
        
        int[] answer = new int[len];
        int idx = 0;
        for (long num = begin; num <= end; num++) {
            // 약수 후보 중에서 
           	for (int left = 1; left <= (int)Math.sqrt(num); left++) {
                // 나누어 떨어지면서 
                // 왼쪽 약수가 BLOCK 보다 작으면  
           		if (num % left == 0) {
                    if (left <= BLOCK) {
                    	answer[idx]++;
                        print(num);
                        print("l: " + left);
                    }
                   	long right = num / left;
                	//if (num == right) continue;
                    // 오른쪽 약수도 작으면 
                    if (left != right && right <= BLOCK) {
                        answer[idx]++;
                        print("r: " + right);
                    }
                    print("\n");
                } 
            }
            idx++;
        }
     
        return answer;
    }
    
    public void print(Object o) {
        System.out.println(o);
    }
}