package day241219;

import java.util.*;

// 프로그래머스 제일 작은 수 제거하기(12935)
/*
[문제 설명]
- 배열 arr에서 가장 작은 수를 제거한 배열을 return
- 리턴하려는 배열이 빈 배열이라면 -1을 return
*/
public class n12935 {

    private static int[] solution(int[] arr) {
        int[] answer = {};

        if(arr.length == 1) {
            answer = new int[] {-1};
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            for(int i : arr) {
                list.add(i);
            }

            list.remove(Collections.min(list));
            answer = new int[arr.length - 1];

            for(int i = 0; i<list.size(); i++) {
                answer[i] = list.get(i);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer>  list = new ArrayList<>();
        int y = 1;

        System.out.println("배열 값을 하나씩 입력하세요. 입력을 종료하려면 '!'를 입력하세요.");
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

        int[] arr = list.stream().mapToInt(i -> i).toArray();

        int[] answer = solution(arr);
        System.out.println("답 : " + Arrays.toString(answer));
    }
}
