import java.util.*;

class Solution {
    static Date today_date = new Date();
    static Date priva_date = new Date();
    static String[] date_str;
    static String[] turm_str;
    static String[] priva_str;
    static HashMap<String, Integer> map = new HashMap();
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        
        date_str = today.split("\\.");
        today_date.setYear(Integer.parseInt(date_str[0]));
        today_date.setMonth(Integer.parseInt(date_str[1]));
        today_date.setDate(Integer.parseInt(date_str[2]));

        
        int i = 0;
        for(String term : terms){
            turm_str = terms[i].split(" ");
            map.put(turm_str[0], Integer.parseInt(turm_str[1]));
            i++;
        }

        
        i = 0; int j = 0; int[] answer_callect = new int[privacies.length];
        for(String privacie : privacies){
            priva_str = privacie.split(" ");
            date_str = priva_str[0].split("\\.");
            String type = priva_str[1];
            int aval_day = 28 * map.get(type);
            priva_date.setYear(Integer.parseInt(date_str[0]));
            priva_date.setMonth(Integer.parseInt(date_str[1]));
            priva_date.setDate(Integer.parseInt(date_str[2]));
            int today_int = 0; int priva_int = 0;
            today_int = today_date.getDate();
            priva_int = priva_date.getDate();
            int com_day = today_int - priva_int;
            com_day +=  28 * (today_date.getMonth() - priva_date.getMonth());
            com_day += 12 * 28 * (today_date.getYear() - priva_date.getYear());

            System.out.println(com_day);
            System.out.println(aval_day);

            if(com_day >= aval_day){
                answer_callect[j] = i+1;
                j++;
            }
            i++;
        }

        answer = new int[j];
        for(int w=0; w<j; w++){
            answer[w] = answer_callect[w];
        }

        return answer;
    }
}
