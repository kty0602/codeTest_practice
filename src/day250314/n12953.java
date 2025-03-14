package day250314;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// 프로그래머스 N개의 최소공배수(12953)
/*
[문제 설명]
- arr 배열의 수 중 최소 공배수를 반환하시오.
*/
public class n12953 {

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private static int lcm(int a, int b) {
        return a*(b/gcd(a, b));
    }

    private static int solution(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }

        return Arrays.stream(arr).reduce(1, (a, b) -> lcm(a, b));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("arr 배열 값을 하나씩 입력하세요. 입력을 종료하려면 '!'를 입력하세요.");
        int y = 1;
        ArrayList<Integer> list = new ArrayList<>();
        while (true) {
            System.out.print(y + "번째 값 : ");
            String input = sc.nextLine();
            if (input.equals("!")) {
                break;
            }
            int number = Integer.parseInt(input);
            list.add(number);
            y++;
        }

        int[] arr = list.stream().mapToInt(i -> i).toArray();

        int result = solution(arr);
        System.out.println("답 : " + result);

    }
}
