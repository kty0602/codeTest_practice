package day250401;

import java.util.*;

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
