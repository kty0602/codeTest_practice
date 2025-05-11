package day250511;

import java.util.ArrayList;
import java.util.List;

public class permutation {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};  // 입력 숫자 배열
        int range = 3;              // 만들 순열 길이

        boolean[] visited = new boolean[nums.length];   // 숫자 사용 여부 체크용
        List<Integer> current = new ArrayList<>();      // 만들어진 순열 저장

        solution(nums, range, visited, current);
    }

    // 순열의 길이가 정해져 있는 풀이
    private static void solution(int[] nums, int range, boolean[] visited, List<Integer> current) {

        // 순열의 길이가 원하는 길이에 도달하면 출력하고 종료
        if (current.size() == range) {
            System.out.println(current);
            return;
        }

        // 모든 숫자를 순회하며 사용하지 않는 숫자를 선택
        for (int i = 0; i < nums.length; i++) {
            // 이미 사용한 숫자라면 skip
            if (visited[i]) {
                continue;
            }

            // 숫자 사용 처리
            visited[i] = true;
            current.add(nums[i]);

            // 재귀 호출
            solution(nums, range, visited, current);

            // 백트래킹 : 이전 상태로 되돌림
            visited[i] = false;
            current.remove(current.size() - 1);
        }
    }
}
