package day250402;

import java.util.*;

// 프로그래머스 숫자 변환하기(154538)
/*
[문제 설명]
- 자연수 x를 y로 변환하려고 한다. x,y,n이 매개변수로 주어질 때, x를 y로 변환하기 위해 필요한 최소 연산 횟수를 return 하시오.
- n은 더하는 용도로 사용
- 변환할 수 없다면 -1을 리턴하시오.
*/
public class n154538 {

    private static int solution(int x, int y, int n) {
        if (x == y) return 0;

        // 숫자와 연산 횟수를 저장
        Queue<int[]> queue = new LinkedList<>();
        // 방문한 숫자를 저장하는 set
        Set<Integer> visited = new HashSet<>();

        // 연산 횟수 0으로 초기화, set에 x값 저장하여 중복 계산 방지
        queue.add(new int[]{x, 0});
        visited.add(x);

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int num = cur[0];
            int count = cur[1];

            // 다음 단계로 이동 가능한 숫자 계산
            int[] nextNums = {num + n, num * 2, num * 3};

            for (int next : nextNums) {
                if (next == y) return count + 1;  // 정답 찾으면 즉시 반환
                if (next < y && !visited.contains(next)) {
                    queue.add(new int[]{next, count + 1});
                    visited.add(next);
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("x : ");
        int x = sc.nextInt();
        System.out.print("y : ");
        int y = sc.nextInt();
        System.out.print("n : ");
        int n = sc.nextInt();

        int result = solution(x, y, n);
        System.out.print("답 : " + result);
    }
}
