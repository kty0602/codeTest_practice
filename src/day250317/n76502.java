package day250317;

import java.util.Scanner;
import java.util.Stack;

// 프로그래머스 괄호 회전하기(76502)
/*
[문제 설명]
- 문자열 s를 길이만큼 회진시킬 때 각 회전 회차마다 올바른 괄호 문자열이 되는지 확인하고 되는 횟수를 return하시오.
*/
public class n76502 {

    private static int solution(String s) {
        StringBuilder sb = new StringBuilder(s);
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (isValid(sb.toString())) {
                count++;
            }

            char first = sb.charAt(0);
            sb.deleteCharAt(0).append(first);
        }
        return count;
    }

    private static boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // 닫는 괄호가 먼저 나오면 false
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();
                // 짝이 맞지 않다면 false
                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    // 또 다른 방법 -> 길이가 변하지 않는다면 올바른 괄호가 생성되지 않았다고 판단
    private static boolean isValid2(String str) {
        while (true) {
            int len = str.length();
            str = str.replace("()", "")
                    .replace("{}" , "").replace("[]", "");
            if (str.length() == len) {
                break;
            }
        }
        return str.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("s문자열 입력 : ");
        String s = sc.nextLine();

        int result = solution(s);
        System.out.print("답 :" + result);
    }
}
