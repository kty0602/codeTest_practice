package day250325;

import java.util.*;

// 프로그래머스 기능 개발(42586)
/*
[문제 설명]
- 기능 개선 작업을 수행 중이다. 각 기능은 진도 100%일 때 서비스에 반영한다.
- 각 기능 개발속도는 다르기에 뒤에 있는 기능이 앞 기능보다 먼저 개발될 수 있고, 이 때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때
- 함께 배포된다. 순서대로 작업 진도가 적힌 정수 배열 progresses와 각 작업 개발 속도가 적힌 정수 배열 speeds가 주어질 때 각 배포마다
- 몇 개의 기능이 배포되는지를 return 하시오.
*/
public class n42586 {

    private static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            int days = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            queue.add(days);
        }

        while (!queue.isEmpty()) {
            int deployDay = queue.poll(); // 현 queue에 있는 작업 중 첫 번째 기능의 걸리는 일 수
            int count = 1;

            // 이미 완료된 작업 빼내는 기능
            while (!queue.isEmpty() && queue.peek() <= deployDay) {
                queue.poll();
                count++;
            }

            result.add(count);
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> list1 = new ArrayList<>();
        System.out.println("progresses 배열 값을 하나씩 입력하세요. 입력을 종료하려면 '!'를 입력하세요.");
        int y = 1;
        while (true) {
            System.out.print(y + "번째 작업 진도 : ");
            String input = sc.nextLine();
            if (input.equals("!")) {
                break;
            }
            int progress = Integer.parseInt(input);
            list1.add(progress);
            y++;
        }

        ArrayList<Integer> list2 = new ArrayList<>();
        System.out.println("각 작업 개발 속도를 입력하세요.");
        for (int i = 0; i < y-1; i++) {
            System.out.print((i+1) + "번째 작업 개발 속도 : ");
            int speed = sc.nextInt();

            list2.add(speed);
        }

        int[] progresses = list1.stream().mapToInt(i -> i).toArray();
        int[] speeds = list2.stream().mapToInt(i -> i).toArray();

        int[] result = solution(progresses, speeds);
        System.out.print("답 : " + Arrays.toString(result));
    }
}
