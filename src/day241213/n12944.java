package day241213;

import java.util.ArrayList;
import java.util.Scanner;

// 프로그래머스 평균 구하기(12944)
/*
[문제 설명]
- 배열 arr의 평균값을 return 하는 함수
*/
public class n12944 {

    private static double solution(int[] arr) {
        double answer = 0;
        double max = 0;

        for(int i = 0; i < arr.length; i++) {
            max += arr[i];
        }
        answer = max/arr.length;

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int y = 1;

        System.out.println("배열 값을 하나씩 입력하세요. 입력을 종료하려면 '!'를 입력하세요.");
        while (true) {
            System.out.print(y+"번째 값 : ");
            String input = sc.next();
            if (input.equals("!")) {
                break;
            }
            try {
                int number = Integer.parseInt(input);
                list.add(number);
                y++;
            } catch (NumberFormatException e) {
                System.out.println("유효한 정수를 입력하거나 '!'를 입력해 종료하세요.");
            }
        }

        // ArrayList를 int[]로 변환
        int[] arr = list.stream().mapToInt(i -> i).toArray();

        double answer = solution(arr);
        System.out.println("평균값: " + answer);
    }
}
