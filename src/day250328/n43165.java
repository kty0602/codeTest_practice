package day250328;

import java.util.ArrayList;
import java.util.Scanner;

// 프로그래머스 타켓 넘버(43165)
/*
[문제 설명]
- 사용할 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 대 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는
- 경우의 수를 return 하시오.
*/
public class n43165 {

    private static int count = 0;

    private static int solution(int[] numbers, int target) {
        count = 0;
        dfs(numbers, target, 0, 0);
        return count;
    }

    private static void dfs(int[] numbers, int target, int depth, int sum) {
        if (depth == numbers.length) {
            if (sum == target) {
                count++;
            }
            return;
        }

        // 현재 숫자를 더하는 경우
        dfs(numbers, target, depth + 1, sum + numbers[depth]);

        // 현재 숫자를 빼는 경우
        dfs(numbers, target, depth + 1, sum - numbers[depth]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("numbers 배열 값을 하나씩 입력하세요. 입력을 종료하려면 '!'를 입력하세요.");
        int y = 1;
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

        System.out.print("target : ");
        int target = sc.nextInt();

        int[] numbers = list.stream().mapToInt(i -> i).toArray();

        int result=  solution(numbers, target);
        System.out.print("답 : " + result);
    }
}
