package day250319;

import java.util.*;

// 프로그래머스 연속 부분 수열의 합의 개수(131701)
/*
[문제 설명]
- 수열의 모든 원소 elements가 순서대로 주어질 때, 수열의 연속 부분 수열 합으로 만들 수 있는 수의 개수를 return
- 단 중복되는 값은 제외합니다.
*/
public class n131701 {

    private static int solution(int[] elements) {
        // 합들을 저장할 set
        Set<Integer> set = new HashSet<>();
        for (int size = 1; size <= elements.length; size++) {
            for (int start = 0; start < elements.length; start++) {
                int sum = 0;
                for (int i = 0; i < size; i++) {
                    int index = (start + i) % elements.length;
                    sum += elements[index];
                }
                set.add(sum);
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("elements 배열 값을 하나씩 입력하세요. 입력을 종료하려면 '!'를 입력하세요.");
        int y = 1;
        ArrayList<Integer> list = new ArrayList<>();
        while (true) {
            System.out.print(y + "번째 값 : ");
            String input = sc.nextLine();
            if (input.equals("!")) {
                break;
            }
            int t = Integer.parseInt(input);
            list.add(t);
            y++;
        }

        int[] elements = list.stream().mapToInt(i -> i).toArray();
        int result = solution(elements);
        System.out.print("답 : " + result);
    }
}
