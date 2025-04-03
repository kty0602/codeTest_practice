package day250403;

import java.util.*;

// 프로그래머스 2개 이하로 다른 비트(77885)
/*
[문제 설명]
- numbers 배열의 각 숫자를 비트로 변환시켰을 때 숫자보다 큰 수중에서 비트 값이 다른 개수가 1 ~ 2개 이하인 가장 가까운 수를 return
*/
public class n77885 {

    // 시간 초과로 실패한 코드
//    private static long[] solution(long[] numbers) {
//        List<Long> list = new ArrayList<>();
//
//        for (long num : numbers) {
//            // 다음 수 저장
//            long next = num + 1;
//            // XOR 연산 실행 비트 차이 2개 이하가 될 때까지 실행
//            while (Long.bitCount(num ^ next) > 2) {
//                next++;
//            }
//            list.add(next);
//        }
//
//        return list.stream().mapToLong(i -> i).toArray();
//    }


    //
    private static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long num = numbers[i];

            // 짝수인 경우 (마지막 비트가 0이면 1을 더하기만 하면 됨)
            if ((num & 1) == 0) {
                answer[i] = num + 1;
            } else {
                // num에서 가장 낮은 0을 1로 변경하고, 그 바로 오른쪽 1을 0으로 변경
                long a = (num + 1) & ~(num);
                answer[i] = (num | a) & ~(a >> 1);
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("numbers 배열 값을 하나씩 입력하세요. 입력을 종료하려면 '!'를 입력하세요.");
        ArrayList<Long> list = new ArrayList<>();
        while (true) {
            System.out.print("topping : ");
            String input = sc.nextLine();
            if (input.equals("!")) {
                break;
            }
            long number = Long.parseLong(input);
            list.add(number);
        }

        long[] numbers = list.stream().mapToLong(i -> i).toArray();
        long[] result = solution(numbers);

        System.out.print("답 : " + Arrays.toString(result));
    }
}
