class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {  
        
        int n = schedules.length; 
        int answer = n;
  
        for (int i = 0; i < n; i++) {
            int maxTime = schedules[i] + 10;
            
            if (maxTime % 100 >= 60) {
                maxTime += 40;
            }
            
            for (int d = 0; d < 7; d++) {
                int day = (startday + d - 1) % 7; 
            
                //System.out.println(day);

                if (day == 5 || day == 6) continue; 
                
                if (maxTime < timelogs[i][d]) {
                    //System.out.println(timelogs[i][d]);
                    //System.out.println("");
                    //System.out.println(i + ", " + day);
                    answer--;
                    break; 
                }
            }
        }
        
        return answer;
    }
}