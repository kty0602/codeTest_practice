package day250417;

import java.util.*;

// 프로그래머스 연속된 부분 수열의 합 (178870)
/*
[문제 설명]
- 비내림차순으로 정렬된 수열이 주어질 때, 임의의 k값이 주어집니다. 연속된 부분 수열 값을 가지고 k값을 만든다고 할 때 해당
- 시작 인덱스와 마지막 인덱스 번호를 배열에 담아 return 하시오.
- 여러 가지 방법으로 나올 때 가장 길이가 짧은 방법을 반환합니다.
*/
public class n178870 {

    private static int[] solution(int[] sequence, int k) {
        int start = 0, end = 0, sum = 0;
        int minLen = Integer.MAX_VALUE;
        int[] answer = {-1, -1};

        while (end < sequence.length) {
            sum += sequence[end];

            while (sum >= k) {
                if (sum == k && (end - start + 1) < minLen) {
                    minLen = end - start + 1;
                    answer[0] = start;
                    answer[1] = end;
                }
                sum -= sequence[start];
                start++;
            }
            end++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("sequence 값을 하나씩 입력하세요. 입력을 종료하려면 '!'를 입력하세요.");
        ArrayList<Integer> list = new ArrayList<>();
        while (true) {
            System.out.print("sequence : ");
            String input = sc.nextLine();
            if (input.equals("!")) {
                break;
            }
            int number = Integer.parseInt(input);
            list.add(number);
        }

        System.out.print("k : ");
        int k = sc.nextInt();
        int[] sequence = list.stream().mapToInt(i -> i).toArray();
        int[] result = solution(sequence, k);
        System.out.print("답 : " + Arrays.toString(result));
    }
}
