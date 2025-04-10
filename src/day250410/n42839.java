package day250410;

import java.util.*;

// 프로그래머스 소수 찾기 (42839)
/*
[문제 설명]
- 문자열 numbers가 주어질 때 각 자리를 조합하여 만들 수 있는 소수가 몇개인지 return
*/
public class n42839 {

    static Set<Integer> resultSet = new HashSet<>();

    private static int solution(String numbers) {
        boolean[] visited = new boolean[numbers.length()];
        dfs("", numbers, visited); // 모든 조합 구하기

        int count = 0;
        for (int num : resultSet) {
            if (isPrime(num)) count++;
        }

        return count;
    }

    private static void dfs(String current, String numbers, boolean[] visited) {
        if (!current.isEmpty()) {
            resultSet.add(Integer.parseInt(current));
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(current + numbers.charAt(i), numbers, visited);
                visited[i] = false; // 백트래킹
            }
        }
    }

    private static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("문자열 입력 : ");
        String numbers = sc.nextLine();

        int result = solution(numbers);
        System.out.print("답 : " + result);
    }
}
