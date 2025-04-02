package day250401;

import java.util.*;

// 프로그래머스 뒤에 있는 큰 수 찾기(154539)
/*
[문제 설명]
- 정수로 이루어진 배열 numbers가 있습니다. 모든 원소에 대한 뒷 큰수들을 차례로 담은 배열을 return 하도록 하는 함수를 완성하시오.
- 단 뒷 큰 수가 존재하지 않는 다면 -1을 담습니다.
*/
public class n154539 {

    // 속도 느린 방식
//    private static int[] solution(int[] numbers) {
//        int[] answer = new int[numbers.length];
//
//        for (int i = 0; i < numbers.length; i++) {
//            answer[i] = -1;
//            for (int j = i+1; j < numbers.length; j++) {
//                if (numbers[i] < numbers[j]) {
//                    answer[i] = numbers[j];
//                    break;
//                }
//            }
//        }
//        return answer;
//    }

    // 속도 빠른 방식
    private static int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = numbers.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= numbers[i]) {
                stack.pop();
            }

            answer[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(numbers[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("records 배열 값을 하나씩 입력하세요. 입력을 종료하려면 '!'를 입력하세요.");
        ArrayList<Integer> list = new ArrayList<>();
        while (true) {
            System.out.print("records : ");
            String input = sc.nextLine();
            if (input.equals("!")) {
                break;
            }
            int number = Integer.parseInt(input);
            list.add(number);
        }

        int[] numbers = list.stream().mapToInt(i -> i).toArray();
        int[] result = solution(numbers);
        System.out.print("답 : " + Arrays.toString(result));
    }
}
