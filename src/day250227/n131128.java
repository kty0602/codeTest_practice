package day250227;

import java.util.Scanner;

// 프로그래머스 숫자 짝꿍(131128)
/*
[문제 설명]
- 두 정수 X, Y의 임의의 자리에서 공통으로 나타나는 정수 k를 이용하여 만들 수 있는 가장 큰 정수를 두 수의 짝꿍이라 한다.
- 짝꿍이 존재하지 않는다면 -1, 0으로만 구성되어 있다면 짝꿍은 0이다.
*/
public class n131128 {

    private static String solution(String x, String y) {
        int[] countX = new int[10];
        int[] countY = new int[10];

        // 각 배열의 값은 0~9까지 몇번 나왔는가 카운팅(아스키 코드)
        for (char c : x.toCharArray()) {
            countX[c - '0']++;
        }
        for (char c : y.toCharArray()) {
            countY[c - '0']++;
        }

        StringBuilder answer = new StringBuilder();

        // 내림차순으로 확인하기
        for (int i = 9; i >= 0; i--) {
            // 짝꿍을 만들어야 하니 0값이 x문자열에서는 2번 y문자열에서 3번이 나왔다면 2번 짝꿍이 이뤄지므로 더 적은 횟수를 저장
            int minCount = Math.min(countX[i], countY[i]);
            for (int j = 0; j < minCount; j++) {
                answer.append(i);
            }
        }

        if (answer.length() == 0) {
            return "-1";
        }

        if (answer.charAt(0) == '0') {
            return "0";
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("X의 값 : ");
        String x = sc.nextLine();
        System.out.print("Y의 값 : ");
        String y = sc.nextLine();

        String result = solution(x, y);
        System.out.println("답 : " + result);
    }
}
