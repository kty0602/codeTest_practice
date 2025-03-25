package day250325;

import java.util.*;

// 프로그래머스 프로세스(42586)
/*
[문제 설명]
- 실행 대기 큐에서 대기중인 프로세스 하나를 꺼낸다.
- 큐에 대기중인 프로세스 중 우선순위가 더 높은 프로세스가 있다면 방금 꺼낸 프로세스를 다시 큐에 넣는다.
- 만약 없다면 방금 꺼낸 프로세스를 실행한다.
- 프로세스 중요도가 순서대로 담긴 배열 priorities와 몇 번째로 실행되는지 알고 싶은 프로세스 위치를 알려주는 location이 매개변수로 주어질 때
- 해당 프로세스가 몇 번째로 실행되는지 return 하시오.
*/
public class n42587 {

    private static int solution(int[] priorities, int location) {
        // 작업 위치와, 작업 우선순위를 저장할 queue
        Queue<int[]> queue = new LinkedList<>();
        // 작업 우선순위를 저장할 우선순위 queue -> 내림차순
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < priorities.length; i++) {
            queue.add(new int[]{i, priorities[i]});
            priorityQueue.add(priorities[i]);
        }

        int order = 0;

        while (!queue.isEmpty()) {
            int[] process = queue.poll();
            int index = process[0]; // 작업 위치
            int priority = process[1]; // 작업 중요도

            // 현재 프로세스 우선순위가 가장 높다면 실행
            if (priority == priorityQueue.peek()) {
                priorityQueue.poll();
                order++;
                if (index == location) {
                    return order;
                }
            } else {
                queue.add(process);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("priorities 배열 값을 하나씩 입력하세요. 입력을 종료하려면 '!'를 입력하세요.");
        int y = 1;
        while (true) {
            System.out.print(y + "번째 작업 중요도 : ");
            String input = sc.nextLine();
            if (input.equals("!")) {
                break;
            }
            int x = Integer.parseInt(input);
            list.add(x);
            y++;
        }

        System.out.print("알고 싶은 작업 위치 : ");
        int location = sc.nextInt();

        int[] priorties = list.stream().mapToInt(i -> i).toArray();
        int result = solution(priorties, location);
        System.out.print("답 : " + result);
    }
}
