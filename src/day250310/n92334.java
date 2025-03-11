package day250310;

import java.util.*;

// 프로그래머스 신고 결과 받기(92334)
/*
[문제 설명]
- 이용자의 ID가 담긴 문자열 배열 id_list, 각 이용자가 신고한 ID 정보가 담긴 report 문자열 배열, 정지 기준이 되는 횟수 k 가 매개변수로
- 주어질 때 각 유저 별로 처리 결과 메일을 받은 횟수를 return
*/
public class n92334 {

    private static int[] solution(String[] id_list, String[] report, int k) {

        // Set의 주요 기능 : 중복 제거 -> 동일한 신고를 여러 번 하더라도 한 번만 반영되도록
        Set<String> reportSet = new HashSet<>(Arrays.asList(report));

        // 각 사용자가 신고한 사람 목록을 저장하는 맵
        HashMap<String, Set<String>> reportMap = new HashMap<>();
        for (String id : id_list) {
            reportMap.put(id, new HashSet<>());
        }
        // 신고자, 신고당한 사람 리스트 reportMap에 저장
        for (String repo : reportSet) {
            String[] parts = repo.split(" ");
            String reporter = parts[0];
            String reported = parts[1];
            reportMap.get(reporter).add(reported);
        }
        // 신고당한 횟수를 저장할 맵 초기화
        Map<String, Integer> reportedCount = new HashMap<>();
        for (String id : id_list) {
            reportedCount.put(id, 0);
        }
        // 각 유저가 신고당한 횟수 계산
        for (Set<String> reportedUsers : reportMap.values()) {
            for (String reported : reportedUsers) {
                reportedCount.put(reported, reportedCount.get(reported) + 1);
            }
        }
        // 정지된 유저 리스트
        Set<String> banUser = new HashSet<>();
        for (String user : id_list) {
            if (reportedCount.get(user) >= k) {
                banUser.add(user);
            }
        }
        // 알림 개수 계산
        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            String user = id_list[i]; // 현재 검사중인 사용자 id
            Set<String> reportedUsers = reportMap.get(user); // 해당 사용자가 신고한 유저 리스트
            int count = 0;
            for (String reported : reportedUsers) {
                if (banUser.contains(reported)) {  // 신고한 유저 중 정지된 유저가 있다면 count 증가
                    count++;
                }
            }
            answer[i] = count;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("id_list 배열 값을 하나씩 입력하세요. 입력을 종료하려면 '!'를 입력하세요.");
        List<String> list1 = new ArrayList<>();
        while (true) {
            System.out.print("ID : ");
            String input = sc.nextLine();
            if (input.equals("!")) {
                break;
            }
            list1.add(input);
        }

        System.out.println("report 배열 값을 하나씩 입력하세요. 입력을 종료하려면 '!'를 입력하세요.");
        List<String> list2 = new ArrayList<>();
        while (true) {
            System.out.print("report. (Ex. muzi frodo) : ");
            String input = sc.nextLine();
            if (input.equals("!")) {
                break;
            }
            list2.add(input);
        }

        String[] id_list = list1.stream().toArray(String[]::new);
        String[] report = list2.stream().toArray(String[]::new);
        System.out.print("k값 : ");
        int k = sc.nextInt();
        int[] result = solution(id_list, report, k);
        System.out.println("답 : " + Arrays.toString(result));
    }
}
