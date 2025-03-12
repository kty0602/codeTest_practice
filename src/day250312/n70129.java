package day250312;

import java.util.Arrays;
import java.util.Scanner;

// 프로그래머스 이진 변환 반복하기(70129)
/*
[문제 설명]
- 0과 1로 이루어진 문자열 x에 대해 이진 변환을 다음과 같이 정의한다.
- x의 모든 0을 제거한다.
- x의 길이를 c라고 하면, x를 c를 2진법으로 표현한 문자열로 바꾼다.
*/
public class n70129 {

    private static int[] solution(String s) {
        int[] answer = new int[2];
        char target = '0';

        while (!s.equals("1")) {
            int count = 0;
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (c == target) {
                    count++;
                } else {
                    sb.append(c);
                }
            }
            answer[1] += count;
            s = Integer.toBinaryString(sb.length());
            answer[0]++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("이진수 입력 : ");
        String s = sc.nextLine();

        int[] result = solution(s);
        System.out.println("답 : " + Arrays.toString(result));
    }
}
