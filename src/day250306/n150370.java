package day250306;

import java.util.*;

// 프로그래머스 개인정보 수집 유효기간(150370)
/*
[문제 설명]
- 오늘 날짜와 각 유형 별 유효 기간을 담은 terms 배열 그리고 개인정보를 저장시킨 월 privacies가 부여됩니다.
- 이때 오늘 날짜 기준으로 폐기 시켜야 할 정보 privacies위치를 반환하시오.
*/
public class n150370 {

    private static int[] solution(String today, String[] terms, String[] privacies) {
        HashMap<String, Integer> termMap = new HashMap<>();
        List<Integer> expiredList = new ArrayList<>();

        // 약관 유형, 기간 분리하여 HashMap에 저장
        for (String term : terms) {
            String[] split = term.split(" ");
            termMap.put(split[0], Integer.parseInt(split[1]));
        }

        // 오늘 날짜 변환
        int day = convertDays(today);

        for (int i = 0; i < privacies.length; i++) {
            String[] split = privacies[i].split(" ");
            String date = split[0];
            String termType = split[1];

            // 유효 기간 더하기
            int expiredDays = convertDays(date) + (termMap.get(termType) * 28) - 1;

            // 만료된 경우 해당 번호 리스트에 추가
            if (expiredDays < day) {
                expiredList.add(i + 1);
            }
        }

        return expiredList.stream().mapToInt(Integer::intValue).toArray();
    }

    // 날짜를 일 단위로 변환
    private static int convertDays(String today) {
        String[] parts = today.split("\\.");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);
        return (year * 12 * 28) + (month * 28) + day;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("오늘 날짜 : ");
        String today = sc.nextLine();

        System.out.println("terms 배열 값을 하나씩 입력하세요. 입력을 종료하려면 '!'를 입력하세요.");
        List<String> list1 = new ArrayList<>();
        while (true) {
            System.out.print("약관 종류, 기간 입력 : ");
            String input = sc.nextLine();
            if (input.equals("!")) {
                break;
            }
            list1.add(input);
        }

        System.out.println("privacies 배열 값을 하나씩 입력하세요. 입력을 종료하려면 '!'를 입력하세요.");
        List<String> list2 = new ArrayList<>();
        while (true) {
            System.out.print("개인정보 입력 : ");
            String input = sc.nextLine();
            if (input.equals("!")) {
                break;
            }
            list2.add(input);
        }

        String[] terms = list1.stream().toArray(String[]::new);
        String[] privacies = list2.stream().toArray(String[]::new);
        int[] result = solution(today, terms, privacies);
        System.out.println("답 : " + Arrays.toString(result));
    }
}
