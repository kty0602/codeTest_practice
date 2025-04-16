package day250416;

import java.util.*;

// 프로그래머스 큰 수 만들기 (42883)
/*
[문제 설명]
- 어떤 숫자에서 k개의 숫자를 제거했을 때 가장 큰 숫자를 구하시오.
- 단 입력된 순서는 지켜야 한다. Ex, number  = 1429, k = 2  -> 49가 만들 수 있는 최고 큰 수
*/
public class n42883 {

    private static String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();

        for (char num : number.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() < num) {
                stack.pop();
                k--;
            }
            stack.push(num);
        }

        // k가 남아 있다면 뒤에서 제거
        while (k-- > 0) {
            stack.pop();
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("number : ");
        String number = sc.nextLine();

        System.out.print("k : ");
        int k = sc.nextInt();

        String result = solution(number, k);
        System.out.print("답 : " + result);
    }
}
