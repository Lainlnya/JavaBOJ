import java.util.*;
import java.util.regex.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        Pattern pattern = Pattern.compile("^([^0-9]+)([0-9]+)(.*)$");
        
        Arrays.sort(files, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                Matcher m1 = pattern.matcher(s1);
                Matcher m2 = pattern.matcher(s2);
                
                m1.find();
                m2.find();
                
                String head1 = m1.group(1).toUpperCase();
                String head2 = m2.group(1).toUpperCase();
                
                if (!head1.equals(head2)) {
                    return head1.compareTo(head2);
                }
                
                return Integer.parseInt(m1.group(2)) - Integer.parseInt(m2.group(2));
                
            }
        });
        
        return files;
    }
}