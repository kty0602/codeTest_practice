package day241212;

import java.util.ArrayList;
import java.util.Scanner;

// 프로그래머스 배렬의 평균값(120817)
/*
[문제 설명]
- numbers의 원소의 평균 값을 return
*/
public class n120817 {

    private static double solution(int[] numbers) {
        double length = numbers.length;
        double sum = 0;
        for(int i = 0 ; i<numbers.length; i++) {
            sum += numbers[i];
        }
        double answer = sum/length;
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int y = 1;

        System.out.println("배열 값을 하나씩 입력하세요. 입력을 종료하려면 '!'를 입력하세요.");
        while (true) {
            System.out.print(y+"번째 값 : ");
            String input = sc.nextLine();
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
        int[] numbers = list.stream().mapToInt(i -> i).toArray();

        double answer = solution(numbers);
        System.out.println("평균값: " + answer);
    }
}
