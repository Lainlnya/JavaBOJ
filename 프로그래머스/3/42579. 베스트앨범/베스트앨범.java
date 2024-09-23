import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> genrePlayCount = new HashMap<>();
        HashMap<String, PriorityQueue<int[]>> genreSongs = new HashMap<>();
        ArrayList<Integer> answer = new ArrayList<>();
        
        for (int i = 0; i < genres.length; i++) {
                genrePlayCount.put(genres[i], genrePlayCount.getOrDefault(genres[i], 0) + plays[i]);
                genreSongs.putIfAbsent(genres[i], 
                                       new PriorityQueue<>((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]));
                genreSongs.get(genres[i]).add(new int[]{plays[i], i});
        }
        
        
        List<Map.Entry<String, Integer>> sortedGenres = new ArrayList<>(genrePlayCount.entrySet());
        sortedGenres.sort((a, b) -> b.getValue() - a.getValue());
    
        for (Map.Entry<String, Integer> genre: sortedGenres) {
            String key = genre.getKey();
            PriorityQueue<int[]> current = genreSongs.get(key);
            
            for (int i = 0; i < 2 && !current.isEmpty(); i++) {
                 answer.add(current.poll()[1]);
            }    
        }
        
        int[] result = new int[answer.size()];
        
        for (int i = 0; i < result.length; i++) {
            result[i] = answer.get(i);
        }
        
        return result;
    }
}