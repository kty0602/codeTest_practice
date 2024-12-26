package day241226;

import java.util.*;

// 프로그래머스 문자열 내 마음대로 정하기(12915)
/*
[문제 설명]
- 문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때, 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬
- 인덱스 1의 문자가 같은 문자열이 여럿의 경우, 사전순으로 앞선 문자열이 앞쪽 위치
*/
public class n12915 {

    private static String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        List<String> list = new ArrayList<>();

        for(int i = 0; i < strings.length; i++) {
            list.add(strings[i].charAt(n) + strings[i]);
        }

        Collections.sort(list);

        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).substring(1);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = 1;
        ArrayList<String> list = new ArrayList<>();
        System.out.println("strings 배열 값을 하나씩 입력하세요. 입력을 종료하려면 '!'를 입력하세요.");

        while (true) {
            System.out.print(y + "번째 값 : ");
            String input = sc.nextLine();
            if(input.equals("!")) {
                break;
            }
            list.add(input);
            y++;
        }

        System.out.print("n의 값을 입력하시오 : ");
        int n = sc.nextInt();

        String[] strings = list.stream().toArray(String[]::new);
        String[] answer = solution(strings, n);

        System.out.println("답 : " + Arrays.toString(answer));
    }
}
