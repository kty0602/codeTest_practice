package day250227;

import java.util.ArrayList;
import java.util.Scanner;

// 프로그래머스 체육복(42862)
/*
[문제 설명]
- 학생들의 번호는 체격 순으로 매겨져 있어 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다.
- 전체 학생 수 n, 도난 당한 학생들의 번호가 담긴 배열 lost, 여벌의 체육복을 가져온 학생들의 번호가 담긴 reserve가 매개변수로 주어질 때
- 체육수업을 들을 수 있는 최댓값을 리턴하시오.
*/
public class n42862 {

    private static int solution(int n, int[] lost, int[] reserve) {
        int[] students = new int[n+1];

        for (int r : reserve) {
            students[r]++;
        }

        for (int l : lost) {
            students[l]--;
        }

        for (int i = 1; i <= n; i++) {
            if (students[i] == -1) {
                if (i > 1 && students[i - 1] == 1) {
                    // 앞 번호 학생이 여벌을 가지고 있다면 빌림
                    students[i]++;
                    students[i-1]--;
                } else if (i < n && students[i+1] == 1) {
                    // 뒷 번호 학생이 가지고 있다면 빌림
                    students[i]++;
                    students[i+1]--;
                }
            }
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (students[i] >= 0) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("전체 학생 수 n : ");
        int n = sc.nextInt();
        sc.nextLine(); // 개행 문자 삭제

        int x = 1;
        int y = 1;
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        System.out.println("lost 배열 값을 하나씩 입력하세요. 입력을 종료하려면 '!'를 입력하세요.");
        while (true) {
            System.out.print(x + "번째 학생 : ");
            String input = sc.nextLine();
            if (input.equals("!")) {
                break;
            }
            int number = Integer.parseInt(input);
            list1.add(number);
            x++;
        }

        System.out.println("reserve 배열 값을 하나씩 입력하세요. 입력을 종료하려면 '!'를 입력하세요.");
        while (true) {
            System.out.print(y + "번째 학생 : ");
            String input = sc.nextLine();
            if (input.equals("!")) {
                break;
            }
            int number = Integer.parseInt(input);
            list2.add(number);
            y++;
        }

        int[] lost = list1.stream().mapToInt(i -> i).toArray();
        int[] reserve = list2.stream().mapToInt(i -> i).toArray();

        int result = solution(n, lost, reserve);
        System.out.println("답 : " + result);
    }
}
