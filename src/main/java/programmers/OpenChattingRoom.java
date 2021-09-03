/**
 * 2019_KAKAO_BLIND_RECRUITMENT
 * 오픈채팅방
 * https://programmers.co.kr/learn/courses/30/lessons/42888
 */

package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpenChattingRoom {
    public static void main(String[] args) {
        String[] records = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        for(String answer : solution(records)) {
            System.out.println(answer);
        }
    }
    public static String[] solution(String[] record) {
        String[] answer = {};
        Map<String, String> user = new HashMap<>();
        List<String> ans = new ArrayList<>();

        for(String s : record) {
            String[] in = s.split(" ");
            if(in[0].equals("Enter")) {
                if(user.containsKey(in[1])) {
                    user.replace(in[1], in[2]);
                } else {
                    user.put(in[1], in[2]);
                }
                ans.add(in[1]+",님이 들어왔습니다.");
            } else if(in[0].equals("Leave")) {
                ans.add(in[1]+",님이 나갔습니다.");
            } else if(in[0].equals("Change")) {
                user.replace(in[1], in[2]);
            }
        }
        answer = new String[ans.size()];
        int idx = 0;
        for(String s : ans) {
            String[] _s = s.split(",");
            answer[idx++] = user.get(_s[0])+_s[1];
        }
        return answer;
    }
}
