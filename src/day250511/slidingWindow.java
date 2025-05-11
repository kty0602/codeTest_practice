package day250511;

import java.util.*;

public class slidingWindow {

    // 최대 합을 구하는 방식 풀이
    private static int solution1(int[] nums, int k) {
        int result = 0;
        int currentSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];

            if (i >= k) {
                currentSum -= nums[i-k];
            }

            if (i >= k - 1) {
                result = Math.max(result, currentSum);
            }
        }

        return result;
    }

    // 각 윈도우 구간의 최대값을 순서대로 반환 풀이 (큐를 이용한 풀이)
    private static int[] solution2(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);

            // 현 queue 길이가 k값 보다 크면 첫번째 값 삭제
            if (queue.size() > k) {
                queue.poll();
            }

            // 현 queue 길이가 3이면 그 중에서 가장 큰 값 list에 추가
            if (queue.size() == k) {
                int maxNum = Integer.MIN_VALUE;
                List<Integer> temp = new ArrayList<>(queue);
                for (int num : queue) {
                    maxNum = Math.max(maxNum, num);
                }
                list.add(maxNum);
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int result1 = solution1(nums, k);
        System.out.println("1번 답 : " + result1);

        int[] result2 = solution2(nums, k);
        System.out.println("2번 답 : " + Arrays.toString(result2));
    }
}
