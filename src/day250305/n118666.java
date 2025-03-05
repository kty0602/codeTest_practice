package day250305;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// 프로그래머스 성격 유형 검사하기(118666)
/*
[문제 설명]
- 성격 유형 검사는 4개의 지표로 성격 유형을 구분합니다. 각 지표는 2개의 유형 중 하나로 결정됩니다.
- 1번 지표 성격 유형(R형, T형) 이 있다고 가정할 때 검사 후 R형 2점 T형 0점이라면 R형으로 결정된다.
*/
public class n118666 {

    private static String solution(String[] survey, int[] choices) {
        // 유형별 점수를 저장할 HaspMap
        Map<Character, Integer> scoreMap = new HashMap<>();
        char[] types = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
        for (char type : types) {
            scoreMap.put(type, 0);
        }

        for (int i = 0; i < survey.length; i++) {
            char first = survey[i].charAt(0);
            char second = survey[i].charAt(1);
            int choice = choices[i];

            // 가운데 값을 빼주고 절대값 반환
            int score = Math.abs(choice - 4);

            if (choice < 4) {
                // scoreMap.get(first) -> 해당 유형 값을 가져와서 더하기
                scoreMap.put(first, scoreMap.get(first) + score);
            } else if (choice > 4) {
                scoreMap.put(second, scoreMap.get(second) + score);
            }
        }

        StringBuilder result = new StringBuilder();
        result.append(scoreMap.get('R') >= scoreMap.get('T') ? 'R' : 'T');
        result.append(scoreMap.get('C') >= scoreMap.get('F') ? 'C' : 'F');
        result.append(scoreMap.get('J') >= scoreMap.get('M') ? 'J' : 'M');
        result.append(scoreMap.get('A') >= scoreMap.get('N') ? 'A' : 'N');

        return result.toString();
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = 1;
        int x = 1;
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        System.out.println("survey 배열 값을 하나씩 입력하세요. 입력을 종료하려면 '!'를 입력하세요.");
        while (true) {
            System.out.print(y + "번째 유형 : ");
            String input = sc.nextLine();
            if (input.equals("!")) {
                break;
            }
            list1.add(input);
            y++;
        }

        System.out.println("choices 배열 값을 하나씩 입력하세요. 입력을 종료하려면 '!'를 입력하세요.");
        while (true) {
            System.out.print(x + "번째 값 : ");
            String input = sc.nextLine();
            if (input.equals("!")) {
                break;
            }
            int number = Integer.parseInt(input);
            list2.add(number);
            x++;
        }

        String[] survey = list1.stream().toArray(String[]::new);
        int[] choices = list2.stream().mapToInt(i -> i).toArray();

        String result = solution(survey, choices);
        System.out.println("답 : " + result);
    }

}
