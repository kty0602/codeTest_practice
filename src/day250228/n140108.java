package day250228;

import java.util.Scanner;

// 프로그래머스 문자열 나누기(140108)
/*
[문제 설명]
- 첫 글자를 읽고 이 글자를 x라고 한다.
- 왼쪽에서 오른쪽으로 읽어나가면서 x와 x가 아닌 다른 글자들이 나온 횟수를 센다.
- 처음으로 두 횟수가 같아지는 순간 멈추고 문자열을 분리한다.
- 분해한 문자열의 갯수를 return 하라.
*/
public class n140108 {

    private static int solution(String s) {
        int count = 0;      // 분리된 문자열 갯수
        int countF = 0;     // 첫 번째 문자열 갯수
        int countS = 0;     // 두 번째 문자열 갯수
        char first = s.charAt(0);   // 첫 번째 문자

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == first) {
                countF++;
            } else {
                countS++;
            }

            if (countF == countS) {
                count++;
                if (i + 1 < s.length()) {
                    first = s.charAt(i+1);
                }
                countF = 0;
                countS = 0;
            }
        }

        // 마지막 문자열도 하나의 덩이리로 카운팅
        if (countF != countS) {
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("문자열 s : ");
        String s = sc.nextLine();

        int result = solution(s);
        System.out.println("답 : " + result);
    }
}
