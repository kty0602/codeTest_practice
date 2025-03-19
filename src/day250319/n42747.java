package day250319;

import java.util.*;

// 프로그래머스 H-Index(42747)
/*
[문제 설명]
- H-Index는 과학자의 생산성과 영향력을 나타내는 지표입니다. H-Index를 나타내는 값인 h를 구하려고 합니다.
- 어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용 되었다면
- h의 최댓값이 이 과학자의 H-Index이다.
*/
public class n42747 {

    private static int solution(int[] citations) {
        int result = 0;
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;
            if (citations[i] >= h) {
                result = h;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("citations 배열 값을 하나씩 입력하세요. 입력을 종료하려면 '!'를 입력하세요.");
        int y = 1;
        ArrayList<Integer> list = new ArrayList<>();
        while (true) {
            System.out.print(y + "번째 값 : ");
            String input = sc.nextLine();
            if (input.equals("!")) {
                break;
            }
            int t = Integer.parseInt(input);
            list.add(t);
            y++;
        }

        int[] citations = list.stream().mapToInt(i -> i).toArray();
        int result = solution(citations);
        System.out.print("답 : " + result);
    }
}
