package day250304;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// 프로그래머스 둘만의 암호(155652)
/*
[문제 설명]
- 두 문자열 s와 skip, 그리고 자연수 index가 주어질 때, 다음 규칙에 따라 문자열을 만듭니다.
- 문자열 s의 각 알파벳을 index만큼 뒤의 알파벳으로 바꿔줍니다.
- index만큼의 뒤의 알파벳이 z를 넘어갈 경우 다시 a로 돌아갑니다.
- skip에 있는 알파벳은 제외하고 건너뜁니다.
*/
public class n155652 {

    private static String solution(String s, String skip, int index) {
        // skip에 있는 문자 저장 (빠른 탐색을 위한 set 사용)
        Set<Character> skipSet = new HashSet<>();
        for (char c : skip.toCharArray()) {
            skipSet.add(c);
        }

        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            char newChar = c;

            int count = 0;
            while (count < index) {
                newChar++;
                if (newChar > 'z') {
                    newChar = 'a';
                }

                if(!skipSet.contains(newChar)) {
                    count++;
                }
            }
            result.append(newChar);
        }
        return result.toString();
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("문자열 s 입력 : ");
        String s = sc.nextLine();
        System.out.print("문자열 skip 입력 : ");
        String skip = sc.nextLine();
        System.out.print("정수 index 입력 : ");
        int index = sc.nextInt();

        String result = solution(s, skip, index);
        System.out.println("답 : " + result);
    }
}
