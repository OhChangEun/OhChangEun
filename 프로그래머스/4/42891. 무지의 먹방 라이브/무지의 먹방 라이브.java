import java.util.*;

class Solution {
   
   	class Node {
        int idx; 
        int num; 
        
        public Node(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }
    } 
    public int solution(int[] food_times, long k) {
    	PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.num - b.num);
        
        int n = food_times.length;
      	for (int i = 0; i < n; i++) {
            int time = food_times[i];
            minHeap.add(new Node(i, time));
        } 
       
        int prev = 0;
        int len = food_times.length;
      	boolean[] removed = new boolean[n]; 
        while (!minHeap.isEmpty()) {
            Node min = minHeap.poll();
           
            long cycle = (long)len * (min.num - prev);
            if (cycle <= k) {
               	k -= cycle;
               	removed[min.idx] = true; 
                prev = min.num;
                len--;
            } else {
               	long pos = k % len;
           
                long cnt = 0;
                for (int i = 0; i < n; i++) {
                    if (removed[i]) continue; 
                    
                    if (pos == cnt) {
                        return i + 1;
                    }
                    
                    cnt++;
                }
            }
        }
        
        return -1;
    }
    
    public void print(Object o) {
        System.out.println(o);
    }
}