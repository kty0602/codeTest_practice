package day250218;


import java.util.*;

// 프로그래머스 명예의 전당(138477)
/*
[문제 설명]
- 명예의 전당은 매일 최하위 점수를 발표합니다. 예를 들어 k값이 3이고 7일 동안 진행된 가수의 점수가
- [10, 100, 20, 150, 1, 100, 200] 이라면 [10, 10, 10, 20, 20, 100, 100] 입니다.
*/
public class n138477 {

    private static int[] solution(int k, int[] scores){
        List<Integer> answer = new ArrayList<>();
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i = 0; i<scores.length; i++) {
            q.add(scores[i]);
            if(i>=k) {
                q.poll();
            }
            answer.add(q.peek());
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("k값 : ");
        int k = sc.nextInt();
        sc.nextLine();  // 개행 문자 소비
        int y = 1;
        System.out.println("numbers 배열 값을 하나씩 입력하세요. 입력을 종료하려면 '!'를 입력하세요.");
        while (true) {
            System.out.print(y + "번째 값 : ");
            String input = sc.nextLine();
            if (input.equals("!")) {
                break;
            }
            int number = Integer.parseInt(input);
            list.add(number);
            y++;
        }

        int[] scores = list.stream().mapToInt(i -> i).toArray();

        int[] answer = solution(k, scores);
        System.out.println("답 : "+ Arrays.toString(answer));
    }
}
