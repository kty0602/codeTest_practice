package day241226;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// 프로그래머스 가장 가까운 같은 글자(142086)
/*
[문제 설명]
- 문자열 s가 주어졌을 때, s의 각 위치마다 자신보다 앞에 나왔으면서, 자신과 가장 가까운 곳에 있는 같은 글자가 어디있는지 return
- 없다면 -1을 반환
*/
public class n142086 {

    private static int[] solution(String s) {
        List<Integer> answer = new ArrayList<>();
        String[] arr = s.split("");
        for(int i = 0; i < arr.length; i++) {
            int index = -1;
            for(int j = 0; j < i; j++) {
                if (arr[j].equals(arr[i])) {
                    index = j;
                }
            }
            if (index == -1) {
                answer.add(-1);
            } else {
                answer.add(i-index);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("문자열 s 입력 : ");
        String s = sc.nextLine();

        int[] answer = solution(s);
        System.out.println("답 : " + Arrays.toString(answer));
    }
}
