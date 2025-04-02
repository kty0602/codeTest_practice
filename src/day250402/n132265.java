package day250402;

import java.util.*;

// 프로그래머스 롤 케이크 자르기(84512)
/*
[문제 설명]
- 토핑들의 번호를 저장한 정수 배열 topping이 매개변수로 주어질 때,
- 롤 케이크를 공평하게 잘라서 각각 토핑 수가 같아지는 방법의 수를 return 하시오.
*/
public class n132265 {

    private static int solution(int[] topping) {
        // 각각 토핑들의 종류가 같아지게 되는 나뉨의 수
        int count = 0;
        // 왼쪽 집합
        Set<Integer> part1 = new HashSet<>();
        // 오른쪽 집합(중복된 원소가 사라지지 않기 위함 + list로 진행 시 탐색 후 삭제까지 O(N^2) 걸림)
        Map<Integer, Integer> part2 = new HashMap<>();

        for (int num : topping) {
            part2.put(num, part2.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i < topping.length - 1; i++) {
            int current = topping[i];

            // 왼쪽에 추가
            part1.add(current);

            // 오른쪽에서 원소 개수를 감소
            if (part2.get(current) == 1) {
                part2.remove(current); // 개수가 1이면 완전히 제거
            } else {
                part2.put(current, part2.get(current) - 1);
            }

            if (part1.size() == part2.size()) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("topping 배열 값을 하나씩 입력하세요. 입력을 종료하려면 '!'를 입력하세요.");
        ArrayList<Integer> list = new ArrayList<>();
        while (true) {
            System.out.print("topping : ");
            String input = sc.nextLine();
            if (input.equals("!")) {
                break;
            }
            int number = Integer.parseInt(input);
            list.add(number);
        }

        int[] topping = list.stream().mapToInt(i -> i).toArray();
        int result = solution(topping);
        System.out.print("답 : " + result);
    }
}
