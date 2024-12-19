package day241219;

import java.util.ArrayList;
import java.util.Scanner;

// 프로그래머스 없는 숫자 더하기(86051)
/*
[문제 해설]
- 정수 배열 numbers에서 없는 숫자를 모두 찾아 더한 수를 return
- numbers의 모든 원소는 서로 다름
*/
public class n86051 {

    private static int sum = 45;

    private static int solution(int[] numbers) {
        int answer = sum;
        for(int i = 0; i<numbers.length; i++) {
            answer -= numbers[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer>  list = new ArrayList<>();
        int y = 1;

        System.out.println("배열 값을 하나씩 입력하세요. 입력을 종료하려면 '!'를 입력하세요.");
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

        int[] numbers = list.stream().mapToInt(i -> i).toArray();

        int answer = solution(numbers);
        System.out.println("답 : " + answer);
    }
}
