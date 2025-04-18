package day250418;

import java.util.*;

// 프로그래머스 두 큐 합 같게 만들기 (118667)
/*
[문제 설명]
- 길이가 같은 두 개의 큐가 주어진다. 하나의 큐를 골라 원소를 추출하고, 추출된 원소를 다른 큐에 집어넣는 작업을 통해
- 각 큐의 원소 합이 같도록 만들려고 한다. 이를 위해 필요한 작업의 최소 횟수를 return하라.
- 단 어떤 방법도 힘들 경우 -1을 리턴한다.
*/
public class n118667 {

    private static int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1 = 0, sum2 = 0;

        for (int i = 0; i < queue1.length; i++) {
            q1.add(queue1[i]);
            sum1 += queue1[i];
            q2.add(queue2[i]);
            sum2 += queue2[i];
        }

        // 합이 홀수면 -1 리턴
        if ((sum1 + sum2) % 2 != 0) {
            return -1;
        }

        int count = 0;
        // 무한 루프 위험을 방지 하기 위한 최대 반복 횟수 제한
        int limit = queue1.length * 3;

        while (count <= limit) {
            if (sum1 == sum2) return count;

            if (sum1 > sum2) {
                int value = q1.poll();
                sum1 -= value;
                sum2 += value;
                q2.add(value);
            } else {
                int value = q2.poll();
                sum2 -= value;
                sum1 += value;
                q1.add(value);
            }
            count++;
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int y =1;

        System.out.println("queue1 값을 하나씩 입력하세요. 입력을 종료하려면 '!'를 입력하세요.");
        ArrayList<Integer> list1 = new ArrayList<>();
        while (true) {
            System.out.print(y + "번째 queue1 : ");
            String input = sc.nextLine();
            if (input.equals("!")) {
                break;
            }
            int number = Integer.parseInt(input);
            list1.add(number);
            y++;
        }
        System.out.println("queue2 값을 하나씩 입력하세요. 입력을 종료하려면 '!'를 입력하세요.");
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < y; i++) {
            System.out.print(i+1 + "번째 queue2 : ");
            String input = sc.nextLine();
            int number = Integer.parseInt(input);
            list2.add(number);
        }

        int[] queue1 = list1.stream().mapToInt(i -> i).toArray();
        int[] queue2 = list2.stream().mapToInt(i -> i).toArray();

        int result = solution(queue1, queue2);
        System.out.print("답 : " + result);
    }
}
