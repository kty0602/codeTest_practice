package day250317;

import java.util.*;

// 프로그래머스 귤 고르기(138476)
/*
[문제 설명]
- 한 상자에 담으려는 귤의 개수 k와 귤의 크기를 담은 배열 tangerine이 있을 때 귤 k개를 고를 때 크기가 서로 다른 종류의 최솟값을 return하라.
*/
public class n138476 {

    private static int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> countMap = new HashMap<>();

        // 사이즈 별로 갯수 카운팅 초기값은 0 하지만 기존에 있던 거 호출 시 +1
        for (int size : tangerine) {
            countMap.put(size, countMap.getOrDefault(size, 0) + 1);
        }

        List<Integer> countList = new ArrayList<>(countMap.values());
        countList.sort(Collections.reverseOrder());

        int total = 0; // 귤의 갯수
        int sizeCount = 0; // 귤의 종류

        for (int count : countList) {
            total += count;
            sizeCount++;
            if (total >= k) {
                break;
            }
        }
        return sizeCount;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("k 값 : ");
        int k = sc.nextInt();
        sc.nextLine(); // 개행 문자 삭제

        System.out.println("tangerine 배열 값을 하나씩 입력하세요. 입력을 종료하려면 '!'를 입력하세요.");
        int y = 1;
        ArrayList<Integer> list = new ArrayList<>();
        while(true) {
            System.out.print(y + "번째 값 : ");
            String input = sc.nextLine();
            if (input.equals("!")) {
                break;
            }
            int t = Integer.parseInt(input);
            list.add(t);
            y++;
        }

        int[] tangerine = list.stream().mapToInt(i -> i).toArray();

        int result = solution(k, tangerine);
        System.out.println("답 : " + result);
    }
}
