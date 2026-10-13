import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
      
        Arrays.sort(rocks);
       
        int r = rocks.length;
       	int[] diff = new int[r + 1];
        for (int i = 0 ; i < r - 1; i++) {
           	diff[i + 1] = rocks[i + 1] - rocks[i]; 
        }
      	diff[0] = rocks[0]; 
      	diff[r] = distance - rocks[r - 1]; 
        
        /*
        for (int num: diff) {
            print(num + " ");
        }
        */
       	
        int left = 0;
        int right = 1_000_000_000;
        int answer = 0;
        while (left <= right) {
            int mid = (left + right) / 2; 
           
            // 거리의 최소값이 mid일 때, 해당 값이 바위 사이의 거리보다 작은 경우가 바위 제거하고, 
            // 제거한 바위가 n개 이하면 유효, 
            if (isValid(mid, diff, n)) {
                left = mid + 1;
               	answer = mid; 
            } else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
  	public void print(Object o) {
        System.out.print(o);
    } 
    
    
    public boolean isValid(int mid, int[] diff, int n) {
       	int d = diff.length; 
     
        int[] temp = diff.clone();
        int remove = 0;
        for (int i = 0; i < d; i++) {
           	if (temp[i] < mid) {
               	remove++; 
               	
                if (i != d - 1) 
                    temp[i + 1] += temp[i];
            }
            
            if (remove > n) 
                return false;
        }
        
        return true;
    }
    
    // 0 => 25
    // 2, 14, 11, 21, 17 
   	// 21, 17 제거 
    // 왜 각 바위 사이 거리가
    // 2, 9, 3, 11인가
    
    // 정렬하면
    // 2, 11, 14, 17, 21 인데 
    // 2, 11, 14만 남고, 
    // 2, 9, 3, 11이네 
    // 여기서 거리의 최소값이 2인거고 
    
    // 11, 14, 17,
    // 11, 3, 3, 8
    // 어쨋든 모든 최소값의 케이스들 중 가장 큰 값을 리턴하면 된다. 
    
    // 정렬 후, O(N)만큼 순회하면서 각 거리간 최소값을 기록하면 됨(앞에 0, 뒤에 25-distance) 
    // 하지만 케이스는 n개를 제거한거를 순회 
    // n개의 케이스는 5C2(총 바위개수 Comb n) => 최대 5만! 아닌가? 
    
    // distance는 10억, 바위는 5만 
    // 경향성이 있나? 
    // 어떤 바위를 제거했을 때, 거리가 계속 멀어지는가? 
    // 0, 2, 11, 14, 17, 21, 25 인데 
  
    //  2   9   3   3   4   4 
    //   11       6     4   4 : case5
    // 합쳐지는거랑 같음  
    // n개 2개씩 짝지어주다가 남은거 중에 가장 작은거 
    //  2   9   3       11 : case1 
    
    //  2   9   3   3   4   4   50   1000 
    // 이웃한 점들끼리 가장 합이 큰거를 묶어버리고, 
    // 최대한 묶고 남는거 중 최소값 >> 이 방법 별로인듯
     
    // 2) 경향성 
    // 각 바위 간 거리가 경향이 있나? no
    // 
}