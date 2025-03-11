package day250311;

import java.util.Arrays;
import java.util.Scanner;

// 프로그래머스 최대값과 최솟값(12939)
/*
[문제 설명]
- 문자열 s에는 공백으로 구분된 숫자들이 저장되어 있다 숫자 중 최소값과 최대값을 찾아
- 이를 "(최소값) (최대값)"형태의 문자열을 반환하는 함수를 완성하라.
*/
public class n12939 {

    private static String solution(String input) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        // 문자열 분리하여 배열에 저장
        String[] array = input.split(" ");
        // 문자열 배열을 숫자형 배열로 변환
        int[] intArray = Arrays.stream(array).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] > max) {
                max = intArray[i];
            }
            if (intArray[i] < min) {
                min = intArray[i];
            }
        }

        return min + " " + max;

        // 다른 방법
//        int[] numbers = Arrays.stream(input.split(" "))
//                .mapToInt(Integer::parseInt)
//                .toArray();
//
//        // 최소값과 최대값을 한 줄로 구하기
//        int min = Arrays.stream(numbers).min().getAsInt();
//        int max = Arrays.stream(numbers).max().getAsInt();
//
//        return min + " " + max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("문자열을 입력하세요. (Ex.1 2 3 4) : ");
        String input = sc.nextLine();

        String result = solution(input);
        System.out.println("답 : " + result);
    }
}
