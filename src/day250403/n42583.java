package day250403;

import java.util.*;

// 프로그래머스 다리를 지나는 트럭(77885)
/*
[문제 설명]
- 매개변수로 다리에 올라갈 수 있는 트럭 수 bridge_length, 다리가 견딜 수 있는 무게 weight,
- 트럭 별 무게 truck_weights가 주어집니다. 이때 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return 하시오.
*/
public class n42583 {

    private static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>(); // 다리 위의 트럭 (큐)
        int time = 0;  // 총 걸린 시간
        int bridgeWeight = 0;  // 현재 다리 위 트럭들의 무게 합

        for (int truck : truck_weights) {
            while (true) {
                // 1. 다리에 트럭이 꽉 차면 맨 앞 트럭 제거
                if (bridge.size() == bridge_length) {
                    bridgeWeight -= bridge.poll();
                }

                // 2. 새로운 트럭을 올릴 수 있는 경우
                if (bridgeWeight + truck <= weight) {
                    bridge.add(truck);
                    bridgeWeight += truck;
                    time++; // 트럭이 다리에 올라감 (1초 추가)
                    break; // 다음 트럭으로 이동
                } else {
                    // 3. 다리가 꽉 차서 못 올라가면 0을 추가하여 트럭 이동 유도
                    bridge.add(0);
                    time++;
                }
            }
        }

        // 마지막 트럭이 다리를 건너는 시간 추가
        return time + bridge_length;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("다리 길이 : ");
        int length = sc.nextInt();

        System.out.print("다리가 버틸 수 있는 무게 : ");
        int weight = sc.nextInt();

        System.out.println("트럭 배열 값을 하나씩 입력하세요. 입력을 종료하려면 '!'를 입력하세요.");
        ArrayList<Integer> list = new ArrayList<>();
        while (true) {
            System.out.print("트럭 : ");
            String input = sc.nextLine();
            if (input.equals("!")) {
                break;
            }
            int number = Integer.parseInt(input);
            list.add(number);
        }

        int[] truck_weights = list.stream().mapToInt(i -> i).toArray();
        int result = solution(length, weight, truck_weights);
        System.out.print("답 : " + result);
    }
}
