package day241226;

import java.util.Scanner;

// 프로그래머스 숫자 문자열과 영단어(12950)
/*
[문제 설명]
- 문자열 s를 입력받으면 해당 문자를 숫자로 return
*/
public class n81301 {

    private static final String[] arr = {
            "zero", "one", "two", "three",
            "four", "five", "six", "seven", "eight", "nine"
    };

    private static int solution(String s) {
        int answer = 0;
        for(int i = 0; i<arr.length; i++) {
            if(s.contains(arr[i])) {
                s = s.replace(arr[i], Integer.toString(i));
            }
        }
        answer = Integer.parseInt(s);
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자 문자열 s 입력 : ");
        String s = sc.nextLine();

        int answer = solution(s);
        System.out.println("답 : " + answer);
    }
}
