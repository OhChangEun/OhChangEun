import java.util.*;

class Solution {
    public int[] solution(String[] words, String[] queries) {
        
        Map<Integer, List<String>> front = new HashMap<>();
        Map<Integer, List<String>> back = new HashMap<>();
        
        for (String word: words) {
            int len = word.length(); 
            front.putIfAbsent(len, new ArrayList<>());
            back.putIfAbsent(len, new ArrayList<>());
            
            List<String> frontList = front.get(len);
            frontList.add(word);
            
            List<String> backList = back.get(len);
            StringBuilder sb = new StringBuilder(word);
            backList.add(sb.reverse().toString());
        }
        
        for (List<String> list: front.values()) {
            Collections.sort(list);
        }
        for (List<String> list: back.values()) {
            Collections.sort(list);
        }
       
        int q = queries.length;
        int[] answer = new int[q];
        for (int i = 0; i < q; i++) {
            String query = queries[i];
            int len = query.length();
            //List<String> list = quries[i].startsWith("?") ? front.get(q) : back.get(q);
            //List<String> list = front.get(q);
            boolean isFront = !query.startsWith("?");
            
            List<String> list = isFront ? front.get(len) : back.get(len);
            if (list == null) {
                continue;
            }
            
            query = isFront ? query : new StringBuilder(query).reverse().toString();
            
            String minQuery = query.replace('?', 'a');
            String maxQuery = query.replace('?', (char)('z' + 1));
            
            int min = lowerBound(list, minQuery);
            int max = lowerBound(list, maxQuery);
             
            answer[i] = max - min; 
            /*
            answer[i] = 0; 
            */
        }
        //print(front);
        //print(back);
        
        return answer;
    }
    
    public int lowerBound(List<String> list, String query) {
        int answer = 0;
        
        int left = 0; 
        int right = list.size() - 1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (list.get(mid).compareTo(query) < 0) {
                left = mid + 1; 
            } else {
                right = mid - 1; 
            }
        }
        
        return left;
    }
    
    public void print(Object o) {
        System.out.println(o);
    }
    
    // Map<단어 길이, List<string>> map 2개 
    // 순방향, 역방향 한개씩 
    
    // ?가 아닌 단어로 시작하면 순방향 map 체크 
    // ?로 시작하는 단어는 역방향 map 체크
    // 각 리스트를 정렬해서, 경향성을 가지게 한 다음, 
    // 해당 query에 해당하는 단어를 이분 탐색으로 검색한다. 
}