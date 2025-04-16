package day250416;

import java.util.*;

// 프로그래머스 택배상자 (131704)
/*
[문제 설명]
- 택배 상자는 1번 부터 n번 상자까지 번호가 증가하는 순서대로 일렬로 놓여 전달된다. 다만 그대로 싣게 되면 배달 순서와 맞지 않아 차질이
- 생긴다. 따라서 보조 컨테이너 벨트에 순서가 아닌 택배들을 보관하며 트럭에 알맞게 넣어야 한다. 택배 기사가 원하는 상자 순서를 나타내는
- 정수 배열 order가 주어질 때, 영재가 몇개의 상자를 실을 수 있는지 return 하시오.
- 단 보조 컨테이너 벨트와 기존 컨테이너 벨트에서 꺼낼 수 있는 숫자의 택배에서 택배 기사가 원하는 번호를 뽑을 수 없는 경우
- 그대로 적재를 종료한다.
*/
public class n131704 {

    private static int solution(int[] order) {
        int count = 0;
        Stack<Integer> sub = new Stack<>();
        int index = 0;
        int box = 1;

        while (box <= order.length) {
            // 나온 상자와 실어야 하는 번호가 같은 경우
            if (box == order[index]) {
                count++;
                index++;
                box++;
            // 보조 컨테이너에서 먼저 꺼내는 상자의 번호가 일치하는 경우
            } else if (!sub.isEmpty() && sub.peek() == order[index]) {
                sub.pop();
                count++;
                index++;
            // 아니면 보조 컨테이너에 집어넣기
            } else {
                sub.push(box);
                box++;
            }
        }

        // 남은 스택 처리 -> 맨 마지막 박스까지 도달한 경우 box++ 때문에
        // while문 조건에 위배되어 나머지 보조 컨테이너에 들어간 박스를 검사하지 못함
        while (!sub.isEmpty() && sub.peek() == order[index]) {
            sub.pop();
            count++;
            index++;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("order 값을 하나씩 입력하세요. 입력을 종료하려면 '!'를 입력하세요.");
        ArrayList<Integer> list = new ArrayList<>();
        while (true) {
            System.out.print("order : ");
            String input = sc.nextLine();
            if (input.equals("!")) {
                break;
            }
            int number = Integer.parseInt(input);
            list.add(number);
        }

        int[] order = list.stream().mapToInt(i -> i).toArray();
        int result = solution(order);
        System.out.print("답 : " + result);
    }
}
